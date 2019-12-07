import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyThread extends Thread{
    private FileInputStream fis;
    private FileOutputStream fos;
    public CopyThread()
    {
        try {
            fos=new FileOutputStream(new File("D:/1.txt"));
            fis=new FileInputStream(new File("D:/test.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void run()
    {
        int c;
        try {
            while((c=fis.read())!=-1)
            {
                fos.write(c);
            }
            fis.close();
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
        System.out.println("copy成功！");

    }

    public static void main(String[] args) throws InterruptedException
    {
        Thread t=new CopyThread();
        t.start();
        Thread.sleep(1000);
        while(t.isAlive());
        System.out.println("main is over");
    }

}
