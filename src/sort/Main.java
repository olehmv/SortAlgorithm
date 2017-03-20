package sort;

import java.math.BigInteger;
import java.util.Arrays;

import multiple.Multiple;

public class Main {

	public static void main(String[] args) {
		int[] A = { 4, 5, 3, 2, 1, 6 };
//		BubbleSort.bubbleSort(A);
		InsertionSort.insertionSort(A);
//		SelectionSort.selectionSort(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}
		System.out.println(Multiple.multiple1(BigInteger.valueOf(50), BigInteger.valueOf(10)));
		
		System.out.println(Multiple.multiple(new int[]{7,5,58}));
		BigInteger smallest = BigInteger.ONE;
		for (int i = 1; i < 20; i++) {
			smallest = Multiple.multiple1(BigInteger.valueOf(i), smallest);
		}
		System.out.println(smallest);
	}

}
