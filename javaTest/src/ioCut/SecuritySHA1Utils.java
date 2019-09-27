package ioCut;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

public class SecuritySHA1Utils {

    /**
     * @Comment SHA1实现
     * @return 暂时想不到如何实现切割再合并后的文件与原来的文件sha相等 我发现切割再合并后的文件比原来大了　我感觉是因为那些切割后的小文件多了一些描述信息之类的东西
     */
    public static String shaEncode(String inStr) throws Exception {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static String parto(File file){
        String str="";
        try {
            FileInputStream in=new FileInputStream(file);
            // size 为字串的长度 ，这里一次性读完
            int size=in.available();
            byte[] buffer=new byte[size];
            in.read(buffer);
            in.close();
            str=new String(buffer,"UTF-8");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            return null;
        }
        return str;
    }
    public static void main(String args[]) throws Exception {
        File file=new File("/home/lxl/视频/1237.txt");
        File file1=new File("/home/lxl/视频/parties/1237.txt");
        String str = new String(parto(file));
        String str1=new String(parto(file1));
        System.out.println("SHA后：" + shaEncode(str));
        System.out.println("SHA后：" + shaEncode(str1));
        System.out.println(shaEncode(str)==shaEncode(str1));
    }
}
