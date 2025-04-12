import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int testcase = Integer.parseInt(br.readLine());
            int[][] fibo = fibo();
            StringBuilder sb = new StringBuilder();
 
            for (int i=0; i<testcase; ++i) {
                int num = Integer.parseInt(br.readLine());
                sb.append(fibo[num][0]);
                sb.append(" ");
                sb.append(fibo[num][1]);
                if (i+1 != testcase) {
                    sb.append('\n');
                }
                
            }
            System.out.println(sb);
            br.close();
        } catch (IOException ioe) {

        }
    }

    private static int[][] fibo() {
        int[][] fibo = new int[41][2];
        fibo[0] = new int[] {1, 0};
        fibo[1] = new int[] {0, 1};

        for (int i=2; i<41; ++i) {
            fibo[i][0] = fibo[i-2][0] + fibo[i-1][0];
            fibo[i][1] = fibo[i-2][1] + fibo[i-1][1];
        }


        return fibo;
    }
}