import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int succeed = Integer.parseInt(st.nextToken());
            int lines = Integer.parseInt(st.nextToken());
            String[] people = new String[lines];
            Map<String, Integer> waiting = new HashMap<>();

            for (int i=0; i<lines; ++i) {
                people[i] = br.readLine();
            }

            for (int i=0; i<lines; ++i) {
                String person = people[i];
                waiting.put(person, i);
            }

            List<Map.Entry<String, Integer>> finalWaiting = new ArrayList<>(waiting.entrySet());
            finalWaiting.sort(Map.Entry.comparingByValue());

            int realSucceed = Math.min(succeed, finalWaiting.size());
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<realSucceed; ++i) {
                sb.append(finalWaiting.get(i).getKey());
                if (i+1 != realSucceed) {
                    sb.append("\n");
                }
            }
            System.out.println(sb);
            
        } catch (IOException ioe) {

        }
    }
}