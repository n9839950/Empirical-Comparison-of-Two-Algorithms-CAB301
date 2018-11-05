import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;


public class output_test02 {
	static Random r = new Random();
	static int operations = 0;
	static StringBuilder sb01 = new StringBuilder();

	public static int BruteForceMedian(int[] A) { 
		int k = (int) Math.ceil(A.length/2.0);
		if(k == A.length/2.0) {
			k++;
		}
		for (int i = 0; i < A.length; i++) {
			int numsmaller = 0;
			int numequal = 0;
			for (int j = 0; j < A.length; j++) {
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
		int median = BruteForceMedian(A);
		long execution = System.nanoTime() - start;
		
		sb01.append(arrayLength + ", " + arrayMax + ", " + operations + ", " + execution + "\n");
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter pw01 = new PrintWriter(new File("01_test.csv"));
		int maximanTime = 10000;
		sb01.append("Array Length" + ", " + "Array Max Value" + ", " + "Operation Times" + ", " + "Execute Duration" + "\n");
		
		for (int i = 1; i <= maximanTime; i += 9*i) {
			process(i, 10*i);
		}

        pw01.write(sb01.toString());
        pw01.close();
        System.out.println("done!");
	}

}
