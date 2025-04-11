import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        try {
            boolean doKeep = true;
            int input = Integer.parseInt(br.readLine());
            sb.append(String.format("%04d", input));
            int cnt = 0;
            int[] check = new int[10000];
            Arrays.fill(check, 0);
            check[input] = 1;

            while (doKeep) {
                int extracted = 10 * (sb.charAt(1) - '0') + (sb.charAt(2) - '0');
                int squared = (int)Math.pow(extracted, 2);
                
                ++cnt;
                if (check[squared] == 1) {
                    System.out.println(cnt);
                    break;
                }
                check[squared] = 1;
                sb.delete(0, sb.length());
                sb.append(String.format("%04d", squared));
            }
        } catch (IOException ioe) {

        }
    }
}