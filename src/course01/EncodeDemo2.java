package course01;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

public class EncodeDemo2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "孩子ABC";
        byte[] bytes = str.getBytes();  //将字符串转换成字节
        for(byte b :bytes) {
            //把字节（转换成int 以16进制输出）
            System.out.print(Integer.toHexString(b &0xff)+" ");
            //System.out.print(b+" ");
        }
        System.out.println((char) 41);
        byte[] gbks = str.getBytes("gbk");
        for (byte gbk:
             gbks) {
            System.out.print(Integer.toHexString(gbk &0xff)+" ");
        }

    }
}
