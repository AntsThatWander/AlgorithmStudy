import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            while(true) {
                int testcase = Integer.parseInt(br.readLine());
                if (testcase == 0) {
                    break;
                }
                List<String> dict = new ArrayList<>();

                for (int i=0; i<testcase; ++i) {
                    String input = br.readLine();
                    dict.add(input);
                }

                dict.sort(new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return s1.toLowerCase().compareTo(s2.toLowerCase());
                    }
                });

                System.out.println(dict.get(0));

            }
            

        }
        catch(IOException ie){

        }
    }
    
}