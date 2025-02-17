package Java.bakjoon;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int testCaseCount = Integer.parseInt(br.readLine());

            for (int i = 0; i < testCaseCount; ++i) {
                String[] positions = br.readLine().split(" ");
                int startPosition = Integer.parseInt(positions[0]);
                int endPosition = Integer.parseInt(positions[1]);
                int distance = endPosition - startPosition;

                int squareRoot = Main.getSquareRoot(distance); // distance가 n^2마다 1 || 1 + 2 + 1 || 1 + 2 + 3 + 2 + 1 로 2(n-1)+1 씩 항 개수가 늘어난다. 
                // 수학적으로 n^2마다 저 공식이 나온다는 것을 증명할 수 있다. 대충 2sigma(1, n-1)i + n 계산하면 n^2 나온다.

                if (distance == (int)Math.pow(squareRoot, 2)) {
                    System.out.println(2 * (squareRoot - 1) + 1);
                    continue;
                } // n ^ 2 일 때.

                if (distance >= (int)(Math.pow(squareRoot, 2) + squareRoot + 1)) {
                    System.out.println(2 * (squareRoot - 1) + 3);
                    continue;
                } // n^2 + n + 1일 때. 이 경우는 1 + 2 + 2 + 1 같은 경우로, 여기서도 다음은 무조건 항이 하나가 늘어나야 한다. 
                //대신, n^2+1에서 늘어난 항 다음이라 +1을 더해야 하는데, 이 케이스가 범위가 더 작기 때문에 n^2+1보다 먼저 검사한다.

                if (distance >= (int)(Math.pow(squareRoot, 2) + 1)) {
                    System.out.println(2 * (squareRoot - 1) + 2);
                    continue;
                } // n^2 + 1. n^2 다음도 무조건 항이 하나 늘어날 수밖에 없다.

                
            }
        } catch (IOException io) {

        }
    }

    public static int getSquareRoot(int distance) {
        double sqrt = Math.sqrt(distance);
        return (int)(sqrt - (sqrt % 1));
    }
}

public class bak_1011{
    
}