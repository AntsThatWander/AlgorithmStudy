package bakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bak_1085 {

    public void solution() throws IOException {
        //1. 변의 길이를 저장하고, 그에 맞게 배열을 하나 만든다.
        //2. for문을 4번 반복 : input 점에서 끝까지 계산하고, 최대값을 갱신한다.

        int horizontal_end, vertical_end;
        int horizontal_cur, vertical_cur;
        int min = 9999;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splitted = input.split(" ");
        horizontal_cur = Integer.parseInt(splitted[0]);
        vertical_cur = Integer.parseInt(splitted[1]);
        horizontal_end = Integer.parseInt(splitted[2]);
        vertical_end = Integer.parseInt(splitted[3]);

        min = Math.min(horizontal_cur, Math.min(vertical_cur, Math.min(horizontal_end - horizontal_cur, vertical_end - vertical_cur)));

        System.out.println(min);
        
    }
    

    public static void main(String[] args) throws IOException{
        bak_1085 solution = new bak_1085();
        solution.solution();
    }
}
