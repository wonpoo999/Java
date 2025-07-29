package absoluteTest;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CsvSaver {

    // 기존 메모 저장용
    public static void saveAsCsv(File file, String title, String content) throws IOException {
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                new FileOutputStream(file), StandardCharsets.UTF_8))) {
            writer.println("제목,내용");
            writer.printf("%s,%s%n", title, content.replace(",", " "));
        }
    }

    // ✅ CSV에서 JavaKeyWord 리스트 읽기
    public static List<JavaKeyWord> loadJavaKeywordList(File file) throws IOException {
        List<JavaKeyWord> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 3) {
                    String keyword = tokens[0].trim();
                    String korean = tokens[1].trim();
                    int level = Integer.parseInt(tokens[2].trim());
                    list.add(new JavaKeyWord(keyword, korean, level));
                }
            }
        }
        return list;
    }

    // ✅ JavaKeyWord 리스트 저장
    public static void saveJavaKeywordList(List<JavaKeyWord> list, File file) throws IOException {
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(
                new FileOutputStream(file), StandardCharsets.UTF_8))) {
            for (JavaKeyWord kw : list) {
                pw.println(kw.toString());
            }
        }
    }
}
