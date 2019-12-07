/**
 * @author likexue
 * @create 2019/10/3019:51
 **/
public class LinkList {
    public int value;
    public LinkList next;

    public static void main(String[] args) {
        int k = 0;
        LinkList head = null;
        LinkList list = new LinkList();
        list.value = 1;
        head = list;

        for (int i = 2; i <= 5;i++){
            LinkList node = new LinkList();
            node.value = i;
            list.next = node;
            list = node;
        }
        LinkList t = reverse(head,2,4);
        while (t!=null){
            System.out.println(t.value);
            t = t.next;
        }
    }
    public static LinkList reverse(LinkList head,int m,int n){
        int i = 1;
        LinkList temp = head;
        LinkList pre;
        LinkList node;
        LinkList head_temp;
        while(i < m-1){
            temp = temp.next;
            i++;
        }
        pre = temp;
        if(m!=1){
            temp = temp.next;
            i++;
        }
        head_temp = temp;
        while(i<n){
            node = temp.next;
            temp.next = temp.next.next;
            node.next = head_temp;
            head_temp = node;
            i++;
        }
        if(m!=1){
            pre.next = head_temp;
            return head;
        }else{
            return head_temp;
        }
    }
}
