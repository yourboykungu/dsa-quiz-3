class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3(int x) {
        val = x;
    }
}

public class Solution3 {
    public ListNode3 reverseList(ListNode3 head) {
        ListNode3 prev = null;
        ListNode3 current = head;

        while (current != null) {
            ListNode3 next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public ListNode3 constructLinkedList(int[] nums) {
        ListNode3 dummy = new ListNode3(0);
        ListNode3 prev = dummy;
        for (int num : nums) {
            ListNode3 node = new ListNode3(num);
            prev.next = node;
            prev = node;
        }
        return dummy.next;
    }

    // Helper function to print the linked list
    public void printList(ListNode3 head) {
        ListNode3 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        // Example usage:
        // Example 1
        ListNode3 head1 = solution.constructLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode3 reversedHead1 = solution.reverseList(head1);
        solution.printList(reversedHead1); // Output: 5 4 3 2 1

    }
}
