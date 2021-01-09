package App.Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bean.Message;

/**
 *
 * 生成文本文件类
 *
 */
public class GetTxt {
    /**
     * 生成文本文件
     */
    public static void gettxt() {
        List<Message> listMsg = new ArrayList<Message>();
        File file = new File("users.txt");// 定位要操作的excel文件
        try (FileWriter fos = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fos)) {
            for (Message Msg : listMsg) {
                bw.write(Msg.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成文本文件主方法
     * @param args String[]
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Message> listMsg = new ArrayList<Message>();
        gettxt();
    }
}
