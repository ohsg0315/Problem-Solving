import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()), a = 0, b = 0;
        String s = br.readLine();

        for (int i = 0; i < N; i++) {
            if(s.charAt(i) == 'A') a++;
            else b++;
        }
        if(a > b) System.out.println('A');
        else if (a < b) System.out.println('B');
        else System.out.println("Tie");
    }
}