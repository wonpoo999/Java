package absoluteTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaWordCounter {

    // 자바 파일에서 단어 출현 수 카운트
    public static Map<String, Integer> countWordsInJavaFile(File file) throws IOException {
        Map<String, Integer> map = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {

            String line;
            Pattern pattern = Pattern.compile("[a-zA-Z]+"); // 영문자만 추출
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line.toLowerCase());
                while (matcher.find()) {
                    String word = matcher.group(); // 소문자 단어
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
        }
        return map;
    }

    // 결과 출력 (최다 단어 포함)
    public static void printResult(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            System.out.println("⚠️ 단어가 없습니다.");
            return;
        }

        // 1. 단어 출력 (빈도순 정렬)
        map.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e -> System.out.printf("%-15s : %d\n", e.getKey(), e.getValue()));

        // 2. 최다 출현 단어 찾기
        int maxCount = Collections.max(map.values());

        List<String> topWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount)
                topWords.add(entry.getKey());
        }

        System.out.println("📌 최다 출현 단어 (" + maxCount + "회): " + String.join(", ", topWords));
    }
}
