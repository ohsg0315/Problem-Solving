import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(tokenizer.nextToken());
        int B = Integer.parseInt(tokenizer.nextToken());
        int V = Integer.parseInt(tokenizer.nextToken());

        int  dayClimb = A - B, totalDay = 0;

        V -= A;

        totalDay += Math.ceil((double)V / dayClimb);
        totalDay++;

        System.out.println(totalDay);
    } // end of main
} // end of class