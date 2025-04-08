import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
// 잘 모르겠어서 검색해본 문제.
// 핵심. GCD 이용해서 dx, dy를 서로소 관계로 만들어라 : 이는 dx, dy가 1초마다의 값을 주어지지만, 우리는 그 사이의 값을 이용할 수 있기 때문이다. 
// 그러나, 이동은 어떤 연속적인 함수가 아니라, 정수 단위로 이동한다(문제 조건). 따라서, 서로소 관계일 때의 값 단위가 최소 이동 거리임을 알 수 있다!
// 혹시 몰라 더 자세하게 적다면, 당연하게도 정수 단위에서는 서로소 관계일 때보다 더 작은 단위는 나올 수 없다. 
// 또한, 중간에 어떠한 dx, dy 값 변화가 없기 때문에 x와 y 이동 거리의 비율이 서로소 비율과 절대로 다를 수가 없다.

class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] posInput = br.readLine().split(" ");
            int xPos = Integer.parseInt(posInput[0]);
            int yPos = Integer.parseInt(posInput[1]);

            String[] moveInput = br.readLine().split(" ");
            int xBegin = Integer.parseInt(moveInput[0]);
            int yBegin = Integer.parseInt(moveInput[1]);
            int dx = Integer.parseInt(moveInput[2]);
            int dy = Integer.parseInt(moveInput[3]);

            int minXMoveDistance = dx / gcd(dx, dy);
            int minYMoveDistance = dy / gcd(dx, dy);

            double distance = Double.MAX_VALUE;
            while(true) {
                double tmpDistance = getDistance(xPos, yPos, xBegin, yBegin);
                if(tmpDistance > distance) {
                    System.out.println((xBegin-minXMoveDistance) + " " + (yBegin-minYMoveDistance));
                    break;
                }

                distance = tmpDistance;
                xBegin += minXMoveDistance;
                yBegin += minYMoveDistance; 
            }

        } catch (IOException ioe) {

        }
    }

    private static double getDistance(int xDes, int yDes, int xBegin, int yBegin) {
        double firstTerm = Math.pow(xDes - xBegin, 2);
        double secondTerm = Math.pow(yDes - yBegin, 2);
        return Math.sqrt(firstTerm + secondTerm);
    }

    private static int gcd(int a, int b) {
        int tmp = 0;
        a = Math.abs(a);
        b = Math.abs(b);
        while(b > 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
    

}