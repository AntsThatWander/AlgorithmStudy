import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int testcase = Integer.parseInt(br.readLine());
            PriorityQueue<Abs> pq = new PriorityQueue<>();
    
            for (int i=0; i<testcase; ++i) {
                int input = Integer.parseInt(br.readLine());

                if (input == 0) {
                    System.out.println(pq.isEmpty() ? 0 : pq.poll());
                    continue;
                }

                Abs data = new Abs(input);
                pq.add(data);
            }
        } catch (IOException ioe) {

        }
    }
    
}

class Abs implements Comparable<Abs> {
    private int data;
    
    public Abs(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    @Override
    public int compareTo(Abs other) {
        int mine = Math.abs(this.data);
        int others = Math.abs(other.getData());

        if (mine != others) {
            return (mine < others) ? -1 : 1;
        }

        return Integer.compare(this.data, other.getData());
    }

    @Override
    public String toString() {
        return ""+this.data;
    }
} 