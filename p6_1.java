import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class p6_1 {
    public static void main(String arg[]) throws Exception {
        int c;
        URL u = new URL("https://moodle.dallastown.k12.pa.us/pluginfile.php/379743/mod_resource/content/1/Java%20Text%20-%20Liang.pdf");
        URLConnection uc = u.openConnection();
        System.out.println("date:" + new Date(uc.getDate()));
        System.out.println("content type:" + uc.getContentType());
        System.out.println("expire:" + uc.getExpiration());
        System.out.println("last modified::" + new Date(uc.getLastModified()));
        int len=uc.getContentLength();
        System.out.println("content length:" + len);
        if(len>0){
            FileOutputStream fout = new FileOutputStream("text.pdf");
            InputStream input = uc.getInputStream();
            int i=0;
            while (((c = input.read()) != -1)&& i<len) {
                fout.write((char)c);
                i++;
               // System.out.println((char)c);
            }
            
            input.close();
            fout.close();
            System.out.println("File downloaded successfully.");
        }else{
            System.out.println("no file");
        }
       
    }
}
