import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseCount = 0;
        try {
            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int L = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());

                if (L == 0) {
                    break;
                }

                int fullUse = (V/P)*L;
                int lastUse = Math.min((V%P), L);

                StringBuilder sb = new StringBuilder();
                sb.append("Case ");
                sb.append(++caseCount);
                sb.append(": ");
                sb.append(fullUse + lastUse);
                System.out.println(sb);
            }
        } catch (IOException ioe) {

        }
    }
}