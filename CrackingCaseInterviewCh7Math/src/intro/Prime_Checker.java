package intro;

public class Prime_Checker {

	// We only have to check up to sqrt of n because we have already checked all possible solutions through
	// the values complement (we don't have to check if 7*9 and 9*7 equal 63)
	public static boolean isPrime(int n) {
		if (n < 2) return false;
		
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 20; i++) {
			System.out.println(i + ": " + isPrime(i));
		}
	}
}
