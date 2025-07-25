package day12;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Utf8Test {
    public static void main(String[] args) throws IOException {
        String fileName = "test_utf8.txt";
        String text = "한글이 제대로 나와야 합니다.";

        // 쓰기
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8))) {
            bw.write(text);
        }

        // 읽기
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("읽은 내용: " + line);
            }
        }
    }
}
