import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;


enum Direction {
    Left, Right, Up, Down,
}

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int[] box = new int[row*col];
            int[] chk = new int[row*col];
            int max = 0;

            Queue<Integer> bfs = new LinkedList<>();

            for (int i=0; i<row; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<col; ++j) {
                    int token = Integer.parseInt(st.nextToken());
                    int location = getLocation(i, col, j);
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

            while (!bfs.isEmpty()){
                int curLoc = bfs.poll(); 
                max = Math.max(max, chk[curLoc]);
                int tmpMax = chk[curLoc]+1;
                int nextLoc = 0;

                for (Direction direction: Direction.values()) {
                    nextLoc = getDirection(curLoc, col, direction);
                    if (canGoChk(curLoc, row, col, chk, nextLoc, direction)) {
                        chk[nextLoc] = tmpMax;
                        bfs.add(nextLoc);
                    }
                }
            }

            for (int i=0; i<row*col; ++i) {
                if (chk[i] == -1) {
                    max = -1;
                    break;
                }
            }

            System.out.println(max);

        } catch (IOException ioe) {

        } 
    }

    private static int getLocation(int index, int col, int jndex) {
        return index * col + jndex;
    }

    private static int getDirection(int location, int col, Direction direction) {
        switch (direction) {
            case Left:
                return location - 1;
            case Right:
                return location + 1;
            case Up:
                return location - col;
            case Down:
                return location + col;
            default:
                return location;
        }
    }

    private static boolean canGo(int curLoc, int row, int col, Direction direction) {
        if (direction == Direction.Left) {
            return curLoc % col != 0;
        }

        if (direction == Direction.Right) {
            return (curLoc + 1) % col != 0;
        }

        if (direction == Direction.Up) {
            return curLoc - col >= 0 ;
        }

        if (direction == Direction.Down) {
            return curLoc + col < row * col;
        }

        return false;
    }

    private static boolean canGoChk(int curLoc, int row, int col, int[] chk, int nextLoc, Direction direction) {
        return canGo(curLoc, row, col, direction) && chk[nextLoc] == -1;
    }
}
