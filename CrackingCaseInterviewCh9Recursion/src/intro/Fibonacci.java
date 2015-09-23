package intro;

public class Fibonacci {

	//runtime 2^n
	public static int fibonacci(int n) {
		if (n == 1) return 1;
		if (n == 0) return 0;
		else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
	
	//runtime n
	public static int fibonacci2(int n) {
		int[] fib = new int[n + 1];
		return fibonacci2(n, fib);
	}
	
	public static int fibonacci2(int n, int[] fib) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		if(fib[n] != 0) return fib[n];
		fib[n] = fibonacci2(n-1, fib) + fibonacci2(n-2, fib);
		return fib[n];
	}
	
	public static void main(String[] args) {
	
		System.out.println(fibonacci(4));
	}
}
