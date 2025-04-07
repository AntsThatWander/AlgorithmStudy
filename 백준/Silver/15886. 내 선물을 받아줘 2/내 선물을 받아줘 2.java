import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int length = Integer.parseInt(br.readLine());
            String movement = br.readLine();
            char top = 'a';
            int cnt = 0;

            for (int i=0; i<length; ++i) {
                char move = movement.charAt(i);
                if (move == 'W' && top == 'E') {
                    ++cnt;
                }
                top = move;
            }

            System.out.println(cnt);
        } catch (IOException ioe) {

        }
    }

}