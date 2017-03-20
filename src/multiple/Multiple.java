package multiple;

import java.math.BigInteger;
import java.util.Arrays;

public class Multiple {
	public static int multiple(int ... A){
		BigInteger smallest=BigInteger.valueOf(Arrays.stream(A).min().getAsInt());
		for (int i = 0; i < A.length; i++) {
			smallest = Multiple.multiple1(BigInteger.valueOf(A[i]), smallest);
		}
		return smallest.intValue();
	}
	public static BigInteger multiple1(BigInteger x,BigInteger y){
		
		return x.divide(x.gcd(y)).multiply(y);
	}
	
	public static boolean multiple(double n){
	for(int i=1;i<=10;i++){
			if(n%i!=0){
				return false;
			}
	}
	return true;	
	}
	
}