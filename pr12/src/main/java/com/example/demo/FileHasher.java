package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@SpringBootApplication
public class FileHasher {

    private static String file1;
    private static String file2;

    public static void hashFile(String file1, String file2) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file1));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(content.toString().getBytes(StandardCharsets.UTF_8));
            String hash = bytesToHex(hashBytes);

            BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
            writer.write(hash);
            writer.close();

            System.out.println("Хеш успешно записан в файл " + file2);
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }


    @PostConstruct
    public void postConstructor() {
        hashFile(file1, file2);
    }

    @PreDestroy
    public void preDestroyer() {
        File fileToDelete = new File(file1);

        if (fileToDelete.exists()) {
            if (fileToDelete.delete()) {
                System.out.println("Файл " + file1 + " успешно удален.");
            } else {
                System.out.println("Не удалось удалить файл " + file1);
            }
        } else {
            System.out.println("Файл " + file1 + " не существует.");
        }
    }

    public static void main(String[] args) {
        file1 = "C:/Users/user/IdeaProjects/pr12/src/main/java/com/example/demo/" + args[0];
        file2 = "C:/Users/user/IdeaProjects/pr12/src/main/java/com/example/demo/" + args[1];
        System.out.println(file1);
        System.out.println(file2);
        SpringApplication.run(FileHasher.class, args);
    }

}
