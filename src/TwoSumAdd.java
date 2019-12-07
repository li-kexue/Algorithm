/**
 * @author likexue
 * @create 2019/11/1322:28
 **/
public class TwoSumAdd {
    static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode temp = null;
        int result;
        int x = 0;
        while(l1!=null&&l2!=null){
            result = l1.val+l2.val + carry;
            carry = result / 10;
            result = result % 10;
            temp = new ListNode(result);
            if(x ==0){
                head = temp;
                x++;
            }
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            result = l1.val + carry;
            ListNode node = new ListNode(result);
            carry = result / 10;
            result = result % 10;
            temp = new ListNode(result);
            temp = temp.next;
            l1 = l1.next;
        }
        while(l2!=null){
            result = l2.val + carry;
            carry = result / 10;
            result = result % 10;
            temp = new ListNode(result);
            temp = temp.next;
            l2 = l2.next;
        }
        if(carry!=0){
            temp = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(5);
        ListNode temp = new ListNode(4);
        head1.next = temp;

        while (head1!=null){
            System.out.println(head1.val);
            head1 = head1.next;
        }
//        temp = head2.next;
//        temp = new ListNode(6);
//        temp = temp.next;
    }
}
