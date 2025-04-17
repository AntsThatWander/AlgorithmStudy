import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
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

            Stack<ZArray> myCallStack = new Stack<>();
            myCallStack.add(new ZArray(n, row, col));

            while(!myCallStack.isEmpty()) {
                ZArray zArray = myCallStack.pop();

                if (zArray.getN() == 1) {
                    sequence += zArray.getRow() * 2 + zArray.getCol();
                    continue;
                }

                int tmpN = zArray.getN() - 1;
                int prevPowLine = (int)Math.pow(2, tmpN);
                int prevPowBox = (int)Math.pow(prevPowLine, 2);

                int rowQuotient = zArray.getRow() / prevPowLine;
                int colQuotient = zArray.getCol() / prevPowLine;
                int nMoved = prevPowBox * rowQuotient * 2 + prevPowBox * colQuotient;
                sequence += nMoved;

                int rowRemain = zArray.getRow() % prevPowLine;
                int colRemain = zArray.getCol() % prevPowLine;
                myCallStack.add(new ZArray(tmpN, rowRemain, colRemain));
            }

            System.out.println(sequence);

        } catch (IOException ioe) {

        }
    }

}

class ZArray {
    private int n;
    private int row;
    private int col;

    public ZArray(int n, int row, int col) {
        this.n = n;
        this.row = row;
        this.col = col;
    }

    public int getN() {
        return n;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}