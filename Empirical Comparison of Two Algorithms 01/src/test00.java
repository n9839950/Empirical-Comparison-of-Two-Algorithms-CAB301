import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class test00 {
	static int operations = 0;
	
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
				return A[i+1];
			}//else(return (Integer) null;)
		}
		//return 0;
		//return A[i];
		//return (Integer)null
		return A[0];
	}
	
	public static int[] randomArray(/*int min,int max,int n*/){ 
		int max = new Random().nextInt(100); 
		int min = new Random().nextInt(100); 
		int len = new Random().nextInt(10)+1;
		while (min >= max) {
			max = new Random().nextInt(100); 
			min = new Random().nextInt(100);
		};
		int[] result = new int[len];
		for (int j = 0; j < result.length; j++) {
			result[j] = Math.abs(new Random().nextInt() % (max-min)) + min;
		}  
		Arrays.sort(result);
	    return result;  
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int B[] = {11, 12, 13, 14, 15};
		int C[] = {16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
		int D[] = randomArray(/*0, 100, 10*/);
		
		long start = System.nanoTime();
		System.out.println("The median of the input/random aray is " + BruteForceMedian(D));
		long execution = System.nanoTime() - start;
		System.err.println(execution);
		System.out.println("Operation times :" + operations);
		System.out.print("In the array {");
		for (int k = 0; k < D.length; k++) {
			if (k == D.length - 1) {
				System.out.print(D[k]);
			}else if (k<D.length - 1) {
				System.out.print(D[k] + ", ");
			}
		}
		System.out.println("}");
	}
}
