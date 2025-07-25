package absoluteTest;

// 📄 HtmlWriter.java
// 메모 내용을 HTML 파일로 저장하는 클래스입니다.

import java.io.*;
import java.util.Set;
import java.util.List;

public class HtmlWriter {

    public static void writeHtmlFile(File file, String title, String content, String mood, Set<String> keywords,
            List<String> summary) throws IOException {
        file.getParentFile().mkdirs(); // 폴더 없으면 생성

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            String color = mood.equals("긍정") ? "green" : (mood.equals("부정") ? "red" : "gray");

            writer.write("<html><meta charset='UTF-8'><body>");
            writer.write("<h2 style='color:" + color + "'>" + title + "</h2>");
            writer.write("<p><b>감정:</b> " + mood + "</p>");
            writer.write("<p><b>키워드:</b> " + String.join(", ", keywords) + "</p>");
            writer.write("<p><b>요약:</b><ul>");
            for (String line : summary) {
                writer.write("<li>" + line + "</li>");
            }
            writer.write("</ul></p><hr><pre>");
            writer.write(content);
            writer.write("</pre></body></html>");
        }
    }
}
