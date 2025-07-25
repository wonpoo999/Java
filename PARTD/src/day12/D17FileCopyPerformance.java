package day12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class D17FileCopyPerformance {

    public static void main(String[] args) {

        // 실행 시작한 시간 저장
        long start = System.nanoTime(); // 10억분의 1초

        // copyByByte();
        // 대용량 이미지 일때, 메소드에 입출력 단위 지정 vs 자바의 버퍼클래스를 사용
        // -> 성능 차이 있음.
        // copyByByteArray(); // 3.732775501 초
        copyByBufferStream(); // 0.740495899 초
        // 실행 종료한 시간 저장
        long end = System.nanoTime();
        System.out.println("소요 시간 : " + (double) (end - start) / 1000000000 + " 초");

    }

    public static void copyByBufferStream() {
        int b;
        int count = 0;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null; // 추가적인 버퍼를 활용한 입력스트림
        BufferedOutputStream bos = null; // 출력
        byte[] buffer = new byte[1024];
        try {

            fis = new FileInputStream("C:\\Users\\Class01\\Downloads\\test.tif");
            fos = new FileOutputStream("C:\\Users\\Class01\\Downloads\\people1.tif");
            // 버퍼스트림 : 입출력 스트림 내부에서 추가적인 버퍼를 사용하는 보조 스트림
            bis = new BufferedInputStream(fis); // 생성자 인자 기본 입력 스트림
            bos = new BufferedOutputStream(fos); // 생성자 인자 기본 출력 스트림

            while ((b = bis.read(buffer, 0, buffer.length)) != -1) {
                bos.write(buffer, 0, b); // 읽은 바이트수 b 만큼 쓰기
                count += b;
            }

            System.out.println(count + " 바이트를 복사했습니다.");
        } catch (IOException e) {
            System.out.println("파일 입출력 : " + e.getMessage());
        }
    }

    public static void copyByByteArray() { // 바이트배열을 이용하여 입출력단위를 개선
        FileInputStream fis = null;
        FileOutputStream fos = null;
        byte[] buffer = new byte[1024]; // 1kb. 프로그램에서 입출력 단위를 1024바이트로 설정.

        try {
            int b;
            int count = 0;
            fis = new FileInputStream("C:\\Users\\Class01\\Downloads\\test.tif");
            fos = new FileOutputStream("C:\\Users\\Class01\\Downloads\\people2.tif");
            while ((b = fis.read(buffer, 0, buffer.length)) != -1) { // 파일의 끝 EOF 는 -1
                // fis.read(buffer, 0, buffer.length) : byte 배열에서 정한 크기만큼 읽어오기
                // 실제 읽은 바이트 수는 리턴 받아 b 에 저장.
                fos.write(buffer, 0, b); // 읽은 바이트 수만큼 출력
                count += b;
            }
            System.out.println(count + " 바이트 복사되었습니다.");

        } catch (IOException e) {
            System.out.println("파일 입출력 : " + e.getMessage());
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
            }
            ;
        }
    }

    public static void copyByByte() { // 바이트 단위로 복사
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            int b;
            int count = 0;
            fis = new FileInputStream("C:\\Users\\Class01\\Downloads\\skyview.jpg");
            fos = new FileOutputStream("C:\\Users\\Class01\\Downloads\\people3.tif");
            while ((b = fis.read()) != -1) { // 바이트 순서대로 읽어오기. 파일의 끝 EOF 는 -1
                fos.write(b);
                count++;
            }
            System.out.println(count + " 바이트 복사되었습니다.");

        } catch (IOException e) {
            System.out.println("파일 입출력 : " + e.getMessage());
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
            }
            ;
        }
    }

}