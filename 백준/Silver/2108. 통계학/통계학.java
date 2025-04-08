import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int testcase = Integer.parseInt(br.readLine());
            List<Integer> numbers = new ArrayList<>();
            

            for (int i = 0; i < testcase; ++i) {
                numbers.add(Integer.parseInt(br.readLine()));
            }
            
            int average = 0;
            average = numbers.stream().mapToInt(Integer::intValue).sum();
            System.out.println((int)Math.round(average/(double)testcase));

            numbers.sort(Comparator.naturalOrder());
            System.out.println(numbers.get(testcase/2));
            
            Map<Integer, Integer> counts = new HashMap<>();
            for (int i : numbers) {
                if (counts.containsKey(i)) {
                    counts.put(i, counts.get(i)+1);
                    continue;
                }
                counts.put(i, 1);
            }
            List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(counts.entrySet());
            entryList.sort(Comparator.comparing(Map.Entry<Integer, Integer>::getValue, Comparator.reverseOrder())
                    .thenComparing(Map.Entry::getKey));
            
            if (testcase > 1 && entryList.get(0).getValue() == entryList.get(1).getValue()) {
                System.out.println(entryList.get(1).getKey());
            } else {
                System.out.println(entryList.get(0).getKey());
            }

            System.out.println(numbers.get(testcase-1) - numbers.get(0));

        } catch (IOException ioe) {

        }
    }
}