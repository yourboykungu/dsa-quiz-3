class ListNode {
    int val;
    ListNode2 next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode2 head) {
        if (head == null || head.next == null)
            return false;

        ListNode2 slow = head;
        ListNode2 fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    // Example usage:
    // Construct the linked list from the given inputs
    public ListNode2 constructLinkedList(int[] nums, int pos) {
        ListNode2 dummy = new ListNode2(0);
        ListNode2 prev = dummy;
        ListNode2 cycleNode = null;
        for (int i = 0; i < nums.length; i++) {
            ListNode2 node = new ListNode2(nums[i]);
            prev.next = node;
            prev = node;
            if (i == pos) {
                cycleNode = node;
            }
        }
        if (cycleNode != null) {
            prev.next = cycleNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        ListNode2 head1 = solution.constructLinkedList(new int[]{3, 2, 0, -4}, 1);
        System.out.println(solution.hasCycle(head1)); // Output: true

        // Example 2
        ListNode2 head2 = solution.constructLinkedList(new int[]{1, 2}, 0);
        System.out.println(solution.hasCycle(head2)); // Output: true

        // Example 3
        ListNode2 head3 = solution.constructLinkedList(new int[]{1}, -1);
        System.out.println(solution.hasCycle(head3)); // Output: false
    }
}
