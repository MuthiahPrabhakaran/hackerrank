package com.hackerrank.warmup;

import java.util.Scanner;

public class CountingValleys {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		int result = countingValleys(n, s);
		System.out.println(result);
		scanner.close();

	}

	static int countingValleys(int n, String steps) {

		int count = 0;
		int initialSeaLevelStepsCount = 0;
		int seaLevelCount = 0;

		if (steps.startsWith("U")) {
			initialSeaLevelStepsCount = ignoreTillSeaLevel(steps);
		}

		for (int i = initialSeaLevelStepsCount; i < steps.length(); i++) {
			if (new Character(steps.charAt(i)).compareTo('U') == 0) {
				seaLevelCount = seaLevelCount + 1;
			} else {
				seaLevelCount = seaLevelCount - 1;
			}
			if (seaLevelCount == 0) {
				count++;
			}
		}
		return count;

	}

	static int ignoreTillSeaLevel(String stepsTrack) {
		int seaLevelDistance = 1;
		int steps = 1;
		int valley = -1;
		for (int i = 1; i < stepsTrack.length(); i++, steps++) {
			if (seaLevelDistance == 0)
				break;
			if (new Character(stepsTrack.charAt(i)).compareTo('U') == 0) {
				seaLevelDistance += 1;
			} else {
				seaLevelDistance = seaLevelDistance + valley;
			}
		}
		return steps;
	}

}
