import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int testcase = Integer.parseInt(br.readLine());
            String[] lines = new String[testcase];

            for (int i=0; i<testcase; ++i) {
                lines[i] = br.readLine();
            }

            StringBuilder sb = new StringBuilder();
            for (String line : lines) {
                sb.append(repeatPerLine(line, true));
                sb.append("\n");
                sb.append(repeatPerLine(line, false));
                sb.append("\n");
            }
            sb.delete(sb.length()-1, sb.length());
            System.out.println(sb);
            br.close();
        } catch(IOException ioe) {

        }
    }
    
    private static String repeatPerLine(String line, boolean isStart) {
        if (line.length()==1) {
            return line;
        }

        StringBuilder sb = new StringBuilder();

        int startIndex = isStart ? 0 : 1;
        String usedLine = line.length()%2==0 ? line : line.repeat(2);

        for (int i=startIndex; i<usedLine.length(); i+=2) {
            sb.append(usedLine.charAt(i));
        }

        return sb.toString();
    }

}