package sort;

public class SelectionSort {

	public static void selectionSort(int[] A) {
		for (int i = 0; i < A.length; i++) {
			int min = i;
			for (int j = i; j < A.length; j++) {
				if (A[j] < A[min]) {
					min = j;
				}
			}
			int temp=A[i];
			A[i]=A[min];
			A[min]=temp;
			
		}
	}

}
