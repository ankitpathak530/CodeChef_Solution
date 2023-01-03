package Recursion;

public class Power {

	public static void main(String[] args) {
		System.out.println(calPower(2,4));
	}
	
	public static int calPower(int x,int n) {
		
		if(n == 0)
			return 1;
		
		
		int xpnb2 = calPower(x, n/2);
		int xn = xpnb2 * xpnb2;
		
		if(n%2 == 1) {    // example 1024 = 512 + 512 but for 1023 = 511 + 511 + 2
			xn = xn * x;
		}
		return xn;
	}
}


