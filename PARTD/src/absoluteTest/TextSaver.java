package absoluteTest;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TextSaver {

    // 📄 텍스트 파일로 저장
    public static void saveTextFile(File file, String title, String content) {
        try {
            file.getParentFile().mkdirs(); // 디렉토리 생성
            try (Writer writer = new OutputStreamWriter(
                    new FileOutputStream(file), StandardCharsets.UTF_8)) {
                writer.write("[제목] " + title + "\n");
                writer.write("[내용]\n" + content);
            }
        } catch (IOException e) {
            System.out.println("❌ 텍스트 저장 중 오류 발생: " + e.getMessage());
        }
    }
}
