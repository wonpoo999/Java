package day10;

import java.util.*;

public class D10WordCountExMine {
    public static void main(String[] args) {
        String lyrics = "Longing for you\r\n" +
                "Waiting for you\r\n" +
                "Hold me hold me in your eyes\r\n" +
                "너라는 걸 너뿐인 걸 모르겠니\r\n" +
                "I will be your love\r\n" +
                "오 빨간 운동화\r\n" +
                "짧은 청바지\r\n" +
                "참 어째도 해결이 안 될 것 같은 곱슬머리\r\n" +
                "하지만 왜일까\r\n" +
                "자꾸 끌리는 내 마음이\r\n" +
                "어쩌면 사랑 아닐까\r\n" +
                "Longing for you\r\n" +
                "Waiting for you\r\n" +
                "Hold me hold me in your eyes\r\n" +
                "너라는 걸 너뿐인 걸 모르겠니\r\n" +
                "I will be your love\r\n" +
                "오 착한 눈동자\r\n" +
                "수줍은 표정\r\n" +
                "넌 어쩌면 어릴 적 책 속에 있던 어린 왕자\r\n" +
                "그래서 당연해\r\n" +
                "자꾸 끌리는 내 마음이\r\n" +
                "어쩌면 사랑일 거야\r\n" +
                "Longing for you\r\n" +
                "Waiting for you\r\n" +
                "Hold me hold me in your eyes\r\n" +
                "너라는 걸 너뿐인 걸 모르겠니\r\n" +
                "I will be your love";

        String[] words = lyrics.split("\\s+");
        System.out.println("단어의 갯수 : " + words.length);

        // ▶▶ 로딩 바 출력
        System.out.print("단어 분석 중: [");
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(6); // 0.006초 딜레이
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int barLength = 50;
            int filled = i * barLength / 100;

            StringBuilder bar = new StringBuilder();
            for (int j = 0; j < filled; j++)
                bar.append("■");
            for (int j = filled; j < barLength; j++)
                bar.append(" ");

            System.out.printf("\r단어 분석 중: [%s] %3d%%", bar.toString(), i);
        }
        System.out.println("\n");

        // ▶▶ 단어 개수 세기
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        // ▶▶ 정렬
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(countMap.entrySet());
        sortedList.sort((a, b) -> b.getValue() - a.getValue());

        // ▶▶ 실제 콘솔 폭 기준 가장 긴 단어의 폭 구하기 (한글 2칸, 영문 1칸으로 계산)
        int maxVisualWidth = 0;
        for (Map.Entry<String, Integer> entry : sortedList) {
            int visualWidth = getVisualWidth(entry.getKey());
            if (visualWidth > maxVisualWidth)
                maxVisualWidth = visualWidth;
        }

        // ▶▶ 출력
        int sum = 0;
        System.out.println("[단어 출현 빈도]");
        System.out.println("─".repeat(maxVisualWidth + 10));
        for (Map.Entry<String, Integer> entry : sortedList) {
            String word = entry.getKey();
            int count = entry.getValue();
            int wordWidth = getVisualWidth(word);
            int padding = maxVisualWidth - wordWidth;
            System.out.printf("%s%s : %3d 회%n", word, " ".repeat(padding), count);
            sum += count;
        }
        System.out.println("─".repeat(maxVisualWidth + 10));
        System.out.printf("출현 단어의 종류 수 : %d개%n", countMap.size());
        System.out.printf("단어의 총 출현 횟수 : %d회%n", sum);
    }

    // ▶▶ 유틸 함수: 한글은 2칸, 영문/숫자는 1칸으로 계산
    public static int getVisualWidth(String s) {
        int width = 0;
        for (char ch : s.toCharArray()) {
            if (isKorean(ch))
                width += 2;
            else
                width += 1;
        }
        return width;
    }

    // ▶▶ 한글 여부 체크
    public static boolean isKorean(char ch) {
        return (ch >= 0xAC00 && ch <= 0xD7A3);
    }
}
