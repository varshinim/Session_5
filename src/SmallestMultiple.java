import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SmallestMultiple {
	public String multiple(int A) {
        if (A < 0) {
            throw new IllegalArgumentException("Invalid args");
        }
        String result = "0";
        if (A > 0) {
            boolean[] isVisited = new boolean[A];
            Arrays.fill(isVisited, false);
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(new Node(true, 1 % A, null));
            isVisited[1 % A] = true;
            Node destNode = null;
            while (!queue.isEmpty()) {
                Node currNode = queue.remove();
                if (currNode.val == 0) {
                    destNode = currNode;
                    break;
                } else {
                    int val1 = (currNode.val * 10) % A;
                    if (!isVisited[val1]) {
                        queue.add(new Node(false, val1, currNode));
                        isVisited[val1] = true;
                    }
                    int val2 = (val1 + 1) % A;
                    if (!isVisited[val2]) {
                        queue.add(new Node(true, val2, currNode));
                        isVisited[val2] = true;
                    }
                }
            }
            if (destNode == null) {
                throw new IllegalStateException("Result should not be null");
            } else {
                StringBuilder reverseResultBuilder = new StringBuilder();
                Node currNode = destNode;
                while (currNode != null) {
                    reverseResultBuilder.append(currNode.isDigitOne ? '1' : '0');
                    currNode = currNode.parent;
                }
                result = reverseResultBuilder.reverse().toString();
            }
        }
        return result;
	}
	 private class Node {
        public final boolean isDigitOne;
        public final int val;
        public final Node parent;
 
        public Node(boolean isDigitOne, int val, Node parent) {
            this.isDigitOne = isDigitOne;
            this.val = val;
            this.parent = parent;
        }
    }
}
