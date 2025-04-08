import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int testcase = Integer.parseInt(br.readLine());
            List<String> words = new ArrayList<>();
            for (int i=0; i<testcase; ++i) {
                words.add(br.readLine());
            }

            words.sort(new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    if (s1.length() != s2.length()) {
                        return s1.length() - s2.length();
                    }
                    return s1.compareTo(s2);
                }
            });
        
            
            List<String> longest = new ArrayList<>(words);

            for (int i=0; i<testcase; ++i) {
                String selected = words.get(i);
                for (int j=i+1; j<testcase; ++j) {
                    String compared = words.get(j);
                    if (compared.matches("^"+selected+".*")) {
                        longest.remove(selected);
                        break;
                    }
                }
            }
            
        System.out.println(longest.size());
            
        } catch(IOException ioe) {

        }
    }
}