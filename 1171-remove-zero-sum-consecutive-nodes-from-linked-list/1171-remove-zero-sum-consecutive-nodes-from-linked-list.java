/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {

        // Dummy node before head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        HashMap<Integer, ListNode> map = new HashMap<>();

        int sum = 0;

        // First pass
        ListNode current = dummy;

        while (current != null) {
            sum += current.val;
            map.put(sum, current);
            current = current.next;
        }

        // Second pass
        sum = 0;
        current = dummy;

        while (current != null) {
            sum += current.val;

            // Jump over zero-sum nodes
            current.next = map.get(sum).next;

            current = current.next;
        }

        return dummy.next;
    }
}