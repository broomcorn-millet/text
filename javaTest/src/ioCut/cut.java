package ioCut;

import javax.naming.NameNotFoundException;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

//需求：对文件进行切割和合并，生成相应的配置文件，包括碎片个数partcount，源文件名称filename。
public class cut {
    private static final int SIZE = 6 * 1024 * 1024;//6MB
    public static void main(String[] args) throws IOException {
        File file = new File("/home/lxl/视频/1237.txt");//传入的一个文件
        File dir = new File("/home/lxl/视频/parties");//传入的一个文件夹
        splitFile(file);
        String fileFormat = "txt";
        mergeFile(dir, fileFormat);
    }

    //切割文件
    public static void splitFile(File file) throws IOException {
        //取出文件格式,以便生成相应格式的文件 file为传的参数
    //    String fileFormat = file.getName().substring(file.getName().lastIndexOf('.'));//mp4
//        byte[] old=new byte[1024*1024*100];
//        byte[] niu=new byte[1024*1024*100];
//        RandomAccessFile obj= new RandomAccessFile(optah,"rw");
//        RandomAccessFile target=new RandomAccessFile(npath,"rw");
//        obj.read(old);
//        target.read(niu);
//        byte[] buf=new byte[1024*1024*5];
//        int len = 0;
//        int count = 1;
//        while((len = obj.read(buf)) != -1){
//            target(new File(npath,(count++) + fileFormat));
//            target.write(buf,0,len);
//            target.close();
//        }

        //取出文件格式,以便生成相应格式的文件 file为传的参数
        String fileFormat = file.getName().substring(file.getName().lastIndexOf('.'));//mp4
        //取出文件的父目录
        File parentDir = file.getParentFile();//home/lxl/视频
        //生成文件的目的地
        File destFile = new File(parentDir, "parties");//home/lxl/视频/parties
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[SIZE];
        int len = 0;
        int count = 1;
        FileOutputStream fos = null;
        while ((len = fis.read(buf)) != -1) {
            fos = new FileOutputStream(new File(destFile, (count++) + fileFormat));
            fos.write(buf, 0, len);
            fos.close();
        }
        fis.close();
        //自动生成配置文件
        Properties prop = new Properties();
        prop.setProperty("partcount", (count - 1) + "");
        prop.setProperty("filename", file.getName());//hea
        fos = new FileOutputStream(new File(destFile, count + ".properties"));
        prop.store(fos, "FileInformation");
        fos.close();
    }
    //合并文件
    public static void mergeFile(File dir, String fileFormat) throws IOException {
        //读取配置文件
        File[] files = dir.listFiles(new SuffixFilter(".properties"));//listFiles()方法是返回某个目录下所有文件和目录的绝对路径，返回的是File数组　符合规格的文件数组　
        if (files.length != 1)
            throw new NoFileException("文件不存在或文件不唯一");
        File confile = files[0];//用于读取Java的配置文件　　？？为什么第一个文件是配置文件
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(confile);
        prop.load(fis);//以配置文件的形式加载读到的第一个文件
        int count = Integer.parseInt(prop.getProperty("partcount"));//第一个配置为partcount=切割的份数
        String filename = prop.getProperty("filename");//第二个配置为filename=
        ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
        //获取碎片文件
        File[] partFiles = dir.listFiles(new SuffixFilter("." + fileFormat));//读取后缀名字为.mp4的文件
        if (count != partFiles.length) //判断切割的是否完整满足要求
            throw new FileCountException("碎片文件个数不符，应为" + count + "个");
        //把切割好的文件添加到arraylist里去
        for (int i = 0; i < partFiles.length; i++) {
            al.add(new FileInputStream(partFiles[i]));
        }
        //调用集合工具类对他进行处理
        Enumeration en = Collections.enumeration(al);//返回一个数组列表，其中包含指定枚举返回的元素，其返回顺序与枚举返回的顺序相同
        SequenceInputStream sis = new SequenceInputStream(en);//io合并流　SequenceInputStream会将与之相连接的流集组合成一个输入流并从第一个输入流开始读取，
        // 直到到达文件末尾，接着从第二个输入流读取，依次类推，直到到达包含的最后一个输入流的文件末 尾为止。 合并流的作用是将多个源合并合一个源。
        FileOutputStream fos = new FileOutputStream(new File(dir, filename));//将合并文件输出到文件夹
        byte[] buf = new byte[SIZE];
        int len = 0;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        fos.close();
        sis.close();
    }
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

}

class NoFileException extends RuntimeException {
    NoFileException() {
        super();
    }

    NoFileException(String msg) {
        super(msg);
    }
}

class FileCountException extends RuntimeException {
    FileCountException() {
        super();
    }

    FileCountException(String msg) {
        super(msg);
    }

}
//用来过滤不符合规格的文件名，并返回合格的文件；
class SuffixFilter implements FilenameFilter {

    private String suffix;

    public SuffixFilter(String suffix) {
        super();
        this.suffix = suffix;
    }

    @Override
    public boolean accept(File dir, String name) {

        return name.endsWith(suffix);
    }

}