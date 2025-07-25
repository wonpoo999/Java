package absoluteTest;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * 📂 다양한 파일을 읽어 텍스트로 반환하는 도우미 클래스
 */
public class FileReaderHelper {

    /**
     * 주어진 파일을 읽어 텍스트 문자열로 반환
     * 
     * @param file 읽을 파일
     * @return 텍스트 내용 또는 null (읽기 실패 시)
     */
    public static String tryReadFile(File file) {
        try {
            return Files.readString(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("❌ 파일 읽기 실패: " + e.getMessage());
            return null;
        }
    }
}
