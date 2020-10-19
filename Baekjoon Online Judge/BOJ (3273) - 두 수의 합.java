import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int goal = Integer.parseInt(br.readLine()), res = 0;

        Arrays.sort(arr);

        int low = 0, high = n - 1;

        while(low < high){
            int sum = arr[low] + arr[high];

            if(sum < goal){
                low++;
            }else if(sum > goal){
                high--;
            }else if(sum == goal){
                res++;
                low++;
            }
        }
        System.out.println(res);
    } // end of main
}