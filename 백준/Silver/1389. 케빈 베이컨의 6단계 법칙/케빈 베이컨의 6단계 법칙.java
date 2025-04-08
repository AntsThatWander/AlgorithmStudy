import java.util.Scanner;
import java.util.Arrays;

class Main{
    private int users, relations;
    private int[][] graph;

    public static final int INF = 2147483646;


    private void input(){
        Scanner scan = new Scanner(System.in);

        users = scan.nextInt();
        relations = scan.nextInt();

        graph = new int[users][users];

        for(int i = 0; i < users; i++) {
            Arrays.fill(graph[i], INF);
        }


        for(int i = 0; i < relations; i++) {
            int a, b;
            a = scan.nextInt();
            b = scan.nextInt();

            graph[a-1][b-1] = 1;
            graph[b-1][a-1] = 1;
        }

        scan.close();
    }

    private void solution(){
        for(int k = 0; k < users; k++){
            for(int i = 0; i < users; i++){
                for(int j = 0; j < users; j++){
                    graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int min = INF;
        int min_node = 0;
        for(int i = 0; i < users; i++){
            int sum = 0;
            for(int j = 0; j < users; j++){
                if(i == j) continue;
                sum += graph[i][j];
            }

            if(sum < min) {
                min = sum;
                min_node = i + 1;
            }
        }

        System.out.println(min_node);
    }

    private int min(int a, int b){
        if(a < 0) return b;
        else if(b < 0) return a;
        return (a > b) ? b : a;
    }


    public static void main(String[] args){

        Main p = new Main();
        p.input();
        p.solution();
    }
}