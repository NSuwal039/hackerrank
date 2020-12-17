import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FraudulentTry1 {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int total = 0;
        int median = 0;

        for (int i = d; i<expenditure.length; i++){
            int[] trailing = Arrays.copyOfRange(expenditure,i-d, i-1);
            Arrays.sort(trailing);
            median = (d%2==0)? ((trailing[(d/2)-1]+trailing[d/2])/2):trailing[(d/2)];
            System.out.println(median);
            total = (expenditure[i]>=2*median)? total+1:total;

        }

        return total;
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
