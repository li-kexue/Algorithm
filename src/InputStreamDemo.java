import java.io.*;

/**
 * @author likexue
 * @create 2019/11/1420:44
 **/
public class InputStreamDemo {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        OutputStream os = System.out;
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        String line;
        StringBuilder result = new StringBuilder();
        while((line = br.readLine())!=null){
            if("exit".equals(line)){
                break;
            }
            result.append(line+"\n");
        }
        try {
            PrintStream ps = new PrintStream("out1.txt");
//            System.setOut(ps);
//            System.out.println(result);
            ps.append(result);
            ps.flush();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        br.close();
    }

}
