package day12;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FileRWApp {
    public static void main(String[] args) throws IOException {
        FileRWApp app = new FileRWApp();
        String filePath = "java_keyword.csv";

        List<JavaKeyWord> list = app.loadWords(filePath);
        System.out.println("--------------------------------------");
        for (JavaKeyWord kw : list) {
            System.out.println(kw);
        }
        System.out.println("--------------------------------------");

        System.out.println("level 별 출력");
        IntStream.range(0, 3).forEach(i -> { // list.stream 을 반복하는 stream
            System.out.println("레벨 " + (i + 1) + " ------------");
            list.stream().filter((word) -> word.level() == i + 1)
                    .forEach(word -> System.out.println(word));
        });

        String yn = System.console().readLine("새로운 단어를 추가할까요? (확인:엔터, 취소:N) >> ");
        if (yn.length() == 0 || !yn.toUpperCase().equals("N")) {
            app.saveKeyword(new JavaKeyWord("final", "최종의", 1), filePath);
        }

        yn = System.console().readLine("새로운 단어를 추가할까요? (확인:엔터, 취소:N) >> ");
        if (yn.length() == 0 || !yn.toUpperCase().equals("N")) {
            app.saveKeyword(new JavaKeyWord("construct", "건설하다", 2), filePath);
        }

        List<JavaKeyWord> list2 = app.loadWords(filePath);
        System.out.println("--------------------------------------");
        for (JavaKeyWord kw : list2) {
            System.out.println(kw);
        }
        System.out.println("--------------------------------------");
    }

    private List<JavaKeyWord> loadWords(String filePath) {
        List<JavaKeyWord> list = new ArrayList<>();

        int count = 0;

        try (
                FileReader file = new FileReader(filePath, Charset.forName("UTF-8"));
                Scanner fileSc = new Scanner(file);) {

            while (fileSc.hasNext()) {
                String temp = fileSc.nextLine();
                String[] lineArr = temp.split(",");
                list.add(new JavaKeyWord(lineArr[0], lineArr[1], Integer.parseInt(lineArr[2])));
                count++;
            }
            System.out.println(count + " 개 단어를 가져왔습니다.");

        } catch (IOException e) {

            System.out.println("예외 발생 : " + e.getMessage());
            return null;
        }
        return list;
    }

    private void saveKeyword(JavaKeyWord word, String filepath) {

        try (
                FileWriter fw = new FileWriter(filepath, Charset.forName("UTF-8"), true);
                PrintWriter pw = new PrintWriter(fw);) {

            String line = String.format("%s,%s,%s", word.keyword(), word.korean(), word.level());
            pw.println(line);
        } catch (Exception e) {
            System.out.println("예외 발생 : " + e.getMessage());
        }
    }

}

// 불변 객체 : getter, toString, hashcode ,equals
// 데이터 저장하는 클래스 만들 때 boilerplate 코드를 줄이는 형식
record JavaKeyWord(String keyword, String korean, int level) {

    @Override
    public final String toString() {
        return keyword + ": " + korean + "(level " + level + ")";
    }
}