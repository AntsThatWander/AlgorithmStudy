import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int testcase = Integer.parseInt(br.readLine());
            List<String> vocab = new ArrayList<>();

            for (int i=0; i<testcase; ++i) {
                vocab.add(br.readLine());
            }

            vocab.sort(new Comparator<String>(){
                @Override
                public int compare(String p1, String p2) {
                    if (p1.length() != p2.length()) {
                        return p1.length() > p2.length() ? 1 : -1;
                    }
                    return p1.compareTo(p2);
                }
            });
            vocab = vocab.stream().distinct().collect(Collectors.toList());
            vocab.forEach(element -> System.out.println(element));
        } catch (IOException ioe) {

        }
    }
}