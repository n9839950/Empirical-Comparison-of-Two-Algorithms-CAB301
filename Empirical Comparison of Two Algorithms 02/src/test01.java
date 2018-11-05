import java.util.Arrays;
import java.util.Random;

public class test01 {
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
			//operations += 1;
			return Select(A, 0, (int) Math.floor(A.length/2.0), A.length-1);
		}
	}
	
	//ALGORITHM Select(A[0..n-1], l, m, h)
	// Returns the value at index m in array slice A[l..h], if the slice
	// were sorted into nondecreasing order.
	//
	//pos �� Partition(A, l, h)
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
	// the ��pivot�� element formerly at location A[l] is placed.
	//
	//pivotval �� A[l] // Choose first value in slice as pivot value
	//pivotloc �� l // Location to insert pivot value
	//for j in l + 1 to h do
	// if A[j] < pivotval then
	//  pivotloc �� pivotloc + 1
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
		//operations += 1;
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
		//Arrays.sort(result);
	    return result;  
	}
	
	public static void printInfo(int[] A, int median, long execution) {	
		//System.out.print("In the array {");
		//for (int t = 0; t < A.length; t++) {
		//	if (t == A.length - 1) {
		//		System.out.print(A[t]);
		//	}else if (t < A.length - 1) {
		//		System.out.print(A[t] + ", ");
		//	}
		//}		
		//int[] B = A; 
		//Arrays.sort(B /*int[] B = A*/);
		System.out.print("Unsorted array {" + arrayPrint(A) /*+ "}\n Sorted array {" + arrayPrint(B*//*Arrays.sort(A)*//*)*/);
		System.out.println("}\nMedian: " + median + "\nOperate times: " + operations + "\nExecute duration: " + execution);
	}
	
	public static String arrayPrint(int[] A) {
		//int j = 123456;
		//String x = Integer.toString(j);
		//x = x.substring(0, 4) + "." + x.substring(4, x.length());
		String Elements ="";
		for (int t = 0; t < A.length; t++) {
			if (t == A.length - 1) {
				//System.out.print(A[t]);
				Elements = Elements + A[t];
			}else if (t < A.length - 1) {
				//System.out.print(A[t] + ", ");
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
