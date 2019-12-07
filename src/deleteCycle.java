/**
 * @author likexue
 * @create 2019/11/416:20
 * 判断是否成环，并给出成环点
 **/
public class deleteCycle {
    static class ListNode{
        int val;
        ListNode next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 1;
        ListNode T;
        T = head;
        for(int i = 2; i <= 2; i++){
            ListNode node  = new ListNode();
            node.val = i;
            T.next = node;
            T = node;
        }
        T.next = head;
        detect(head);
    }
    public static ListNode detect(ListNode head) {
        int sum = 0;
        ListNode T = head;
        if(T==null||T.next==null||T.next.next==null){
            System.out.println("no cycle");
            return null;
        }
        ListNode s = T.next;
        ListNode f = T.next.next;
        while(s!=null&&f!=null){
            if(s==f){
                break;
            }
            if(s.next==null||f.next==null||f.next.next==null){
                return null;
            }
            s = s.next;
            f = f.next.next;
        }
        if(s == head){
            System.out.println("tail connects to node index 0");
            return s;
        }
        f = head;
        while(s!=f){
            s = s.next;
            f = f.next;
            sum++;
        }
        System.out.println("tail connects to node index "+sum);
        return s;
    }
}
