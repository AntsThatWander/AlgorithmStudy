import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

// 해설 본 코드
// 확률 너무 싫어
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int testcase = Integer.parseInt(br.readLine());

            for (int i=0; i<testcase; ++i) {
                int clothes = Integer.parseInt(br.readLine());

                Map<String, Integer> clothComb = new HashMap<>();

                for (int j=0; j<clothes; ++j) {
                    String[] input = br.readLine().split(" ");
                    if (!clothComb.containsKey(input[1])) {
                        clothComb.put(input[1], 1);
                        continue;
                    }
                    clothComb.put(input[1], clothComb.get(input[1])+1);
                }

                int comb = 1;
                for (String cloth :clothComb.keySet()) {
                    comb *= clothComb.get(cloth) + 1;
                }
                System.out.println(comb-1);


            }
        } catch (IOException ioe) {

        }
    }
}
