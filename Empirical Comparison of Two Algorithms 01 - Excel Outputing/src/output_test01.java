import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
//import java.io.File;  
//import java.io.FileInputStream;  
//import java.io.FileNotFoundException;  
//import java.io.IOException;  
//import java.io.InputStream;  
//import java.util.ArrayList;  
//import java.util.Iterator;  
//import java.util.List;  
//import org.apache.poi.hssf.usermodel.HSSFCell;  
//import org.apache.poi.hssf.usermodel.HSSFRow;  
//import org.apache.poi.hssf.usermodel.HSSFSheet;  
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;  
//import org.apache.poi.ss.usermodel.Cell;  
//import org.apache.poi.ss.usermodel.Row;  
//import org.apache.poi.ss.usermodel.Sheet;  
//import org.apache.poi.ss.usermodel.Workbook;  
//import org.apache.poi.ss.usermodel.WorkbookFactory;  
//import com.lmb.excel.bean.Employee; 

public class output_test01 {
	static Random r = new Random();
	static int operations = 0;
	//static int blankNumber = 0;
	static StringBuilder sb = new StringBuilder();

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
		//int length = r.nextInt(10)+1;
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
		
		//printInfo(A, median, execution);
		//blankNumber += 1;
		//System.out.println(/*A +*/ /*median +*/arrayLength + ", " + arrayMax + ", " + operations + ", " + execution);
		sb.append(arrayLength + ", " + arrayMax + ", " + operations + ", " + execution + "\n");
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter pw = new PrintWriter(new File("test.csv"));
		int maximanTime = 10000;
		
		//WritableWorkbook workbook = Workbook.createWorkbook(new File("output.xls"));
		//WritableSheet sheet = workbook.createSheet("First Sheet", 0);
		//Label label = new Label(0, 2, "A label record"); 
		//sheet.addCell(label); 
		//Number number = new Number(3, 4, 3.1459); 
		//sheet.addCell(number);
		
		for (int i = 1; i <= maximanTime; i += 9*i) {
			process(i, 10*i);
		}
		
		
        /*sb.append("id");
        sb.append(',');
        sb.append("Name");
        sb.append('\n');

        sb.append("1");
        sb.append(',');
        sb.append("Prashant Ghimire");
        sb.append('\n');*/

        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
	}

}
