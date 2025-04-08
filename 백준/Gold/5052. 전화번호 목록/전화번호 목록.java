import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

class Main {

    static class Node {
        char data;
        private boolean isEnd;
        private Map<Character, Node> children;

        public Node(char data, boolean isEnd) {
            this.data = data;
            this.children = new HashMap<>();
            this.isEnd = isEnd;
        }

        public Node(char data) {
            this(data, false);
        }

        public Node getChild(char data) {
            if (!hasChild(data)) {
                return null;
            }
            return children.get(data);
        }

        public void addChild(char data, Node child) {
            if (hasChild(data)) {
                return;
            }
            children.put(data, child);
        }

        public boolean hasChild(char data) {
            if (children.containsKey(data)) {
                return true;
            }
            return false;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }

    static class Tree {
        Node head;

        public Tree() {
            this.head = new Node('0');
        }

        public boolean addString (String string) {
            Node pointer = head;
            for (int i = 0; i < string.length(); ++i) {
                char data = string.charAt(i);
                Node node;
                if (i + 1 == string.length()) {
                    node = new Node(data, true);
                } else {
                    node = new Node(data);
                }

                if (!pointer.hasChild(data)) {
                    pointer.addChild(data, node);
                    pointer = pointer.getChild(data);
                    continue;
                }

                pointer = pointer.getChild(data);
                if (pointer.isEnd()) {
                    return false;
                }
                if (i + 1 == string.length()) { // 911 -> 91125426 입력시 틀려야 함; 입력은 순서가 있지만, 사용에는 순서가 없으니, 나중에 추가되는 번호가 접두어여도 안 되는 것.
                    return false;
                }
            }
            
            return true;
        }
    }
    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int testcaseCount = Integer.parseInt(br.readLine());

            for (int i = 0; i < testcaseCount; ++i) {
                Tree tree = new Tree();
                int telCount = Integer.parseInt(br.readLine());
                boolean noEnd = true;

                for (int j = 0; j < telCount; ++j) {
                    String tel = br.readLine();
                    if (noEnd) {
                        noEnd = tree.addString(tel);
                    }
                }
                if (noEnd == false) {
                    System.out.println("NO");
                    continue;
                }
                System.out.println("YES");
            }
            
        } catch (IOException io) {

        }
    }
}