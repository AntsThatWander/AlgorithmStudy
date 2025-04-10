import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            while (true) {
                int tc = Integer.parseInt(br.readLine());
                if (tc == 0) {
                    break;
                }
                int sum = 0;
                for (int i=1; i<=tc; ++i) {
                    sum += i;
                }
                System.out.println(sum);
            }
            
        } catch (IOException ioe) {
            
        }
    }
}