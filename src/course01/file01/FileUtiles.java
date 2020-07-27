package course01.file01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * file工具类
 */
public class FileUtiles {

    /**
     * 列出指定目录下的所有目录 包括子目录下的所有子文件
     * @param dir
     * @throws IOException
     * @return List<File>
     * created by xiu_er 2020-07-25
     */
    public static List<File> listDirectory(File dir) throws IOException {
        List<File> list = new ArrayList<>();
         if(!dir.exists()){
             throw new IllegalArgumentException("此目录不存在");
         }
         if(!dir.isDirectory()){
             throw new IllegalArgumentException("提供的文件不是目录!");
         }
        File[] listFiles = dir.listFiles();//返回的是子目录下的所有File对象
        if(listFiles.length>0||listFiles!=null) {
            for (File f :
                    listFiles) {
                if(f.isDirectory()){
                    //递归操作
                    listDirectory(f);
                }else{
                    list.add(f);
                }
            }
        }
        return list;
    }

    /**
     * 按照指定的编码读文件
     * @param dir  文件对象
     * @param charset  编码格式
     * @return
     * @throws IOException
     * created by xiu_er 2020-07-25
     */
    public static String readFile(File dir,String charset) throws IOException {
        if(dir.exists()&&dir.isFile()){
            //开始读文件
            RandomAccessFile raf = new RandomAccessFile(dir, "r");
            byte[] bytes = new byte[(int)raf.length()]; //创建一个byte数组
            raf.read(bytes);  // 将所有的字节读进去
            raf.close();
            return new String(bytes,charset);
        }else{
            throw new IllegalArgumentException("文件不存在或者不是个文件！");
        }
    }

    /**
     * 指定字符编码，以追加的方式向文件中写入数据(字符串)
     * @param dir
     * @param str
     * @param charset
     * @return boolean 判断有没有写入成功
     * @remark  此方法可以扩展（写入double ,float,int,long）
     * @throws FileNotFoundException
     */
    public static boolean writeFile(File dir,String str,String charset,String writeType) throws IOException {
        boolean flag = true;
        if(dir.exists()&&dir.isFile()){
            RandomAccessFile raf = new RandomAccessFile(dir,writeType);
            //将字符串按照指定的方式读取字节
            byte[] bytes = str.getBytes(charset);
            raf.seek(raf.length());
            //将字节写进去
            raf.write(bytes);
            raf.close();
        }else {
            flag = false;
            throw new IllegalArgumentException("文件不存在或者不是个文件！");
        }

        return flag;
    }


}
