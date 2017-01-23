package com.web.crawler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created by Gobinda-PC on 23-01-2017.
 */
public class WriteLinksToTextFile {

    final static Charset ENCODING = StandardCharsets.UTF_8;
    final static String FILE_NAME = "MyLinks.txt";

    public static void writeFile(List<String> links) throws IOException {
        Path path = Paths.get(FILE_NAME);
        try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)){
            for(String line : links){
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
