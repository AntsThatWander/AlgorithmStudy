import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int[][] points = new int[3][2];


            for (int i=0; i<3; ++i) {
                String[] splitted = br.readLine().split(" ");
                points[i][0] = Integer.parseInt(splitted[0]);
                points[i][1] = Integer.parseInt(splitted[1]);
            }

            if (points[0][0] != points[1][0] && points[0][1] != points[1][1]) {
                System.out.println(1);
            } else {
                if ((points[0][0]==points[1][0] && points[1][0]==points[2][0] && isBetween(points[0][1], points[1][1], points[2][1])) || 
                    (points[0][1]==points[1][1] && points[1][1]==points[2][1] && isBetween(points[0][0], points[1][0], points[2][0]))) {
                    System.out.println(2);
                } else {
                    System.out.println(0);
                }
            }

            

        } catch (IOException ioe) {

        }
         
    }

    private static boolean isBetween(int p0, int p1, int p2) {
        if (p0 < p2 && p2 < p1) {
            return true;
        } else if (p0 > p2 && p2 > p1) {
            return true;
        }
        return false;
    }
}

