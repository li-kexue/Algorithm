import java.io.*;
import java.util.Arrays;

/**
 * @author likexue
 * @create 2019/12/116:43
 **/
public class TSP {
    public static void main(String[] args) {
        int[][] arc = new int[4][4];
        print(arc, 4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arc[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(int[][] arc, int x) {
        try {
            FileReader fr = new FileReader(new File("C:\\Users\\27430\\Documents\\Java\\Algorithm\\src\\data.txt"));
            char[] data = new char[1024];
            while (fr.read(data) != -1) {
            }
            String s = new String(data);
            s = s.replace("\n", "").replace("\r", " ").trim();
            String[] ss = s.split(" ");
            int m = 0, n = 0;
            for (int i = 0; i < ss.length; i++) {
                if (n % x == 0 && n != 0) {
                    n = 0;
                    m++;
                }
                arc[m][n] = Integer.parseInt(ss[i]);
                n++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init(int[][] d, int[][] arc) {
        for (int i = 0; i < d.length; i++) {
            d[i][0] = arc[i][0];
        }
    }
}
