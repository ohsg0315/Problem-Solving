import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;

        for (int i = 0; i < 32; i++) {
            if((n & (1 << i)) > 0) res++;

            if(res > 1) break;
        }

        if(res > 1) res = 0;
        System.out.println(res);
    }
}