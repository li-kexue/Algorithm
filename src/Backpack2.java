import java.util.Scanner;

/**
 * @author likexue
 * @create 2019/11/720:22
 **/
public class Backpack2 {
    static int M = 6;
    static int[] choice;
    static int[] saved;

    static int maxV = -1;
    public static void main(String[] args) {
        int C ;
        Scanner input = new Scanner(System.in);
//        System.out.println("请输入物品个数：");
//        M = input.nextInt();
        choice = new int[M];
        saved = new int[M];
        int[] s = {2,2,6,5,4};
        int[] v = {6,3,5,4,6};
        //int[][]arr ={{2,6},{2,3},{6,5},{5,4},{4,6}};

//        for (int i = 0; i<M; i++){
//            System.out.println("请输入第"+(i+1)+"个物品重量：");
//            s[i] = input.nextInt();
//            System.out.println("请输入第"+(i+1)+"个物品价值：");
//            v[i] = input.nextInt();
//        }
      //  System.out.println("请输入背包容量：");
        C = 10;
        int sum=0;
        knapsack(v,s,C,0);
        System.out.println("结果为：");
        for(int i=0;i<M;i++)
        {
            if(saved[i]>0)
            {
                System.out.println("第"+(i+1)+"项,");
                sum+=s[i];
            }
        }
        System.out.println("物品放入背包,");
        System.out.println("物品总体积为:"+sum+",总价值为"+maxV);
    }
    public static void knapsack(int[]v,int[]s,int C,int k){
        if(k==M-1)
        {
            int value=0,bag=0;
            for(int i=0;i<M;i++)
            {
                if(choice[i]>0)
                {
                    bag+=s[i];
                    value+=v[i];
                }
            }
            if(maxV<value&&bag<=C)
            {
                maxV = value;
                for(int i=0;i<M;i++){
                    saved[i] = choice[i];
                }
            }
            return;
        }
        else
        {
            choice[k] = 0;
            knapsack(v,s,C,k+1);
            choice[k] = 1;
            knapsack(v,s,C,k+1);
        }
    }
}
