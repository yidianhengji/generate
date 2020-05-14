package com.pg.generate.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void writeFile(String filePath, String entityName, String content) {
        String newFilePath = filePath + "\\" + entityName + ".java";
        FileWriter fileWriter = null;
        try {
            File file = new File(newFilePath);
            if (!file.exists()) {
                fileWriter = new FileWriter(newFilePath);//创建文本文件
                fileWriter.write(content);
                fileWriter.flush();
                fileWriter.close();
            } else {
                System.out.println("文件存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
