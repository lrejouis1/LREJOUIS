package FibonacciFunction;

import java.util.Scanner;

public class FibonacciF {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// inputing element of sequence
		System.out.print("Enter element sequence: ");

		int n = sc.nextInt();

		// Printing iteration and time
		System.out.println("Fibonacci iteration:");
		long start = System.currentTimeMillis();
		System.out.printf("Fibonacci sequence(element at index %d) = %d \n", n, fibIteration(n));

		System.out.printf("Time taken to recieve: %d ms\n", System.currentTimeMillis() - start);

		// Printing recursive method and start time
		System.out.println("Fibonacci recursion:");

		start = System.currentTimeMillis();

		System.out.printf("Fibonacci sequence(element at index %d) = %d \n", n, fibRecursion(n));

		System.out.printf("Time taken to recieve: %d ms\n", System.currentTimeMillis() - start);
		sc.close();
	}

	// Method to create iteration
	static int fibIteration(int n) {
		
		int x = 0, y = 1, z = 1;
		
		for (int i = 0; i < n; i++) {
			
			x = y;
			
			y = z;
			
			z = x + y;
			
		}
		return x;
	}

	//Method to create recursive iteration 
	static int fibRecursion(int n) {
		
		if ((n == 1) || (n == 0)) {
			
		return n;
		}
		return fibRecursion(n - 1) + fibRecursion(n - 2);
		
	}
}