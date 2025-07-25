package absoluteTest;

// 📄 HtmlZipper.java
// 지정된 HTML 폴더를 ZIP 파일로 압축 저장하는 유틸리티입니다.

import java.io.*;
import java.util.zip.*;

public class HtmlZipper {

    // 🗜 HTML 폴더 ZIP 압축
    public static void zipHtmlFolder(File htmlFolder, File outputZip) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(outputZip);
                ZipOutputStream zos = new ZipOutputStream(fos)) {

            File[] files = htmlFolder.listFiles((f) -> f.getName().endsWith(".html"));
            if (files != null) {
                for (File file : files) {
                    try (FileInputStream fis = new FileInputStream(file)) {
                        ZipEntry entry = new ZipEntry(file.getName());
                        zos.putNextEntry(entry);

                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = fis.read(buffer)) >= 0) {
                            zos.write(buffer, 0, length);
                        }
                        zos.closeEntry();
                    }
                }
            }
        }
    }
}
