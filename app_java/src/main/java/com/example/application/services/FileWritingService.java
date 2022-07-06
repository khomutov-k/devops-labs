package com.example.application.services;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileWritingService {
    private static String FILE_PATH = "./persist/data";
    static Path logFilePath = Paths.get(FILE_PATH);

    static {
        try {
            Files.createDirectories(logFilePath.getParent());
            logFilePath = Path.of(logFilePath.toFile() + ".txt");
            if (!Files.exists(logFilePath)) {
                Files.createFile(logFilePath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToFile(String str) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath.toFile(), true))) {
            writer.append(str);
            writer.append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
