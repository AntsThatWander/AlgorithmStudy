import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String input = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (char alphabet='a'; alphabet<='z'; ++alphabet) {
                int index = input.indexOf(alphabet);
                sb.append(index);
                if (alphabet!='z') {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        } catch (IOException ioe) {

        }
    }
}