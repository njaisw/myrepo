package _5_com.ds.linklist;

/**
 * Find middle element in linklist.
 * Use two pointer approach.
 * Test cases
 * 0,1,2,3,4 and so on nodes
 * @author tusroy
 *
 */
public class MiddleElementOfLinkList_IMP_3 {

    public int middle(Node head){
        if(head == null || head.next == null){
            return head.data;
        }
        //TODO Remember slowPtr and fastPtr
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
    
    public static void main(String args[]){
        MiddleElementOfLinkList_IMP_3 mle = new MiddleElementOfLinkList_IMP_3();
        LinkList_IMP_3 ll = new LinkList_IMP_3();
        Node head = null;
        head = ll.addNode(1, head);
        System.out.println(mle.middle(head));
        head = ll.addNode(2, head);
        System.out.println(mle.middle(head));
        head = ll.addNode(3, head);
        System.out.println(mle.middle(head));
        head = ll.addNode(4, head);
        System.out.println(mle.middle(head));
        head = ll.addNode(5, head);
        System.out.println(mle.middle(head));
    }
}
