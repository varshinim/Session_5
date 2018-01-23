class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
class ListNode {
	 public int val;
	 public ListNode next;
	 ListNode(int x) { val = x; next = null; }
 }
public class SortedListtoBST {
	public TreeNode sortedListToBST(ListNode a) {
	    if(a==null){
	        return null;
	    }
	    return sortedList(a,null);
	}
	public TreeNode sortedList(ListNode head, ListNode tail){
	    ListNode slow = head;
	    ListNode fast = head;
	    if(head==tail){
	        return null;
	    }
	    while(fast!=tail && fast.next!=tail){
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    TreeNode node = new TreeNode(slow.val);
	    node.left = sortedList(head,slow);
	    node.right = sortedList(slow.next,tail);
	    return node;
	}
}
