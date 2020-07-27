package course02;

import course01.file01.FileUtiles;

import java.io.File;
import java.io.IOException;

public class IOTest {


    public static void main(String[] args) throws IOException {

        //ioUtiles.printHex("/users/wei/Desktop/日志监控/HELP.md");
        //ioUtiles.writeFileByOutPutStream("/users/wei/Desktop/日志监控/HELP.md",true);
        //ioUtiles.printHexByByteArray("/users/wei/Desktop/日志监控/HELP.md");
        //IOUtiles.copyFile(new File("/users/wei/Desktop/日志监控/HELP.md"),new File("/users/wei/Desktop/日志监控/HELP02.md"));
        IOUtiles.writeData("/users/wei/Desktop/日志监控/HELP.md");
        String a = FileUtiles.readFile(new File("/users/wei/Desktop/日志监控/HELP.md"),"utf-8");
        System.out.println(a);
        IOUtiles.readData("/users/wei/Desktop/日志监控/HELP.md");
    }
}
