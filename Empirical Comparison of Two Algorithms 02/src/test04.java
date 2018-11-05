import java.util.Arrays;
import java.util.Random;

public class test04 {
	static Random r = new Random();
	static int operations = 0;
	static long execution;

	//ALGORITHM Median(A[0..n-1])
	// Returns the median value in a given array A of n numbers.
	//
	//if n = 1 then
	// return A[0]
	//else
	// return Select(A, 0,|n/2|, n-1) // NB: The third argument is rounded down
	public static int Median(int[] A) {
		// TODO Auto-generated constructor stub
		if (A.length==1) {
			operations += 1;
			return A[0];
		}else {
			return Select(A, 0, (int) Math.floor(A.length/2.0), A.length-1);
		}
	}
	
	//ALGORITHM Select(A[0..n-1], l, m, h)
	// Returns the value at index m in array slice A[l..h], if the slice
	// were sorted into nondecreasing order.
	//
	//pos ¡û Partition(A, l, h)
	//if pos = m then
	// return A[pos]
	//if pos > m then
	// return Select(A, l, m, pos-1)
	//if pos < m then
	// return Select(A, pos+1, m, h)
	public static int Select(int[] A, int l, int m, int h) {
		int pos = Partition(A, l, h);
		if (pos == m) {
			operations += 1;
			return A[pos];
		}
		if (pos > m) {
			operations += 1;
			return Select(A, l, m, pos-1);
		}
		if (pos < m) {
			operations += 1;
			return Select(A, pos+1, m, h);
		}
		return 0;
	}
	
	//ALGORITHM Partition(A[0..n-1], l, h)
	// Partitions array slice A[l..h] by moving element A[l] to the position
	// it would have if the array slice was sorted, and by moving all
	// values in the slice smaller than A[l] to earlier positions, and all values
	// larger than or equal to A[l] to later positions. Returns the index at which
	// the ¡®pivot¡¯ element formerly at location A[l] is placed.
	//
	//pivotval ¡û A[l] // Choose first value in slice as pivot value
	//pivotloc ¡û l // Location to insert pivot value
	//for j in l + 1 to h do
	// if A[j] < pivotval then
	//  pivotloc ¡û pivotloc + 1
	//  swap(A[pivotloc], A[j]) // Swap elements around pivot
	//swap(A[l], A[pivotloc]) // Put pivot element in place
	//return pivotloc
	public static int Partition(int[] A, int l, int h) {
		int pivotval = A[l];
		int pivotloc = l;
		for (int o = l+1 ; o <= h; o++) {
			if (A[o] < pivotval) {
				pivotloc += 1;
				swap(A[pivotloc], A[o]);
				operations += 1;
			}
		}
		swap(A[l], A[pivotloc]);
		return pivotloc;
	}

	private static void swap(int p, int q) {
		// TODO Auto-generated method stub
		int s = p;
		p = q;
		q = s;
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
		int[] B = A; 
		medianPointer(A);
		//int blankNum = 12; //length of the string "original array {"
		//for (int u = 0; u < Math.floor(A.length/2.0); u++) {
		//	if (A[u]/10.0 == 10.0) {
		//		blankNum += 5;
		//	}else if(A[u]/10.0 >= 1.0) {
		//		blankNum += 4;
		//	}else if(A[u]/10.0 < 1.0) {
		//		blankNum += 3;
		//	}
		//}
		//if (A.length % 2 != 0/*A.length % 2 == 0*/) { //odd length
		//	//blankNum += 14;
		//	blankNum += 4;
		//}//else { //even length
		////	blankNum += 18;
		////}
		//int mid = Median(A);//A[(int) Math.ceil(A.length/2.0)];
		//if (/*A[(int) Math.ceil(A.length/2.0)]*/ mid >= 100) {
		//	blankNum += 3;
		//}else if (/*A[(int) Math.ceil(A.length/2.0)]*/mid < 100 && /*A[(int) Math.ceil(A.length/2.0)]*/mid >= 10) {
		//	blankNum += 2;
		//}else if (/*A[(int) Math.ceil(A.length/2.0)]*/mid < 10) {
		//	blankNum += 1;
		//}
		//for (int v = 0; v < blankNum; v++) {
		//	System.out.print(",");
		//}
		//System.out.println("¡ý");
		System.out.print("Original array { " + arrayPrint(A)); 
		Arrays.sort(B);
		System.out.print(" }\n  Sorted array { " + arrayPrint(B));
		System.out.println(" }\nMedian: " + median + "\nOperate times: " + operations + "\nExecute duration: " + execution);
	}
	
	public static void medianPointer(int[] A) {
		int blankNum = 12;
		//int midLoc = 0;
		for (int u = 0; u < Math.floor(A.length/2.0); u++) {
			if (A[u]/10.0 == 10.0) {
				blankNum += 5;
			}else if(A[u]/10.0 >= 1.0) {
				blankNum += 4;
			}else if(A[u]/10.0 < 1.0) {
				blankNum += 3;
			}
		}
		if (A.length % 2 != 0) {
			blankNum += 4;
			//midLoc = (int) (A.length/2.0 - 0.5);
		}//else {
		//	midLoc = A.length/2;
		//}
		int midLoc = (int) Math.ceil(A.length/2.0);
		//int mid = 0;//A[(int) Math.ceil(A.length/2.0)];
		//if (midLoc != 0) {
			//mid = A[midLoc];
		//	midLoc -= 1;
		//}//else {
		//	mid = A[midLoc+1];
		//}
		int mid = A[midLoc-1];
		//int mid = A[(int) Math.ceil(A.length/2.0)];//Median(A);
		if (mid /*>=*//*Median(A)*/ == 100) {
			blankNum += 3;
		}else if (mid /*Median(A)*/ < 100 && mid /*Median(A)*/ >= 10) {
			blankNum += 2;
		}else if (mid/*Median(A)*/ < 10) {
			blankNum += 1;
		}
		for (int v = 0; v < blankNum; v++) {
			System.out.print(",");
		}
		System.out.println("¡ý");
	}
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = randomArray();
		
		long start = System.nanoTime();
		int median = Median(A);
		long execution = System.nanoTime() - start;
		
		printInfo(A, median, execution);
	}

}
