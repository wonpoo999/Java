package day12;

import java.awt.FileDialog;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class D16ImageCopyTest {
    public static void main(String[] args) {

        FileInputStream FileInputStream = null;
        FileOutputStream FileOutputStream = null;

        try {
            int b;
            int count = 0;
            // 파일 읽기 (이미지파일 선택 예정)
            String readFilename = D15FileTest.showFileDialog("파일 선택", FileDialog.LOAD);
            FileInputStream = new FileInputStream(readFilename);

            // 파일 쓰기 (저장)
            String saveFileName = D15FileTest.showFileDialog("파일 저장", FileDialog.SAVE);
            FileOutputStream = new FileOutputStream(saveFileName); // 쓰기를 위한 스트림

            while ((b = FileInputStream.read()) != -1) { // b = FileInpustStream.read() 한개의 byte를 읽어온다.
                // b = FileInputStream.read() 입력 버퍼에서 한개의 바이트를 읽어옵니다. (파일의 끝 -1)
                // 프로그램 변수에 저장할 때는 int 타입 저장
                count++;
                FileOutputStream.write(b);
            }
            System.out.println("읽어온 byte 수 : " + count + "bytes");
            System.out.println(count + "바이트 파일 복사 성공!");

        } catch (Exception e) {

        } finally {
            try { // 리소스는 정리(해제)
                FileInputStream.close();
                FileOutputStream.close();
            } catch (IOException e) {

            }
        }
    }
}
