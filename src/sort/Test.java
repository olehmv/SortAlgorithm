package sort;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] a = { 2, 3, 1, 5, 8, 7, 9, 10, 4, 6 };
		System.out.println(factorialR(5));
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(find3IndexWithMInV(a)));
		System.out.println(lcm(a));
	}
	public static void sortB(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}

			}
		}
	}
	public static void sortS(int a[]) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
	}
	public static void sortI(int a[]) {
		for (int i = 1; i < a.length; i++) {
			int key = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
	}
	public static int[] find3IndexWithMInV(int a[]) {
		int firstIndex = 0;
		int secondIndex = 0;
		int thirdIndex = 0;
		int fMin = Integer.MAX_VALUE;
		int sMin = Integer.MAX_VALUE;
		int tMin = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < fMin) {
				tMin = sMin;
				sMin = fMin;
				fMin = a[i];
				thirdIndex = secondIndex;
				secondIndex = firstIndex;
				firstIndex = i;
			}
			if (a[i] < sMin && a[i] > fMin) {
				tMin = sMin;
				sMin = a[i];
				thirdIndex = secondIndex;
				secondIndex = i;
			}
			if (a[i] < tMin && a[i] > sMin) {
				tMin = a[i];
				thirdIndex = i;
			}
		}
		return new int[] { firstIndex, secondIndex, thirdIndex };
	}
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static int gcd(int a[]) {
		int result = a[0];
		for (int n : a)
			result = gcd(result, n);
		return result;
	}
	public static int  lcm(int a,int b){
		return (a*b)/gcd(a,b);
	}
	public static int lcm(int a[]){
		int smallest=a[0];
		for(int n:a)smallest=lcm(smallest,n);
		return smallest;
	}
	public static void fibonacci(int n){
		int first=0;
		int second=1;
		int next=0;
		while(n>0){
			System.out.println(next);
			first=second;
			second=next;
			next=first+second;
			n--;
		}
	}
	public static int fibonacciR(int n)  {
	    if(n == 0)
	        return 0;
	     if(n <= 2)
	      return 1;
	      return fibonacciR(n - 1) + fibonacciR(n - 2);
	}
	public static int factorial(int n){
		int result=1;
		while(n>0){
			result=result*n;
			n--;
		}
		return result;
	}
	public static int factorialR(int n){
		return (n<1)?1:n*factorialR(n-1);
	}

}
