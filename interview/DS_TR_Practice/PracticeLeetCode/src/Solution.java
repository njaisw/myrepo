

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

      return addTwoNumbers(l1,l2,0);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carryOver) {
        if(l1==null || l2==null ) {
            return null;
        }
        int sum = (l1.val+l2.val+carryOver)%10;
        carryOver= (sum)/10;
        ListNode prevNode = addTwoNumbers(l1.next, l2.next,carryOver);
        ListNode listNode = new ListNode(sum);
        listNode.next = prevNode;
        return listNode;

    }

    public  static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}