package com;

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
		// infoOfCurrentProcess();
		infoOfLiveProcesses();
	}

}
