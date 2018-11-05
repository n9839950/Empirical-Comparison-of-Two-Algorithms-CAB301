import java.util.Arrays;
import java.util.Random;

public class test02 {
	static Random r = new Random();
	static int operations = 0;
	static long execution;
	static int A[] = randomArray();
	
	//ALGORITHM BruteForceMedian(A[0..n-1])
	//Returns the median value in a given array A of n numbers. This is
	//the kth element, where k = n/2, if the array was sorted.
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
		long start = System.nanoTime();
		int k = Math.abs((A.length)/2);
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
			if (numsmaller < k && k <= (numsmaller + numequal)) {
				execution = System.nanoTime() - start;
				return A[i];
			}
		}
		execution = System.nanoTime() - start;
		return A[0];
	}
	
	public static int[] randomArray(){  
		int len = r.nextInt(10)+1;
		int[] result = new int[len];
		for (int j = 0; j < result.length; j++) {
			result[j] = r.nextInt(100)+1;
		}  
		Arrays.sort(result);
	    return result;  
	}
	
	public static void printInfo(int[] A) {
		System.out.print("Median of the array: " + BruteForceMedian(A)+ "\nIn the array {");	
		for (int k = 0; k < A.length; k++) {
			if (k == A.length - 1) {
				System.out.print(A[k]);
			}else if (k<A.length - 1) {
				System.out.print(A[k] + ", ");
			}
		}		
		System.out.println("}\nOperate times: " + operations);
		System.err.println(execution);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printInfo(A);
	}
}
