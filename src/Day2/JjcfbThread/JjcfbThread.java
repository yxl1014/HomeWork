package Day2.JjcfbThread;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JjcfbThread {
    private File file;

    private OutputStream out;
    public JjcfbThread(String filename){
        this.file=new File(filename);
        if(!file.exists()){//判断文件存不存在
            try {
                this.file.createNewFile();//不存在就新建一个
                this.out = new FileOutputStream(this.file,true);//创建输出流并且设置为不覆盖
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                this.out = new FileOutputStream(this.file,true);//创建输出流并且设置为不覆盖
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void print() throws IOException {
        for(int i=1;i<=9;i++){
            StringBuffer stringBuffer=new StringBuffer();
            for(int j=1;j<=i;j++){
                stringBuffer.append(j+"*"+i+"="+j*i+" ");//往stringbuffer里叠加字符串
            }
            stringBuffer.append("\r\n");//
            out.write(stringBuffer.toString().getBytes());//往文本里写入数据
        }
    }

    public void close() throws IOException {//关闭输出流
        this.out.close();
    }
}
