import java.util.*;

/*
 * Christopher Kim
 * Competition problem solving by myself
 * First problem
 * ProblemOne calculates how many times numbers in a given interval can
 * go through 3n + 1 process. Then, it shows the user what was the highest 
 * iteration of 3n + 1 process. 
 * */
public class ThreeNOneProblem {
	
	public static void main (String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Please type in an interval separted by a single space.");
		String userInput = scn.nextLine();
		String[] interval;
		
		//Takes a string created by user's input using scanner.
		//Loops until the user types in "quit".
		//Calculates and prints the largest iteration of 3n + 1 process.  
		while (!userInput.equalsIgnoreCase("quit")) {
			interval = userInput.split(" ");
			int numIterations = findLargestIter(interval);
			System.out.println(numIterations);
			System.out.println("Please type in another interval or type quit to stop.");
			userInput = scn.nextLine();
		}
	}
	
	//Takes an string array as an interval, then calculates the largest iteration of 3n + 1 process.
	//It then returns the result (largest iteration).
	public static int findLargestIter(String[] interval) {
		int save = Integer.MIN_VALUE;
		int lo = Integer.parseInt(interval[0]);
		int hi = Integer.parseInt(interval[1]);
		
		//Iterate through all the numbers in the interval and count how many times that number lasted
		//and save that number in a variable.
		for (int i = lo; i <= hi; i++) {
			int check = countIter(i);
			if (save < check) {
				save = check;
			}
		}
		
		return save;
	}
	
	//Takes an int representing a number between the interval that is 
	//being iterated and performs 3n + 1 process. It then counts and
	//returns how many times the number lasted.
	public static int countIter (int num) {
		int count = 0;
		
		//As long as num is not 1 3n + 1 process continues and keeps counting.
		//If a number is divisible by 2, then divide by 2. If a number is not
		//divisible by 2, then multiply by 3 and add 1.
		while (num != 1) {
			int mod = num % 2;
			if (mod == 0) {
				num /= 2;
				count++;
			} else {
				num = 3 * num + 1;
				count++;
			}
		}
		
		//Fencepost (while loop is not going to count the last step)
		//Therefore, need to increment count by 1.
		count++;
		return count;
	}
	
}