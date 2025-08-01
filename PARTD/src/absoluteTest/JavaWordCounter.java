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
        return map;

    }

    // 결과 출력 (최다 단어 포함)
    public static void printResult(Map<String, Integer> map) {
        map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // 많이 나온 순
                .forEach(e -> System.out.printf("%-15s : %d\n", e.getKey(), e.getValue()));
    }
}