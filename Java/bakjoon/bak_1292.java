package Java.bakjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class bak_1292 {
    public void solution() throws IOException{
        // 1. 구간 시작과 끝 값 입력 받
        // 2. 시작 값에 맞는 숫자를 구함
        // 3. 구간 시작 + 숫자보다 작은 숫자가 될 때까지 출력!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        int startPosition = 1, curNumeric = 0;
        int sum = 0;
        
        for(int i = 0;;++i){
            startPosition += i;
            if(startPosition + i >= start){
                curNumeric = i + 1;
                break;
            }
        }

        int curPosition = start;
        while(curPosition <= end){
            if(curPosition++ > startPosition + curNumeric - 1){
                startPosition += curNumeric;
                ++curNumeric;
            }
            sum += curNumeric;
        }

        System.out.println(sum);

    }

    public static void main(String[] args){
        try {
            new bak_1292().solution();
        }
        catch(IOException ie){
            
        }
    }
    
}


/*
 * 1 -> 1 + 0
 * 2 3 -> 1 + 1
 * 4 5 6 -> 1 + 1 + 2
 * 7 8 9 10 -> 1 + 1 + 2 + 3
 * 11 12 13 14
 * 15 16 17 18 19
 * 
 */