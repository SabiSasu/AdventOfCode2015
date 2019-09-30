package day01;

import java.util.Scanner;

//DAY 1
public class Find_level {

	public static void main(String[] args) {
		Scanner inputString = new Scanner(System.in);
		String levels = inputString.next();
		int level = 0;
		int basement = 0;
		for(int i = 0; i < levels.length(); i++) {
			if(levels.substring(i, i+1).equals("("))
				level++;
			else
				level--;
			
			if (level == -1) {
				basement = i + 1;
				System.out.println(basement);
			}
		}
		
		System.out.println(basement);

	}

}
