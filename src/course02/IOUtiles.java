package course02;
import java.io.*;

/**
 *  IO 工具类
 * created by chenwei 2020-07-26
 */
public class IOUtiles {

    /**
     * 读取指定文件内容，按照16进制输出(非缓存)
     * @param fileName
     */
    public static void printHex(String fileName) throws IOException {
        if(new File(fileName).exists()) {
            FileInputStream fis = new FileInputStream(fileName);
            int bt;
            while ((bt = fis.read()) != -1) {
                if (bt <= 0xf) { //如果一个字节小于低四位 补0操作
                    System.out.print("0");
                }
                System.out.println(Integer.toHexString(bt & 0xff));
            }
            fis.close();
        }else{
            throw new IllegalArgumentException("文件路径不合法！请重新输入路径！");
        }
    }

    /**
     * 读文件数据 （缓存）
     * @param fileName
     * @throws IOException
     */
    public static void printHexByByteArray(String fileName) throws IOException{
        if(new File(fileName).exists()) {
            FileInputStream fis = new FileInputStream(fileName);
            byte[] buf = new byte[20 * 1024]; //20kB一读
            //从fis中批量读取字节放入到 buf这个字节数组中，从第0个位置开始放最多放 buf.lenght，返回的是读到的字节的个数
            int  bytes;
            while((bytes = fis.read(buf,0,buf.length))!=-1){//一次性读完说明我的字节数组够大
                for (int i=0;i<bytes;i++){
//                    if (buf[i] <= 0xf) { //如果一个字节小于低四位 补0操作
//                        System.out.print("0");
//                    }
                    /**
                     * 注意：byte类型8位，int类型32位
                     * ，为了避免数据转换错误，通过&0xff将高24位清零
                     */
                    System.out.println(Integer.toHexString(buf[i] &0xff));
                }
                //打印出没错读的字节数据 转化成utf-8编码
                //System.out.println(new String(buf,"utf-8"));
            }
            fis.close();
        }else{
            throw new IllegalArgumentException("文件路径不合法！请重新输入路径！");
        }
    }

    /**
     * 写入demo ，需要修改才可以使用
     * @param fileName
     * @param isApend
     * @return
     * @throws IOException
     */
    public static boolean writeFileByOutPutStream(String fileName,boolean isApend) throws IOException{
        boolean flag=true;
        if(new File(fileName).exists()){
            FileOutputStream fos = new FileOutputStream(fileName,isApend);
//            String a="A";
//            byte[] bytes = a.getBytes();
//            for (byte b:
//                 bytes) {
//                fos.write(b);
//            }
            int a =11;
            fos.write(a>>>24);
            fos.write(a>>>16);
            fos.write(a>>>8);
            fos.write(a);
            byte[] bytes = "中国".getBytes("utf-8");
            fos.write(bytes);
            fos.close();
        }else{
            flag = false;
            throw new IllegalArgumentException("文件路径不合法！请重新输入路径！");
        }
        return flag;
    }

    /**
     * 文件的copy
     * @param sourcFile 源文件
     * @param toFile  目标文件
     * @throws IOException
     */
    public static void copyFile(File sourcFile,File toFile) throws IOException{
        if(sourcFile.exists()){
            //读文件
            FileInputStream fis = new FileInputStream(sourcFile);
            FileOutputStream fos = new FileOutputStream(toFile);
            byte[] sourceBytes = new byte[20 * 1024];
            int j;//代表读到的个数
            while((j = fis.read(sourceBytes,0,sourceBytes.length))!=-1){
                //写文件
                fos.write(sourceBytes,0,j);
                fos.flush();//对于字节流而言加不加无所谓
            }
            fis.close();
            fos.close();
        }else{
            throw new IllegalArgumentException("文件不存在，参数有错！");
        }
    }

    /**
     * DataOutputStream 使用demo
     * @param fileName
     * @return
     * @throws IOException
     */
    public static boolean writeData(String fileName) throws IOException{
        boolean flag =true;
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName)); //具备扩展的功能
        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeDouble(10.36);
        dos.writeUTF("中国你好！！！");   //以utf-8写入
        //dos.writeChars("中国你");  //以utf-16be ，java字符串编码
        return flag;
    }

    /**
     * 读取文件中的数据 demo  （指定为utf-8）
     * @param fileName
     * @throws IOException
     */
    public static void readData(String fileName) throws  IOException{
        DataInputStream dis = new DataInputStream(new FileInputStream(fileName));
        byte[] bytes = new byte[10 * 1024];
        int j;
        while((j=dis.read(bytes,0,bytes.length))!=-1){
            System.out.println(new String(bytes,"utf-8"));
        }
    }

//    public static void writePojo(String str) throws IOException, ClassNotFoundException {
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(str));
//        Object o = ois.readObject();
//
//    }


}
