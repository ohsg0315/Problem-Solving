import javax.lang.model.type.PrimitiveType;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), res = 0;

        for (int i = 1; i * i <= n; i++) {
            res++;
        }
        System.out.print(res);
    } // end of main
}