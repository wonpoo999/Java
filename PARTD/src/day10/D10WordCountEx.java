package day10;

import java.util.*;

public class D10WordCountEx {
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

        // \s 정규식 기호는 공백, 탭, 줄바꿈 이렇게 3개를 뜻하는 기호다. 문자열을 단어로 분리하는 기준이 된다.
        String[] words = lyrics.split("\\s+");
        System.out.println("단어의 갯수 : " + words.length);

        // 앞의 getOrDefault method를 사용해서 단어가 나온 횟수를 Map으로 저장하기
        // 횟수의 합계를 구해서 words.length랑 같은지도 검증해봐야겠지

        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        int sum = 0;
        int maxCount = 0; // 4 회인 단어가 여러개
        StringBuilder sb = new StringBuilder();
        for (String key : countMap.keySet()) {
            int val = countMap.get(key);
            System.out.println(key + "(" + countMap.get(key) + " 회)");
            sum += val; // value (단어의 출현 횟수) 누적합계
            // 출현 횟수 최대값 찾기
            if (val > maxCount) // 현재의 val와 최대횟수 maxCount 비교
                maxCount = val;
        }

        // maxCount에 해당하는 단어를 sb에 추가
        for (String key : countMap.keySet()) {
            if (countMap.get(key) == maxCount) {
                sb.append(key).append(","); // 단어 추가
            }

        }
        System.out.println("출현 단어의 갯수 : " + countMap.size()); // 중복된 단어없이
        System.out.println("단어의 총 출현 횟수 : " + sum);
        System.out.println("최다 출현 단어 : " + sb.toString() + "횟수: " + maxCount);
        // for (String word : words) {
        // for (String word : wordCount.keySet()) {
        // System.out.println(key + " : " + wordCount.get(key));
        // }
    }

}
