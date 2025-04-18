import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            int sequence = 0;

            // N=n일 때, 2^(n-1) * 2^(n-1) 박스 4개로 나눈 후, 1번째 박스에 있다고 가정하면서 문제를 푼다.
            // 예를 들어, N=2일 때, (3,1) -> (1,1)로 이동한다.
            // 이때, 반드시 이동한만큼 순서 값을 보정해줘야 하는데, 이 공식이 nMoved이다.
            
            // 이동 및 보정할 때 row와 col을 따로 계산하는데, 좌표값 이동은 %로 하며, 한 line별이므로 2^(n-1)로만 계산하는 것이다.
            // 또 보정은 line별로 /를 하고, 2^(n-1) * 2^(n-1)로 추가로 보정한다.
            
            // 설명이 개판이니 예시를 하나 써놓겠다.
            // N=2 일 때, (3,1)이라고 하자
            // (3,1) -> (1,1)로 이동시킨다고 하자.
            // 이떄, 위치 이동은 2^(n-1)을 나눈 나머지로 한다. 즉, 2^(2-1)로 나눈 나머지로 (3%2, 1%1)로 이동.
            // 이동 값 보정은 3/2, 1/2 -> 1, 0을 한 후, 2^(2-1)*2^(2-1)=4를 이용해 보정한다. 식은 아래와 같다.
            // 2(Z자 이동이어서 row값이 비중이 더 크고, 그 값에 대한 비율) * 4(위 2^(2-1)*2^(2-1)) * 1(3/2로 얻은 값) + 4(위 2^(2-1)*2^(2-1)) * 0(1/1로 얻은 값)
            // 왜 몫을 구하는고 하니 박스를 크게 4등분했을 때 (0n,0n) (0n,1n) (1n,0n) (1n,1n) 에서 n을 제거하려고 하는 것.
            // 나머지는 위에도 설명했다시피 4등분했을 때 등분된 사각형에서 어디 위치에 있는지 파악하는 용도
            for (int i=n; i>=1; --i) {
                if (i == 1) {
                    sequence += row * 2 + col;
                    continue;
                }

                int tmpN = i - 1;
                int prevPowLine = (int)Math.pow(2, tmpN);
                int prevPowBox = (int)Math.pow(prevPowLine, 2);

                int rowQuotient = row / prevPowLine;
                int colQuotient = col / prevPowLine;
                int nMoved = prevPowBox * rowQuotient * 2 + prevPowBox * colQuotient;
                sequence += nMoved;

                int rowRemain = row % prevPowLine;
                int colRemain = col % prevPowLine;
                row = rowRemain;
                col = colRemain;
            }

            System.out.println(sequence);

        } catch (IOException ioe) {

        }
    }

}