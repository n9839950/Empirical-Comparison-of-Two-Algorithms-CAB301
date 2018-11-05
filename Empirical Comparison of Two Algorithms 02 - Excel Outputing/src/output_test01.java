import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class output_test01 {
	static Random r = new Random();
	static int operations = 0;
	static StringBuilder sb02 = new StringBuilder();

	public static int Median(int[] A) {
		if (A.length==1) {
			operations += 1;
			return A[0];
		}else {
			return Select(A, 0, (int) Math.floor(A.length/2.0), A.length-1);
		}
	}
	
	public static int Select(int[] A, int l, int m, int h) {
		int pos = Partition(A, l, h);
		if (pos == m) {
			return A[pos];
		}
		if (pos > m) {
			return Select(A, l, m, pos-1);
		}
		if (pos < m) {
			return Select(A, pos+1, m, h);
		}
		return 0;
	}

	public static int Partition(int[] A, int l, int h) {
		int pivotval = A[l];
		int pivotloc = l;
		for (int o = l+1 ; o <= h; o++) {
			operations += 1;
			if (A[o] < pivotval) {
				pivotloc += 1;
				swap(A[pivotloc], A[o]);
			}
		}
		swap(A[l], A[pivotloc]);
		return pivotloc;
	}

	private static void swap(int p, int q) {
		int s = p;
		p = q;
		q = s;
	}

	public static int[] randomArray(int length, int max){  
		int[] result = new int[length];
		for (int k = 0; k < result.length; k++) {
			result[k] = r.nextInt(max)+1;
		}
	    return result;  
	}
	
	public static void process(int arrayLength, int arrayMax) {
		int A[] = randomArray(arrayLength, arrayMax);
		
		long start = System.nanoTime();
		int median = Median(A);
		long execution = System.nanoTime() - start;
		
		sb02.append(arrayLength + ", " + arrayMax + ", " + operations + ", " + execution + "\n");
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter pw02 = new PrintWriter(new File("02_test.csv"));
		int maximanTime = 100000000;
		sb02.append("Array Length" + ", " + "Array Max Value" + ", " + "Operation Times" + ", " + "Execute Duration" + "\n");
		
		for (int i = 1; i <= maximanTime; i += 9*i) {
			process(i, 10*i);
		}

        pw02.write(sb02.toString());
        pw02.close();
        System.out.println("done!");
	}

}
