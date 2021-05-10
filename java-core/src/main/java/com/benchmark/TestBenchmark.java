//package com.benchmark;
//
//import org.apache.commons.lang3.StringUtils;
//
//import com.google.caliper.Runner;
//import com.google.caliper.SimpleBenchmark;
//
//public class TestBenchmark extends SimpleBenchmark {
//
//	String str = "111222111222";
//
//	public int timeM1(int n) {
//		int res = 0;
//		for (int x = 0; x < n; x++) {
//			res += str.replace("111", "333").length();
//		}
//		return res;
//	}
//
//	public int timeM2(int n) {
//		int res = 0;
//		for (int x = 0; x < n; x++) {
//			res += StringUtils.replace(str, "111", "333").length();
//		}
//		return res;
//	}
//
//	public static void main(String[] args) {
//		Runner.main(TestBenchmark.class, args);
//	}
//}