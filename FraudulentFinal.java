import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FraudulentFinal {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int total =0;

        int[] sorted = new int[201];
        for (int i=0; i<d ; i++){
            sorted[expenditure[i]]++;
        }

        for (int i =d; i< expenditure.length; i++){
            double median = findMedian(d, sorted);

            if (expenditure[i]>=2*median){
                total++;
            }

            sorted[expenditure[i-d]]--;
            sorted[expenditure[i]]++;
        }
        return total;
    }

    private static double findMedian (int d, int[] data){
        double median = 0;

        if (d%2==0) {
            Integer a = null;
            Integer b = null;
            int count = 0;

            for (int j=0; j< data.length; j++){
                count+=data[j];
                if (a==null && count>=d/2){
                    a=j;
                }
                if (b==null && count>=d/2 + 1){
                    b=j;
                    break;
                }
            }
            median=(a+b)/2.0;
        }else {
            int count =0;
            for (int i = 0; i < data.length; i++) {
                count+= data[i];

                if (count > d/2){
                    median=i;
                    break;
                }
            }
        }

        return median;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt (nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
