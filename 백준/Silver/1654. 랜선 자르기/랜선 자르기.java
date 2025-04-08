import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] splitted = br.readLine().split(" ");
            int have = Integer.parseInt(splitted[0]);
            int need = Integer.parseInt(splitted[1]);

            List<Integer> lans = new ArrayList<>();

            for (int i=0; i<have; ++i) {
                lans.add(Integer.parseInt(br.readLine()));
            }

            lans.sort(Comparator.naturalOrder());

            solution(need, lans);


        } catch (IOException ioe) {

        }
    }

    private static void solution(int need, List<Integer> lans) {
        int left = 1;
        int right = lans.get(lans.size()-1);

        System.out.println(binarySearch(lans, left, right, need));

    } 

    private static long binarySearch(List<Integer> lans, long left, long right, int need) {
        if (left > right) {
            return -1;
        }

        long mid = left + (right - left) / 2;
        long sum = 0;
        
        for (int lan : lans) {
            long quotient = getQuotient(lan, mid);
            sum += quotient;
        }
        
        if (sum < need) {
            return binarySearch(lans, left, mid-1, need);
        }

        return Math.max(mid, binarySearch(lans, mid+1, right, need));
    }


    private static long getQuotient(long lan, long length) {
        return lan/length;
    }

    
}