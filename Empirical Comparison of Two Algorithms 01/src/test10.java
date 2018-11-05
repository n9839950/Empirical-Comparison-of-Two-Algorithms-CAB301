import java.util.Arrays;
import java.util.Random;

public class test10 {
	static Random r = new Random();
	static int operations = 0;
	//static long execution;
	
	//ALGORITHM BruteForceMedian(A[0..n-1])
	// Returns the median value in a given array A of n numbers. This is
	// the kth element, where k = n/2, if the array was sorted.
	//
	//k �� |n/2|
	//for i in 0 to n-1 do
	// numsmaller �� 0 // How many elements are smaller than A[i]
	// numequal �� 0 // How many elements are equal to A[i]
	// for j in 0 to n-1 do
	//  if A[j] < A[i] then
	//   numsmaller �� numsmaller + 1
	//  else
	//  if A[j] = A[i] then
	//   numequal �� numequal + 1
	// if numsmaller < k and k �� (numsmaller + numequal) then
	//  return A[i]

	public static int BruteForceMedian(int[] A) {
		// TODO Auto-generated constructor stub
		int n = A.length; ///A[0].length;
		int k = (int) Math.ceil(n/2.0);
		//k = k+1;
		for (int i = 0; i <= n-1; i++) {
			int numsmaller = 0;
			int numequal = 0;
			for (int j = 0; j <= n-1; j++) {
				operations += 1;
				if (A[j] < A[i]) {
					numsmaller += 1;
				}else if (A[j] == A[i]) {
					numequal += 1;
				}
			}
			if (numsmaller < k && k <= (numsmaller + numequal)) {
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
	    return result;  
	}
	
	public static void printInfo(int[] A, int median, long execution) {		
		int[] B = A.clone(); 
		//medianPointer(A);
		Arrays.sort(B);
		System.out.print("Original array { " + arrayPrint(A) + " }\n  Sorted array { " + arrayPrint(B));
		System.out.println/*ln*/(" }\nMedian: " + median + ", Operate times: " + operations + ", Execute duration: " + execution + "\n");
	}
	
	//public static void medianPointer(int[] A) {
	//	int blankNum = 12;
	//	for (int u = 0; u < Math.floor(A.length/2.0); u++) {
	//		if (A[u]/10.0 == 10.0) {
	//			blankNum += 5;
	//		}else if(A[u]/10.0 >= 1.0) {
	//			blankNum += 4;
	//		}else if(A[u]/10.0 < 1.0) {
	//			blankNum += 3;
	//		}
	//	}
	//	if (A.length % 2 != 0) {
	//		blankNum += 4;
    //
	//	}
	//	int midLoc = (int) Math.ceil(A.length/2.0);
	//	int mid = A[midLoc-1];
	//	if (mid == 100) {
	//		blankNum += 3;
	//	}else if (mid < 100 && mid >= 10) {
	//		blankNum += 2;
	//	}else if (mid < 10) {
	//		blankNum += 1;
	//	}
	//	for (int v = 0; v < blankNum; v++) {
	//		System.out.print(" ");
	//	}
	//	System.out.println("��");
	//}
	
	public static String arrayPrint(int[] A) {
		String Elements ="";
		for (int t = 0; t < A.length; t++) {
			if (t == A.length - 1) {
				Elements = Elements + A[t];
			}else if (t < A.length - 1) {
				Elements = Elements + A[t] + ", ";
			}
		}
		return Elements;
	}
	
	public static void process() {
		int A[] = randomArray();
		//int B[] = A.clone();
		//Arrays.sort(B);
		
		long start = System.nanoTime();
		int median = BruteForceMedian(A);
		long execution = System.nanoTime() - start;
		
		printInfo(A, median, execution);
		//double Math.ceil((A.length)/2.0);
		//System.out.println(Math.ceil((A.length)/2.0) /*+ "\n\n"*/);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int times = 10;
		
		long start = System.nanoTime();
		for (int w = 0; w < times; w++) {
			process();
		}
		long execution = System.nanoTime() - start;
		
		System.err.println("\nTotal run time\t" + execution);
		
	}
}
