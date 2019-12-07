import java.util.Scanner;

/**
 * @author likexue
 * @create 2019/10/2416:46
 **/
public class KnapsackProblem {
    public static void main(String[] args){
        int n,m;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入背包承载总重量：");
        m = input.nextInt();
        System.out.println("请输入物品个数：");
        n = input.nextInt();
        int[][] arr = new int[n][2];
        System.out.println("请输入物品重量和价值：");
        for(int i = 0;i<n;i++){
            arr[i][0] = input.nextInt();
            arr[i][1] = input.nextInt();
        }
        for(int i = 0; i< n;i++){
            for(int j =0;j<n;j++){
                if(arr[i][0]<arr[j][0]){
                    int[] temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]= temp;
                }
            }
        }
        int sum = 0;
        int value = 0;
        for(int i = 0;i<n;i++){
            if(sum+arr[i][0]<m) {
                sum += arr[i][0];
                value += arr[i][1];
            }
        }
        System.out.println("总价值为："+value);
    }
}
