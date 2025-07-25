package day12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class D15FileTestMine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 기본 파일 이름 입력
        System.out.print("파일 제목을 입력하세요 (예: diary): ");
        String baseName = sc.nextLine().trim();

        // 2. 날짜 추가
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = baseName + "_" + timestamp + ".txt";
        File file = new File(filename);

        // 3. 중복 방지: 파일명이 이미 있으면 _1, _2 추가
        int count = 1;
        while (file.exists()) {
            filename = baseName + "_" + timestamp + "_" + count + ".txt";
            file = new File(filename);
            count++;
        }

        try {
            // 4. 파일 생성
            if (file.createNewFile()) {
                System.out.println("✅ 새 파일이 생성되었습니다: " + filename);
            }

            // 5. 덮어쓰기 or 이어쓰기 선택
            System.out.print("내용을 이어쓰시겠습니까? (Y/n): ");
            String appendChoice = sc.nextLine().trim();
            boolean append = appendChoice.equalsIgnoreCase("Y") || appendChoice.isEmpty();

            // 6. 내용 입력
            System.out.println("📥 저장할 내용을 입력하세요. (종료하려면 'exit'):");
            StringBuilder content = new StringBuilder();
            while (true) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("exit"))
                    break;
                content.append(line).append(System.lineSeparator());
            }

            // 7. 파일 저장
            FileWriter writer = new FileWriter(file, append); // append 모드 적용
            writer.write(content.toString());
            writer.close();

            System.out.println("✅ 파일 저장 완료!");
            System.out.println("📁 파일 이름 : " + file.getName());
            System.out.println("📂 파일 경로 : " + file.getAbsolutePath());
            System.out.println("📏 파일 크기 : " + file.length() + " bytes");

        } catch (IOException e) {
            System.out.println("❌ 파일 처리 중 예외 발생: " + e.getMessage());
        }

        sc.close();
    }
}
