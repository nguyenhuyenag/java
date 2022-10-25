package com;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void infoOfCurrentProcess() {
		ProcessHandle processHandle = ProcessHandle.current();
		ProcessHandle.Info processInfo = processHandle.info();
		System.out.println("PID: " + processHandle.pid());
		System.out.println("Arguments: " + processInfo.arguments());
		System.out.println("Command: " + processInfo.command());
		System.out.println("Instant: " + processInfo.startInstant());
		System.out.println("Total CPU duration: " + processInfo.totalCpuDuration());
		System.out.println("User: " + processInfo.user());
	}

	public static void infoOfLiveProcesses() {
		Stream<ProcessHandle> liveProcesses = ProcessHandle.allProcesses();
		liveProcesses.filter(ProcessHandle::isAlive).forEach(ph -> {
			System.out.println("PID: " + ph.pid());
			System.out.println("Instance: " + ph.info().startInstant());
			System.out.println("User: " + ph.info().user());
		});
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		List strings = IntStream.rangeClosed(1, 10_000_000).mapToObj(Integer::toString).collect(Collectors.toList());

		long totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Generated " + strings.size() + " strings in " + totalTime + " ms.");

		startTime = System.currentTimeMillis();

		String appended = (String) strings.stream().limit(100_000).reduce("", (l, r) -> l.toString() + r.toString());

		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Created string of length " + appended.length() + " in " + totalTime + " ms.");
	}

}
