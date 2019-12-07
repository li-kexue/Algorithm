import java.util.Arrays;

/**
 * @author likexue
 * @create 2019/11/421:29
 **/
public class project4 {
    public static void main(String[] args) {
        int[] a = {10,2,3,4,5,6,7};
        int[] b = new int[100];
        backTracking(a, b, 14, 0, 0, a.length);
//        iteration(a,b,6,a.length);
    }
    public static void backTracking(int[] X,int[] Y, int y, int x_i,int y_i, int len){
        if (y > 0 && x_i < len){
            Y[y_i] = X[x_i];
            backTracking(X, Y,y - X[x_i],x_i + 1,y_i + 1, len);
            backTracking(X, Y, y ,x_i+1, y_i, len);
        }
        if (y == 0){
            for (int i = 0; i < y_i; i++){
               System.out.print(Y[i]+" ");
            }
            System.out.println();
//            return;
        }
    }
    public static void iteration(int[] X, int[] Y,int y, int len){
        Arrays.sort(X);
        int i = 0;
        int k = 0;
        int sum = 1;
        while(k >= 0){
            if (i < len &&y - X[i] >= 0){
                y -= X[i];
                if (y == 0){
                    for(int m = 0; m < k; m++){
                        System.out.print(Y[m] + " ");
                    }
                    System.out.println();
                }
                Y[k++] = X[i++];

                continue;
            }
//            if (k==0){
//                i = sum;
//                sum++;
//            }
            y += Y[k];
            k--;
        }
    }
}
