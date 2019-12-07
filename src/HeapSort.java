/**
 * @author likexue
 * @create 2019/9/1915:48
 **/
public class HeapSort {
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void heapify(int[] tree,int n,int i){
        /**
         * 如果一个节点没有左孩子就可以直接返回
         * 因为完全二叉树没有左孩子，必定没有右孩子
         */
        if (2*i+1>=n){
            return;
        }
        //左孩子下标
        int lc = 2 * i + 1;
        //右孩子下标
        int rc = 2 * i + 2;
        //记录最大值的下标
        int max_index = i;
        /**
         * 这里小于n而不是，小于等于n是因为n的值
         * 为数组长度，而不是下标的值
         */
        if (lc < n && tree[lc] > tree[max_index]){
            max_index = lc;
        }
        if (rc < n && tree[rc] > tree[max_index]){
            max_index = rc;
        }
        /**
         * 通过上面的两个if比较，找到三个节点的最大值的下标
         * 如果最大值的下标和当前节点的下标不相同，将其进行交换
         */
        if (max_index != i){
            swap(tree,max_index,i);
            heapify(tree,n,max_index);
        }
    }
    public static void buildHeap(int[] tree, int n){
        int parent = (n-1)/2;
        for (int i = parent; i >= 0; i--){
            heapify(tree,n,i);
        }
    }
    public static void heapSort(int[] tree,int n){
        buildHeap(tree,n);
        //for循环相当于将最后一个节点取出操作，这里说取出不太恰当，这里其实是最后一个元素不再参与之后的操作了
        // 这里i不断减小，就是使排好顺序的元素不再进行操作了
        for (int i = n-1; i >= 0; i--) {
            //根节点和最后一个节点交换位置
            swap(tree,i,0);
            //交换后，我们需要将除最后一个节点外的节点继续按最大堆排列，这一步是恢复操作
            //上面之所以对n产生疑惑是因为这里需要的i值（作为提醒）
            heapify(tree,i,0);
        }
    }
    public static void main(String[] args) {
        int[] tree = {2,5,3,1,10,4};
        int n = 6;
        heapSort(tree,n);
        for (int i = 0; i < n; i++) {
            System.out.println(tree[i]);
        }
    }
}
