import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

enum Direction {
    Left, Right, Up, Down, Above, Below,
}

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int gap = Integer.parseInt(st.nextToken());
            int[] box = new int[row*col*gap];
            int[] chk = new int[row*col*gap];
            int max = 0;

            Queue<Integer> bfs = new LinkedList<>();

            for (int i=0; i<gap; ++i) {
                for (int j=0; j<row; ++j) {
                    st = new StringTokenizer(br.readLine());
                    for (int k=0; k<col; ++k) {
                        int token = Integer.parseInt(st.nextToken());
                        int location = getLocation(i, row, j, col, k);
                        box[location] = token;
                        
                        if (token == 1) {
                            chk[location] = 0;
                            bfs.add(location);
                            continue;
                        }
                        if (token == -1) {
                            chk[location] = -2;
                            continue;
                        }
                        chk[location] = -1;
                    }
                }
            }
            

            while (!bfs.isEmpty()){
                int curLoc = bfs.poll(); 
                max = Math.max(max, chk[curLoc]);
                int tmpMax = chk[curLoc]+1;
                int nextLoc = 0;
                for (Direction direction: Direction.values()) {
                    nextLoc = getDirection(curLoc, row, col, direction);
                    if (canGoChk(curLoc, row, col, gap, chk, nextLoc, direction)) {
                        chk[nextLoc] = tmpMax;
                        bfs.add(nextLoc);
                    }
                }
            }

            if(Arrays.stream(chk).anyMatch(com -> com==-1)) {
                max = -1;
            }

            System.out.println(max);

        } catch (IOException ioe) {

        } 
    }

    private static int getLocation(int index, int row, int jndex, int col, int kndex) {
        return index * (row*col) + jndex * col + kndex;
    }

    private static int getDirection(int location, int row, int col, Direction direction) {
        switch (direction) {
            case Left:
                return location - 1;
            case Right:
                return location + 1;
            case Up:
                return location - col;
            case Down:
                return location + col;
            case Above:
                return location - row*col;
            case Below:
                return location + row*col;
            default:
                return location;
        }
    }

    private static boolean canGo(int curLoc, int row, int col, int gap, Direction direction) {
        if (direction == Direction.Left) {
            return curLoc % col != 0;
        }

        if (direction == Direction.Right) {
            return (curLoc + 1) % col != 0;
        }

        if (direction == Direction.Up) {
            return curLoc - col >= row * col * (curLoc / (row * col)) ;
        }

        if (direction == Direction.Down) {
            return curLoc + col < row * col * (curLoc / (row * col) + 1);
        }

        if (direction == Direction.Above) {
            return curLoc - row*col >= 0;
        }

        if (direction == Direction.Below) {
            return curLoc + row*col < row * col * gap;
        }

        return false;
    }

    private static boolean canGoChk(int curLoc, int row, int col, int gap, int[] chk, int nextLoc, Direction direction) {
        return canGo(curLoc, row, col, gap, direction) && chk[nextLoc] == -1;
    }
}