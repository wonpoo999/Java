package absoluteTest;

import java.io.*;
import java.util.List;

/**
 * 📁 JavaKeyWord 리스트를 다양한 형식으로 저장하는 클래스
 */
public class JavaKeyWordSaver {

    /**
     * JavaKeyWord 리스트를 주어진 파일에 덮어쓰기 방식으로 저장
     * 
     * @param file     저장할 파일
     * @param keywords 저장할 키워드 리스트
     */
    public static void save(File file, List<JavaKeyWord> keywords) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (JavaKeyWord kw : keywords) {
                writer.write(kw.toString());
                writer.newLine();
            }
            System.out.println("✅ 키워드 저장 완료 (" + file.getName() + ")");
        } catch (IOException e) {
            System.out.println("❌ 키워드 저장 실패: " + e.getMessage());
        }
    }

    /**
     * JavaKeyWord 리스트를 기존 CSV 파일에 추가 저장
     * 
     * @param file     기존 CSV 파일
     * @param keywords 추가할 키워드 리스트
     */
    public static void appendToCsv(File file, List<JavaKeyWord> keywords) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (JavaKeyWord kw : keywords) {
                writer.write(kw.toString());
                writer.newLine();
            }
            System.out.println("✅ 키워드 추가 저장 완료 (" + file.getName() + ")");
        } catch (IOException e) {
            System.out.println("❌ 키워드 추가 저장 실패: " + e.getMessage());
        }
    }
}
