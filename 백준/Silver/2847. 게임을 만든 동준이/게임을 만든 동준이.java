import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int testcase = Integer.parseInt(br.readLine());
        int[] scores = new int[testcase];

        for (int i=0; i<testcase; ++i) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int reduce = 0;
        for (int i=testcase-2; i>=0; --i) {
            if (scores[i] >= scores[i+1]) {
                int toReduce = Math.abs(scores[i+1] - scores[i]) + 1;
                scores[i] -= toReduce;
                reduce += toReduce;
            }

        }
        System.out.println(reduce);
        br.close();

    }
}