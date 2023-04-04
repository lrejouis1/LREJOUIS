package randomNumbers;

import java.util.Random;

public class ParallelArr {
	private int[] arr;

	private int varBeginningIndex;

	private int varEndingIndex;

	private long varIndexValue;
	
	
	

	public ParallelArr(int[] arr, int varBeginningIndex, int varEndingIndex) {
		this.arr = arr;
		this.varBeginningIndex = varBeginningIndex;
		this.varEndingIndex = varEndingIndex;
	}

	public long getIndexValue() {
		return varIndexValue;
	}
	private static int[] generateRandomArray(int indexSize, int min, int max) {

		int[] arr = new int[indexSize];

		Random random = new Random();

		for (int i = 0; i < indexSize; i++) {

			arr[i] = random.nextInt(max - min + 1) + min;
		}
		return arr;
	}

	public void run() {
		for (int i = varBeginningIndex; i < varEndingIndex; i++) {

			varIndexValue = arr[i] + 1;
			add(varIndexValue);
		}
	}

	private void add(long varIndexValue2) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {

		int[] arr = generateRandomArray(200000000, 1, 5000);
		int numberOfThreads = Runtime.getRuntime().availableProcessors();

		Thread[] threads = new Thread[numberOfThreads];
		ParallelArr[] sums = new ParallelArr[numberOfThreads];

		int threadLength = arr.length / numberOfThreads;

		double start = System.currentTimeMillis();

		for (int i = 0; i < numberOfThreads; i++) {

			sums[i] = new ParallelArr(arr, i * threadLength, (i + 1) * threadLength);
			
			threads[i] = new Thread();
			
			threads[i].start();
		}

		long parallelSum = 0;

		try {
			for (int i = 0; i < numberOfThreads; i++) {
				
				threads[i].join();
				parallelSum += sums[i].getIndexValue();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		double end = System.currentTimeMillis();

		System.out.println("Parallel sum = " + parallelSum);
		System.out.println("Time taken in milliseconds: " + (end - start) );

		start = System.currentTimeMillis();

		long singleThreadSum = 0;

		for (int i = 0; i < arr.length; i++) {
			singleThreadSum += arr[i];
		}

		end = System.currentTimeMillis();

		System.out.println("Single thread sum = " + singleThreadSum);
		System.out.println("Time taken in milliseconds: " + (end - start) );
	}

	
}
