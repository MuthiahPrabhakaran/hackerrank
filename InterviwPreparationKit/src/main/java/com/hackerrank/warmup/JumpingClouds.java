package com.hackerrank.warmup;

import java.util.Scanner;

public class JumpingClouds {
	static int jumpingOnClouds(int[] c) {
		int jumps = 0;
		int nextJump = 0;
		if (c.length <= 2) {
			if (c[0] == 0 && c[1] == 0)
				jumps++;
		} else {
			for (int i = 0; i < c.length - 1; i = nextJump) {
				nextJump = nextJumpingSpaceCalc(c[i + 2], i);
				jumps++;
				if ((nextJump < c.length - 1) && (nextJump + 2) > c.length - 1) {
					if (c[nextJump] == 0 && c[nextJump + 1] == 0) {
						jumps++;
					}
					break;
				}
			}
		}
		return jumps;
	}

	static int nextJumpingSpaceCalc(int secondDigitFromCurrent, int currentLocation) {
		if (secondDigitFromCurrent == 1) {
			currentLocation += 1;
		} else {
			currentLocation += 2;
		}
		return currentLocation;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		int[] c = new int[n];
		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}
		int result = jumpingOnClouds(c);
		System.out.println(result);
		scanner.close();
	}
}
