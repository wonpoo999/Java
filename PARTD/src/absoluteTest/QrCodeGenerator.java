package absoluteTest;

// 📄 QrCodeGenerator.java
// HTML 파일 경로 또는 문자열을 QR 코드 이미지로 변환합니다.

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.nio.file.Path;
import java.nio.file.Paths;

public class QrCodeGenerator {

    // 🔲 QR 코드 이미지 생성 함수
    public static void generateQRCode(String text, String filePath) throws Exception {
        int width = 300;
        int height = 300;

        // 문자열을 QR 코드로 인코딩
        BitMatrix matrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
        Path path = Paths.get(filePath);

        // PNG 이미지로 저장
        MatrixToImageWriter.writeToPath(matrix, "PNG", path);
    }
}
