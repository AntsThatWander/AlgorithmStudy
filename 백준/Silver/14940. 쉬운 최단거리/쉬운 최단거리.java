import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

// 틀렸던 점 : 대부분 저번에 맞아놓고 헷갈려 하다니, 아직 멀었다는 것이다.
// position 계산. i * col + j로 column을 곱해야 한다. 그게 가로 크기니까.
// 이동 position 계산. 모든 조건 비교는 column 기준으로 해야 된다. 그게 가로 크기니까.
// 0 처리가 이상. 안 닿아버리면 0도 -1이 되니, 그냥 0으로 채워넣기.
public class Main {

    enum Direction {
        Up() {
            @Override
            public int getPosition(int row, int col, int position) {
                if (position >= col) {
                    return position - col;
                }
                return -1;
            }
        }, 
        
        Down() {
            @Override
            public int getPosition(int row, int col, int position) {
                if (position < (row-1) * col) {
                    return position + col;
                }
                return -1;
            }
        }, 
        
        Left() {
            @Override
            public int getPosition(int row, int col, int position) {
                if (position % col != 0) {
                    return position - 1;
                }
                return -1;
            }
        }, 
        
        Right() {
            @Override
            public int getPosition(int row, int col, int position) {
                if (position % col != col - 1) {
                    return position + 1;
                }
                return -1;
            }
        };

        Direction() {}


        abstract public int getPosition(int row, int col, int position);
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            int[] map = new int[row * col];
            int[] chk = new int[row * col];

            int masterPos = 0;

            for (int i=0; i<row; ++i) {

                st = new StringTokenizer(br.readLine());

                for (int j=0; j<col; ++j) {
                    int value = Integer.parseInt(st.nextToken());
                    int position = getPosition(i, col, j);
                    int chkVal = value == 0 || value == 2 ? 0 : -1; // value == 0 : 기존 출력값, value == 2 : 목적지 거리 0
                    if (value == 2) {
                        masterPos = position;
                    } 
                    map[position] = value;
                    chk[position] = chkVal;
                }
            }

            Queue<Integer> bfsQueue = new LinkedList<>();
            bfsQueue.add(masterPos);

            while(!bfsQueue.isEmpty()) {
                int curPos = bfsQueue.poll();
                int addedVal = chk[curPos]+1;

                
                for (Direction direction: Direction.values()) {
                    int nextPos = direction.getPosition(row, col, curPos);
                    if (nextPos != -1 && chk[nextPos] == -1 && map[nextPos] != 0) {
                        chk[nextPos] = addedVal;
                        bfsQueue.add(nextPos);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<row; ++i) {
                for (int j=0; j<col; ++j) {
                    int pos = getPosition(i, col, j);
                    int chkVal = chk[pos];

                    sb.append(chkVal);
                    if (j!=col-1) {
                        sb.append(" ");
                    }
                }
                sb.append("\n");
            }

            System.out.println(sb);


        } catch (IOException ioe) {

        }
    }

    private static int getPosition(int i, int col, int j) {
        return i * col + j;
    }


}
