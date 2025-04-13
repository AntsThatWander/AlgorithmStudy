import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] splitted = br.readLine().split(" ");
            int lines = Integer.parseInt(splitted[0]);
            int distance = Integer.parseInt(splitted[1]);
            int[] cows = new int[lines];
            int max = -1;
            for (int i=0; i<lines; ++i) {
                cows[i] = Integer.parseInt(br.readLine());
            }

            for (int i=0; i<lines; ++i) {
                int cur = cows[i];

                for(int j=i+1; j<=Math.min(i+distance,lines-1); ++j) {
                    if (cur == cows[j]) {
                        max = Math.max(max, cur);
                    }
                }
            }

            System.out.println(max);
        } catch (IOException ioe) {

        }
    }
}
