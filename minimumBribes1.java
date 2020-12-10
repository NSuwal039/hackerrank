import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class minimumBribes1 {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int l = q.length;
        int diff =0;
        boolean flag = false;
        for (int i =0; i <q.length; i++){

            if (q[i]>i){
                if (q[i]-i == 2 || q[i]-i==3){
                    diff+=q[i]-i-1;
                    System.out.println("diff= "+diff + "i=" + i);
                }else if (q[i]-i>3){
                    flag=true;
                    System.out.println("i=" + i + " chaotic here");
                }
            }
        }

        if (flag==false){
            System.out.println(diff);
        }else {
            System.out.println("Too Chaotic");
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
