package course01.file01;

import java.io.File;
import java.io.IOException;

public class File01 {

    public static void main(String[] args) throws IOException {
        File file = new File("/users/wei/Desktop/日志监控/HELP.md");
        System.out.println(file.exists());  //判断file存不存在
//        if(!file.exists()) { //确实不存在
//            file.mkdir(); //创建文件夹
//        }else{
//            file.delete();
//        }
        //判断文件是否是目录 , 如果是目录返回true， 如果不是目录或者目录不存在返回false
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        if(!file.exists()){
            file.createNewFile();
        }
        System.out.println(file);  //打印的是文件的路径
        System.out.println(file.toString());  //打印的是文件的路径
        System.out.println(file.getName()); // 打印文件名字
        System.out.println(file.getAbsolutePath()); //打印绝对路径
        System.out.println(file.getParent());
    }
}
