import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int testcase = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int odd = 0;
            int even = 0;
            int minOdd = Integer.MAX_VALUE;

            while (st.hasMoreTokens()) {
                int candy = Integer.parseInt(st.nextToken());

                if (candy % 2 == 0) {
                    even += candy;
                    continue;
                }

                odd += candy;
                minOdd = Math.min(minOdd, candy);
            }

            if (odd % 2 == 1) {
                odd -= minOdd;
            }

            System.out.println(even + odd);
        } catch (IOException ioe) {

        }
    }
}