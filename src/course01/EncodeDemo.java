package course01;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

public class EncodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "孩子ABC";
        byte[] bytes = str.getBytes();  //将字符串转换成字节
        for(byte b :bytes) {
            //把字节（转换成int 以16进制输出）
            //System.out.print(Integer.toHexString(b)+" ");
            System.out.print(b+" ");
        }
        System.out.println();
        String str2 = "孩子";
        ByteArrayInputStream bis = new ByteArrayInputStream(str2.getBytes());

        int temp = 0;
        while((temp = bis.read())!=-1){
            System.out.print(temp+",");
        }
        System.out.println();
        int asc = 41;
        System.out.println(asc);
        System.out.println((char)14);

        System.out.println("----------------------------------");
        
    }
}
