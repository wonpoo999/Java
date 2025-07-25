package absoluteTest;

// 📄 Analyzer.java
// 감정 분석, 키워드 추출, 요약 생성을 담당하는 유틸리티 클래스입니다.

import java.util.*;

public class Analyzer {

    private static final List<String> POSITIVE = Arrays.asList("좋다", "행복", "감사", "즐겁다", "멋지다");
    private static final List<String> NEGATIVE = Arrays.asList("싫다", "짜증", "슬프다", "화남", "우울");

    // 😊 감정 분석: 긍정/부정/중립 판별
    public static String analyzeMood(List<String> lines) {
        int pos = 0, neg = 0;
        for (String line : lines) {
            for (String p : POSITIVE)
                if (line.contains(p))
                    pos++;
            for (String n : NEGATIVE)
                if (line.contains(n))
                    neg++;
        }
        return (pos > neg) ? "긍정" : (neg > pos ? "부정" : "중립");
    }

    // 🏷 키워드 추출: 5글자 이상 중복 제거
    public static Set<String> extractKeywords(List<String> lines) {
        Set<String> keywords = new TreeSet<>();
        for (String line : lines) {
            for (String word : line.split("\\s+")) {
                if (word.length() >= 5)
                    keywords.add(word.replaceAll("[^a-zA-Z가-힣0-9]", ""));
            }
        }
        return keywords;
    }

    // ✂️ 요약 추출: 핵심 3줄 반환
    public static List<String> generateSummary(List<String> lines) {
        List<String> summary = new ArrayList<>();
        for (String line : lines) {
            if (summary.size() >= 3)
                break;
            if (line.trim().length() >= 15)
                summary.add(line.trim());
        }
        return summary;
    }
}
