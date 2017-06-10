package sort;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] a = { 2, 3, 5, 1, 6, 8, 7, 9, };

		// bublesort(a);
//		 selectionsort(a);
		// insertionsort(a);
		 Arrays.stream(findThreeIndexWithMinValue(a)).forEach(System.out::println);
		 
		// fibonacci(8);
//		System.out.println(multiple(10,20, 30));
//		System.out.println(lcm(10, 20));
//		System.out.println(gcd(2, 4));
	}

	public static void bublesort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] < a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	public static void selectionsort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int max = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] > a[max]) {
					max = j;
				}
			}
			int temp = a[i];
			a[i] = a[max];
			a[max] = temp;
		}

	}

	public static void insertionsort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int key = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] < key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
	}

	public static int factorial(int n) {
		int result = 1;
		while (n > 0) {
			result = result * n;
			n--;
		}
		return result;
	}

	public static void fibonacci(int n) {
		int first = 0;
		int second = 1;
		int next = 0;
		while (n > 0) {
			System.out.println(next);
			first = second;
			second = next;
			next = first + second;
			n--;
		}
	}

	public static int multiple(int... a) {
		int smalest = Arrays.stream(a).min().getAsInt();
		for (int i = 0; i < a.length; i++) {
			smalest = lcm(a[i], smalest);
		}
		return smalest;
	}

	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
	public static int[] findTwoHighest(int[] array)
	{
	    int max = Integer.MIN_VALUE;
	    int secondMax = Integer.MIN_VALUE;

	    for (int value:array)
	    {
	        if (value > max)
	        {
	            secondMax = max;
	            max = value;
	        }
	        else if (value > secondMax && value < max)
	        {
	            secondMax = value;
	        }
	    }
	    return new int[] { max, secondMax };
	}
	public static int[] findThreeHighest(int[] array)
	{
	    int max = Integer.MIN_VALUE;
	    int secondMax = Integer.MIN_VALUE;
	    int thriedMax = Integer.MIN_VALUE;
	   

	    for (int value:array)
	    {
	        if (value > max)
	        {
	        	thriedMax=secondMax;
	            secondMax = max;
	            max = value;
	        }
	        else if (value > secondMax && value < max)
	        {
	        	thriedMax=secondMax;
	            secondMax = value;
	        }
	        else if (value > thriedMax && value < secondMax)
	        {
	        	thriedMax = value;
	        }
	    }
	    return new int[] { max, secondMax,thriedMax};
	}
	
	public static int[] findTwoLowest(int[] array)
	{
	    int max = Integer.MAX_VALUE;
	    int secondMax = Integer.MAX_VALUE;

	    for (int value:array)
	    {
	        if (value < max)
	        {
	            secondMax = max;
	            max = value;
	        }
	        else if (value < secondMax && value > max)
	        {
	            secondMax = value;
	        }
	    }
	    return new int[] { max, secondMax };
	}
	public static int [] findTwoIndexWithHeigthValue(int [] a){
		int firstMax=Integer.MIN_VALUE;
		int secondMax=Integer.MIN_VALUE;
		int firstIndex=0;
		int secondIndex=0;
		for(int i=0;i<a.length;i++){
			if(a[i]>firstMax){
				secondMax=firstMax;
				firstMax=a[i];
				secondIndex=firstIndex;
				firstIndex=i;
			}else if(a[i]>secondMax&&a[i]<firstMax){
				secondMax=a[i];
				secondIndex=i;
			}
		}
		return new int [] {firstIndex,secondIndex};
	}
	public static int [] findThreeIndexWithMaxValue(int [] a){
		int firstMax=Integer.MIN_VALUE;
		int secondMax=Integer.MIN_VALUE;
		int thirdMax=Integer.MIN_VALUE;
		int firstIndex=0;
		int secondIndex=0;
		int thirdIndex=0;
		for(int i=0;i<a.length;i++){
			if(a[i]>firstMax){
				thirdMax=secondMax;
				secondMax=firstMax;
				firstMax=a[i];
				thirdIndex=secondIndex;
				secondIndex=firstIndex;
				firstIndex=i;
				
			}else if(a[i]>secondMax&&a[i]<firstMax){
				thirdMax=secondMax;
				secondMax=a[i];
				thirdIndex=secondIndex;
				secondIndex=i;
				
			}else if(a[i]>thirdMax&&a[i]<secondMax){
				thirdMax=a[i];
				thirdIndex=i;
			}
		}
		return new int []{firstIndex,secondIndex,thirdIndex};
	}
	public static int [] findThreeIndexWithMinValue(int [] a){
		int firstMin=Integer.MAX_VALUE;
		int secondMin=Integer.MAX_VALUE;
		int thirdMin=Integer.MAX_VALUE;
		int firstIndex=0;
		int secondIndex=0;
		int thirdIndex=0;
		for(int i=0;i<a.length;i++){
			if(a[i]<firstMin){
				thirdMin=secondMin;
				secondMin=firstMin;
				firstMin=a[i];
				thirdIndex=secondIndex;
				secondIndex=firstIndex;
				firstIndex=i;
			}else if(a[i]<secondMin&&a[i]>firstMin){
				thirdMin=secondMin;
				secondMin=a[i];
				thirdIndex=secondIndex;
				secondIndex=i;
			}else if(a[i]<thirdMin&&a[i]>secondMin){
				thirdMin=a[i];
				thirdIndex=i;
			}
			
		}
		return new int [] {firstIndex,secondIndex,thirdIndex};
		
	}
	

}

