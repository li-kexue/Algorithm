/**
 * @author likexue
 * @create 2019/11/1312:36
 **/
public class MyStack {
    private Object[] items;
    private int count;
    public MyStack(){
        items = new Object[10];
        count = 0;
    }

    public void push(Object item){
        if (items.length==count){
            throw new RuntimeException("数组容量不足");
        }else{
            items[count++] = item;
        }
    }
    public Object pop(){
        if (count>0){
            Object obj = items[count-1];
            count--;
            return obj;
        }else {
            return null;
        }
    }
    public Object Top(){
        if (count>0) {
            return items[count - 1];
        }else {
            return null;
        }
    }
    public int length(){
        return count;
    }
}
