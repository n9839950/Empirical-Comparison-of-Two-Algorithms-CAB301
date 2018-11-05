import java.util.Arrays;
import java.util.Random;

public class test04 {
	static Random r = new Random();
	static int operations = 0;
	static long execution;
	
	//ALGORITHM BruteForceMedian(A[0..n-1])
	// Returns the median value in a given array A of n numbers. This is
	// the kth element, where k = n/2, if the array was sorted.
	//
	//k ¡û |n/2|
	//for i in 0 to n-1 do
	// numsmaller ¡û 0 // How many elements are smaller than A[i]
	// numequal ¡û 0 // How many elements are equal to A[i]
	// for j in 0 to n-1 do
	//  if A[j] < A[i] then
	//   numsmaller ¡û numsmaller + 1
	//  else
	//  if A[j] = A[i] then
	//   numequal ¡û numequal + 1
	// if numsmaller < k and k ¡Ü (numsmaller + numequal) then
	//  return A[i]

	public static int BruteForceMedian(int[] A) {
		// TODO Auto-generated constructor stub
		int k = (int) Math.floor((A.length)/2);
		for (int i = 0; i < A.length; i++) {
			int numsmaller = 0;
			int numequal = 0;
			for (int j = 0; j < A.length; j++) {
				if (A[j] < A[i]) {
					numsmaller += 1;
					operations += 1;
				}else if (A[j] == A[i]) {
					numequal += 1;
					operations += 1;
				}
			}
			if (numsmaller-1 < k && k <= (numsmaller + numequal-1)) {
				return A[i];
			}
		}
		return A[0];
	}
	
	public static int[] randomArray(){  
		int len = r.nextInt(10)+1;
		int[] result = new int[len];
		for (int k = 0; k < result.length; k++) {
			result[k] = r.nextInt(100)+1;
		}  
		Arrays.sort(result);
	    return result;  
	}
	
	public static void printInfo(int[] A, int median, long execution) {	
		System.out.print("In the array {");
		for (int l = 0; l < A.length; l++) {
			if (l == A.length - 1) {
				System.out.print(A[l]);
			}else if (l < A.length - 1) {
				System.out.print(A[l] + ", ");
			}
		}		
		System.out.println("}\nMedian: " + median + "\nOperate times: " + operations + "\nExecute duration: " + execution);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = randomArray();
		
		long start = System.nanoTime();
		int median = BruteForceMedian(A);
		long execution = System.nanoTime() - start;
		
		printInfo(A, median, execution);
	}
}
