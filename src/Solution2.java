class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int x) {
        val = x;
        next = null;
    }
}

public class Solution2 {
    public ListNode2 detectCycle(ListNode2 head) {
        if (head == null || head.next == null)
            return null;

        ListNode2 slow = head;
        ListNode2 fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        if (fast == null || fast.next == null)
            return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

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
        Solution2 solution = new Solution2();

        // Example 1
        ListNode2 head1 = solution.constructLinkedList(new int[]{3, 2, 0, -4}, 1);
        System.out.println(solution.detectCycle(head1).val); // Output: 2

        // Example 2
        ListNode2 head2 = solution.constructLinkedList(new int[]{1, 2}, 0);
        System.out.println(solution.detectCycle(head2).val); // Output: 1

        // Example 3
        ListNode2 head3 = solution.constructLinkedList(new int[]{1}, -1);
        System.out.println(solution.detectCycle(head3)); // Output: null
    }
}
