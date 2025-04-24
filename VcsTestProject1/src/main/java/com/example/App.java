package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello from VcsTestProject1");

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String[] operations = {"git clone", "git pull", "git checkout", "git commit"};
        String selectedOp = operations[new Random().nextInt(operations.length)];

        long start = System.currentTimeMillis();

        // 手动设置日志输出路径
        String logRootPath = "VcsTestProject1/src/main/resources";

        try {
            File outputDir = new File(logRootPath, "output");
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }

            // 模拟生成一个变更文件
            File changesDir = new File(outputDir, "changes");
            if (!changesDir.exists()) {
                changesDir.mkdirs();
            }
            File changeFile = new File(changesDir, "change_" + System.currentTimeMillis() + ".txt");
            try (FileWriter changeWriter = new FileWriter(changeFile)) {
                changeWriter.write("Simulated content changed at " + timestamp + "\n");
            }

            // 写入日志文件
            File logFile = new File(outputDir, "log.txt");
            try (FileWriter writer = new FileWriter(logFile, true)) {
                writer.write("[INFO] Operation: " + selectedOp + "\n");
                writer.write("[INFO] Timestamp: " + timestamp + "\n");
                writer.write("[INFO] Change File: " + changeFile.getName() + "\n");
                writer.write("[INFO] Status: SUCCESS\n");
                writer.write("[INFO] Duration: " + (System.currentTimeMillis() - start) + "ms\n");
                writer.write("--------------------------------------------------\n");

                System.out.println("[App] Operation simulated: " + selectedOp);
                System.out.println("[App] Wrote log to: " + logFile.getAbsolutePath());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
