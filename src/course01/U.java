package course01;

import course01.file01.FileUtiles;

import java.io.File;
import java.io.IOException;

public class U {
    public static void main(String[] args) throws IOException {
        FileUtiles.writeFile(new File("/users/wei/Desktop/日志监控/HELP.md"),"我爱你星325\n","utf-8","rw");
        String a = FileUtiles.readFile(new File("/users/wei/Desktop/日志监控/HELP.md"),"utf-8");
        System.out.println(a);
    }
}
