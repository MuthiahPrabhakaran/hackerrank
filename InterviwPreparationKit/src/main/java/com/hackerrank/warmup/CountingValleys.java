package com.hackerrank.warmup;

import java.util.Scanner;

public class CountingValleys {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String s = scanner.nextLine();
		int result = countingValleys(s);
		System.out.println(result);
		scanner.close();
	}
	static int countingValleys(String steps) {
		int v = 0;     // # of valleys
        int lvl = 0;   // current level
        for(char c : steps.toCharArray()){
            if(c == 'U') ++lvl;
            if(c == 'D') --lvl;
            // if we just came UP to sea level
            if(lvl == 0 && c == 'U')
                ++v;
        }
        return v;
	}

}


