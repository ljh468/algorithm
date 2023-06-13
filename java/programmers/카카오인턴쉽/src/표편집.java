import java.util.Stack;

public class 표편집 {
    class Node{
        boolean removed; // 삭제 유무
        Node prev; // 위에 연결된 node
        Node next; // 아래에 연결된 node
    }
    Node[] nodeArr = new Node[1000000];

    public String solution(int n, int k, String[] cmd){
        // 1. node배열에 Node객체 초기화
        for (int i = 0; i < n; i++) {
            nodeArr[i] = new Node();
        }
        // 2. Node객체의 연결 속성 초기화
        for (int i = 1; i < n; i++) {
            nodeArr[i - 1].next = nodeArr[i];
            nodeArr[i].prev = nodeArr[i - 1];
        }
        // 현재 Node
        Node curr = nodeArr[k];
        // 지워졌다가 다시 되돌리는 작업을 위한 스택
        Stack<Node> mystack = new Stack<>();

        // 3. 입력받은 커맨드 처리
        for (String str : cmd) {
            if(str.charAt(0) == 'U'){ // 위로 이동
                // 이동할 횟수
                int x = Integer.parseInt(str.substring(2));
                // 이동횟수만큼 curr.prev로 이동
                for (int i = 0; i < x; i++) {
                    curr = curr.prev;
                }
            } else if (str.charAt(0) == 'D') { // 아래로 이동
                // 이동할 횟수
                int x = Integer.parseInt(str.substring(2));
                // 이동횟수만큼 curr.next로 이동
                for (int i = 0; i < x; i++) {
                    curr = curr.next;
                }
            } else if(str.charAt(0) == 'C'){ // 삭제
                // 스택에 현재 Node push
                mystack.push(curr);
                curr.removed = true; // 삭제 유무 O
                Node up = curr.prev;
                Node down = curr.next;
                // 위의 노드가 있으면 위 Node의 다음노드는 아래에 있는 노드로 연결
                if (up != null) {
                    up.next = down;
                }
                // 아래의 노드가 있으면 아래 Node의 이전노드는 위에 있는 노드로 연결
                if (down != null) {
                    down.prev = up;
                    curr = down; // 현재 노드는 다음칸의 노드로 지정
                } else curr = up; // 다음칸의 노드가 없으면 위칸의 노드로 지정
            } else{ // Z
                Node node = mystack.pop();
                node.removed = false;
                Node up = node.prev;
                Node down = node.next;
                if (up != null) {
                    up.next = node;
                }
                if (down != null) {
                    down.prev = node;
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(nodeArr[i].removed){
                answer.append('X');
            } else{
                answer.append('O');
            }
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        표편집 sol = new 표편집();
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        System.out.println(sol.solution(n, k, cmd));
    }
}
