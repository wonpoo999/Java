package absoluteTest;

// 📄 PdfGenerator.java
// 메모 내용을 PDF 파일로 저장하는 클래스입니다.

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.*;

import java.io.File;
import java.util.Set;

public class PdfGenerator {

    // 📝 텍스트 및 정보 기반 PDF 생성
    public static void generatePdfFromText(String title, String content, String summary, String mood,
            Set<String> keywords, File outputPdf) throws Exception {

        // 상위 폴더 없을 시 생성
        File parentDir = outputPdf.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        // PDF 쓰기
        PdfWriter writer = new PdfWriter(outputPdf);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document doc = new Document(pdfDoc);

        // 제목, 감정, 키워드, 요약
        doc.add(new Paragraph("📘 " + title).setBold().setFontSize(16));
        doc.add(new Paragraph("감정 분석: " + mood));
        doc.add(new Paragraph("키워드: " + String.join(", ", keywords)));
        doc.add(new Paragraph("요약: " + summary).setItalic());

        doc.add(new Paragraph("\n본문 내용:\n"));
        doc.add(new Paragraph(content));

        doc.close();
    }
}
