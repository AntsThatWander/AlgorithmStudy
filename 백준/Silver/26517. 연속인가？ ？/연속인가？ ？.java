import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            long k = Long.parseLong(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long left = func(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()), k);
            long right = func(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()), k);

            if (left == right) {
                System.out.println("Yes "+left);
            } else {
                System.out.println("No");
            }
        } catch (IOException ioe) {

        }
    }

    private static long func(long a, long b, long k) {
        return a * k + b;
    }
}
