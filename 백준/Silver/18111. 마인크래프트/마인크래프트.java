import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] splitted = br.readLine().split(" ");
            int row = Integer.parseInt(splitted[0]);
            int col = Integer.parseInt(splitted[1]);
            int inventory = Integer.parseInt(splitted[2]);

            int[][] home = new int[row][col];

            int min = Integer.MAX_VALUE;
            int max = 0;
            int blocks = inventory;

            for (int i=0; i<row; ++i) {
                String[] inputSplitted = br.readLine().split(" ");

                for (int j=0; j<col; ++j) {
                    int point = Integer.parseInt(inputSplitted[j]);
                    home[i][j] = point;
                    blocks += point;
                }
            }

            max = blocks / (row*col);

            int goodTime = Integer.MAX_VALUE;
            int goodLevel = 256;

            for (int i=0; i<=max; ++i) {
                int curTime = 0;
                int curLevel = i;
                
                for (int j=0; j<row; ++j) {
                    for (int k=0; k<col; ++k) {
                        int point = home[j][k];
                        if (point >= i) {
                            curTime += (point - i) * 2;
                        } else {
                            curTime += (i - point);
                        }
                    }
                }

                if ((curTime < goodTime) || (curTime == goodTime && curLevel > goodLevel)) {
                    goodTime = curTime;
                    goodLevel = curLevel;
                }
            }
            
            System.out.println(goodTime + " " + goodLevel);

        } catch (IOException ioe) {

        }
    }
    
}