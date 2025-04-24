package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello from VcsTestProject1");

        // 添加文件生成
        try {
            String path = App.class.getClassLoader().getResource(".").getPath();
            File outputDir = new File(path, "output");
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }

            File logFile = new File(outputDir, "log.txt");
            try (FileWriter writer = new FileWriter(logFile)) {
                writer.write("TeamCity plugin test log\n");
                writer.write("Checkout operation simulated.\n");
                System.out.println("[App] Wrote log to: " + logFile.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
