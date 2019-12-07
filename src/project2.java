/**
 * @author likexue
 * @create 2019/10/1017:12
 **/
public class project2 {
    public static void main(String[] args) {
        int[][]arr = {
                {8},
                {12,15},
                {3,9,6},
                {8,10,5,12},
                {16,4,18,10,9}
        };
        int max;
        max = DataTower(arr,5,5);
        System.out.println("\n最大值为："+max);
    }
    public static int DataTower(int[][]arr,int m,int n){
        int[][] path = new int[m][n];
        int[][]maxAdd = new int[m][n];
        for (int i = 0;i<n;i++){
            maxAdd[m-1][i]=arr[m-1][i];
        }
        for (int i=m-2;i>=0;i--){
            n--;
            for (int j=0;j<n;j++) {
                if (maxAdd[i+1][j]>maxAdd[i+1][j+1]){
                    maxAdd[i][j]=arr[i][j]+maxAdd[i+1][j];
                    path[i][j]=j;
                }else{
                    maxAdd[i][j]=arr[i][j]+maxAdd[i+1][j+1];
                    path[i][j]=j+1;
                }
            }
        }
        int j = path[0][0];
        for (int i = 0; i < m; i++) {
            if (i!=0&&i!=m){
                System.out.print("-->");
            }
            System.out.print(arr[i][path[i][j]]);

        }
        return maxAdd[0][0];
    }
}
