import java.util.Scanner;

/**
 * @author likexue
 * @create 2019/11/713:07
 **/
public class Backpack1 {
    static int maxV = -1;
    static int M;
    static int[] choice;
    static int[] saved;
    public static void main(String[] args) {
        int C ;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入物品个数：");
        M = input.nextInt();
        int[] s = new int[M];
        int[] v = new int[M];
        for (int i = 0; i<M; i++){
            System.out.println("请输入第"+(i+1)+"个物品重量：");
            s[i] = input.nextInt();
            System.out.println("请输入第"+(i+1)+"个物品价值：");
            v[i] = input.nextInt();
        }
        System.out.println("请输入背包容量：");
        C = input.nextInt();
        int sum=0;
        knapsack(v,s,C,M);
        System.out.println("选择");
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
    public static void knapsack(int[]v,int[]s,int C,int n)
    {
        choice = new int[n+1];
        saved = new int[n+1];
        int flag = 0;
        int i=0,j=0,k=0;
        int value=0,bag=0;
        for(i=0;i<n;i++){
            choice[i]=-1;
            saved[i]=-1;
        }
        while(k>=0)
        {
            while(choice[k]<1)
            {
                choice[k]++;
                if(k==n)
                {
                    value=0;
                    bag=0;
                    for(i=0;i<n;i++)
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
                        for(i=0;i<n;i++){
                            saved[i] = choice[i];
                        }
                    }
                    break;
                }else{
                    k++;
                }
            }
            choice[k] = -1;
            k--;
        }
    }
    
}
