package bakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bak_2903 {

    public void solution(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int value = Integer.parseInt(br.readLine());
            int base = (int)Math.pow(2, value) + 1;
            int result = (int)Math.pow(base, 2);
            System.out.println(result);
        }
        catch(IOException ie){
            
        }
    }


    public static void main(String[] args){
        (new bak_2903()).solution();
    }
    
}


// 0. 4 = 2
// 1. 9 = 3
// 2. 25 = 5
// 3. 81 = 9