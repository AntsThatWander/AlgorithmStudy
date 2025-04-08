import java.io.*;
import java.util.Arrays;


class Main {
    private int row, col;
    private char[][] battle;
    private char[][] solution;

    public char[][] getBattle() {return this.battle;}

    public void input(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] tmp_line = br.readLine().split(" ");
            row = Integer.parseInt(tmp_line[0]);
            col = Integer.parseInt(tmp_line[1]);
            
            battle = new char[col][row];
            for(int i = 0; i < col; i++) {
                String battle_line = br.readLine();
                for(int j = 0; j < row; j++) {
                    battle[i][j] = battle_line.charAt(j);
                }
            }

            br.close();
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
    }

    public void solution(){
        solution = Arrays.copyOf(battle, battle.length);
        int white = 0;
        int black = 0;

        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                int sum = search(i, j, 'W');
                white += (sum * sum);

                int mus = search(i, j, 'B');
                black += (mus * mus);
            }
        }
        

        System.out.print(white + " " + black);
    }

    private int search(int i, int j, char c){
        int sum = 0;
        if(i < 0 || j < 0 || i >= col || j >= row) return sum;
        else if(solution[i][j] != c) return sum;
        
        solution[i][j] = '1';
        ++sum;
        return sum + search(i+1, j, c) + search(i, j+1, c) + search(i-1, j, c) + search(i, j-1, c);
    }



    public void read2DArray(char[][] o){
        for(char[] o2 : o){
            for(int i = 0; i < o2.length; i++){
                System.out.print(o2[i]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Main M = new Main();
        M.input();
        M.solution();
    }  
}