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
                int x = Integer.parseInt(splitted[0]);
                int y = Integer.parseInt(splitted[1]);
                points[i][0] = x;
                points[i][1] = y;
            }

            double gradient = getGradient(points[0][0], points[1][0], points[0][1], points[1][1]);
            for (int i=1; i<3; ++i) {
                double curGradient = getGradient(points[i][0], points[(i+1)%3][0], points[i][1], points[(i+1)%3][1]);

                if (gradient != curGradient) {
                    System.out.println("WINNER WINNER CHICKEN DINNER!");
                    break;
                }

                if (i == 2) {
                    System.out.println("WHERE IS MY CHICKEN?");
                }
            }
        } catch (IOException ioe) {

        }
    }

    private static double getGradient(int x1, int x2, int y1, int y2) {
        int xDiff = x1 - x2;
        int yDiff = y1 - y2;

        return xDiff == 0 ? Double.POSITIVE_INFINITY : yDiff / (double)xDiff;
    }
}