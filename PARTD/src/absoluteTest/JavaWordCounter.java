package absoluteTest;

// 파일명: JavaWordCounter.java
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class JavaWordCounter {

    // 자바 파일에서 단어 출현 수 카운트
    public static Map<String, Integer> countWordsInJavaFile(File file) throws IOException {
        Map<String, Integer> map = new TreeMap<>();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.toLowerCase().split("[^a-zA-Z]+");
            for (String word : words) {
                if (!word.isEmpty())
                    map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        reader.close();
        return map;
    }

    // 결과 출력
    public static void printResult(Map<String, Integer> map) {
        map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // 많이 나온 순
                .forEach(e -> System.out.printf("%-15s : %d\n", e.getKey(), e.getValue()));
    }
}