package Java.bakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.IntStream;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Main {
    enum Option {DFS, BFS}
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String buffer = br.readLine();
            String[] splitted = buffer.split(" ");
            int nodes = Integer.parseInt(splitted[0]);
            int edges = Integer.parseInt(splitted[1]);
            int start = Integer.parseInt(splitted[2]);

            int[][] tree = IntStream.range(0, nodes)
                                    .mapToObj(v1 -> IntStream.range(0, nodes)
                                                            .map(v2 -> -1)
                                                            .toArray())
                                    .toArray(int[][]::new);
            
            for (int i = 0; i < edges; ++i) {
                buffer = br.readLine();
                splitted = buffer.split(" ");

                int row = Integer.parseInt(splitted[0]) - 1;
                int col = Integer.parseInt(splitted[1]) - 1;

                tree[row][col] = 1;
                tree[col][row] = 1;

            }

            traversal(Option.DFS, tree, nodes, start);
            traversal(Option.BFS, tree, nodes, start);
        } catch (IOException io) {

        }
    }

    public static void traversal(Option option, int[][] tree, int nodes, int node) {
        int[] visited = IntStream.range(0, nodes).map(v -> 0).toArray();

        if (option == Option.DFS) {
            DFS(tree, visited, nodes, node - 1);
        } else {
            BFS(tree, visited, nodes, node - 1);
        }

        System.out.println();
    }

    public static void DFS(int[][] tree, int[] visited, int nodes, int node) {
        int currentNode = node;
        visited[node] = 1;
        System.out.print(node + 1);

        for (int i = 0; i < nodes; ++i) {
            if (tree[currentNode][i] == 1 && visited[i] == 0) {
                System.out.print(" ");
                DFS(tree, visited, nodes, i);
            }
        }
    }

    public static void BFS(int[][] tree, int[] visited, int nodes, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = 1;

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + 1);

            for (int i = 0; i < nodes; ++i) {
                if (tree[currentNode][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                }
            }
            
            if (queue.isEmpty()) {
                break;
            }
            System.out.print(" ");
            currentNode = queue.peek();
        }
 
    }
    
}
