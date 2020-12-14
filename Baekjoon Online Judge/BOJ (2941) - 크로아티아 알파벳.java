import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] convert = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String ss : convert) {
            s = s.replaceAll(ss, "a");
        }
        System.out.println(s.length());
    } // end of main
}