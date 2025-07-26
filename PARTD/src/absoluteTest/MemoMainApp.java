package absoluteTest;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class MemoMainApp {
    private static final Scanner sc = new Scanner(System.in, "UTF-8");

    // #region 저장 메뉴 안내
    private static final String MENU = """
            =================================================
            📋 \\menu 입력 시 사용 가능한 기능:

            1️⃣  1 - html     : HTML로 저장
            2️⃣  2 - pdf      : PDF로 저장
            3️⃣  3 - txt      : 텍스트(.txt) 파일 저장
            4️⃣  4 - excel    : Excel(.xlsx) 저장
            5️⃣  5 - csv      : CSV 저장
            6️⃣  6 - qr       : QR 코드 이미지 생성
            7️⃣  7 - zip      : HTML 압축(zip) 저장
            8️⃣  8 - chart    : 감정 통계 차트 생성
            9️⃣  9 - all      : 전체 저장 (html~csv 포함)
            🆀  q - reset     : 새 입력으로 초기화
            🆆  w - resume    : 이어쓰기 복원
            🆂  e - exit      : 종료
            🆁  r - read       : 파일 읽기 (html, csv, pdf, 이미지 등)
            🆃  t - transform  : JavaKeyWord 변환 및 저장
            🆈  y - append     : JavaKeyWord 객체 2개 CSV 저장
            🆄  u - wordcount : 자바 소스 단어 출현 카운트

            =================================================
            """;

    // #endregion

    private static String lastReadContent = ""; // t에서 사용하기 위한 데이터
    private static final List<JavaKeyWord> keywords = new ArrayList<>();

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("⚠️ LookAndFeel 설정 실패: " + e.getMessage());
        }

        String titleBackup = null;
        StringBuilder contentBackup = new StringBuilder();
        List<String> linesBackup = new ArrayList<>();

        while (true) {
            try {
                System.out.println(MENU);
                System.out.print("제목을 입력하세요: ");
                String title = sc.nextLine().trim();
                if (title.isBlank())
                    continue;

                System.out.println("내용을 입력하세요 (\\menu 입력 시 저장 메뉴로 이동):");
                StringBuilder content = new StringBuilder();
                List<String> lines = new ArrayList<>();

                while (true) {
                    System.out.print(">> ");
                    String line = sc.nextLine();

                    if (line.trim().equalsIgnoreCase("\\menu")) {
                        System.out.print("⚠️ 내용을 종료하고 저장 메뉴로 이동하시겠습니까? (y/n): ");
                        if (sc.nextLine().trim().equalsIgnoreCase("y"))
                            break;
                        else
                            continue;
                    }

                    lines.add(line);
                    content.append(line).append("\n");
                    System.out.println(">> 입력됨: " + line);
                }

                titleBackup = title;
                contentBackup = new StringBuilder(content);
                linesBackup = new ArrayList<>(lines);

                String mood = Analyzer.analyzeMood(lines);
                Set<String> keywordSet = Analyzer.extractKeywords(lines);
                List<String> summary = Analyzer.generateSummary(lines);

                while (true) {
                    System.out.println(MENU);
                    System.out.print("⚙️ 저장 옵션 선택: ");
                    String command = sc.nextLine().trim().toLowerCase();

                    try {
                        switch (command) {

                            case "1":
                            case "html":
                                File file1 = getSaveFile("html", ".html");
                                HtmlWriter.writeHtmlFile(file1, title, content.toString(), mood,
                                        keywordSet, summary);
                                System.out.println("✅ HTML 저장 완료");
                                break;

                            case "2":
                            case "pdf":
                                File file2 = getSaveFile("pdf", ".pdf");
                                PdfGenerator.generatePdfFromText(title, content.toString(),
                                        String.join("\n", summary), mood, keywordSet, file2);
                                System.out.println("✅ PDF 저장 완료");
                                break;

                            case "3":
                            case "txt":
                                File file3 = getSaveFile("txt", ".txt");
                                TextSaver.saveTextFile(file3, title, content.toString());
                                System.out.println("✅ TXT 저장 완료");
                                break;

                            case "4":
                            case "excel":
                                File file4 = getSaveFile("excel", ".xlsx");
                                ExcelSaver.saveExcelFile(file4, title, content.toString());
                                System.out.println("✅ Excel 저장 완료");
                                break;

                            case "5":
                            case "csv":
                                File file5 = getSaveFile("csv", ".csv");
                                CsvSaver.saveAsCsv(file5, title, content.toString());
                                System.out.println("✅ CSV 저장 완료");
                                break;

                            case "6":
                            case "qr":
                                File file6 = getSaveFile("qrcodes", ".png");
                                QrCodeGenerator.generateQRCode("내용: " + content,
                                        file6.getAbsolutePath());
                                System.out.println("✅ QR 코드 저장 완료");
                                break;

                            case "7":
                            case "zip":
                                File file7 = getSaveFile("html_zip", ".zip");
                                HtmlZipper.zipHtmlFolder(new File("html"), file7);
                                System.out.println("✅ ZIP 압축 완료");
                                break;

                            case "8":
                            case "chart":
                                ChartGenerator.appendMoodStats(DateUtil.getToday(), mood);
                                ChartGenerator.generateMoodChart("mood_stats.csv",
                                        "charts/mood_chart_" + DateUtil.getToday() + ".png");
                                System.out.println("✅ 차트 생성 완료");
                                break;

                            case "9":
                            case "all":
                                HtmlWriter.writeHtmlFile(getSaveFile("html", ".html"), title,
                                        content.toString(), mood, keywordSet, summary);
                                PdfGenerator.generatePdfFromText(title, content.toString(),
                                        String.join("\n", summary), mood, keywordSet,
                                        getSaveFile("pdf", ".pdf"));
                                QrCodeGenerator.generateQRCode("내용: " + content,
                                        getSaveFile("qrcodes", ".png").getAbsolutePath());
                                HtmlZipper.zipHtmlFolder(new File("html"),
                                        getSaveFile("html_zip", ".zip"));
                                ChartGenerator.appendMoodStats(DateUtil.getToday(), mood);
                                ChartGenerator.generateMoodChart("mood_stats.csv",
                                        "charts/mood_chart_" + DateUtil.getToday() + ".png");
                                TextSaver.saveTextFile(getSaveFile("txt", ".txt"), title,
                                        content.toString());
                                ExcelSaver.saveExcelFile(getSaveFile("excel", ".xlsx"), title,
                                        content.toString());
                                CsvSaver.saveAsCsv(getSaveFile("csv", ".csv"), title,
                                        content.toString());
                                System.out.println("✅ 전체 저장 완료");
                                break;

                            case "q":
                            case "reset":
                                System.out.println("🔄 새 메모를 작성하세요.");
                                break;

                            case "w":
                            case "resume":
                                if (titleBackup != null && !linesBackup.isEmpty()) {
                                    System.out.println("✅ 이어쓰기 복원 완료");
                                    title = titleBackup;
                                    content = new StringBuilder(contentBackup);
                                    lines = new ArrayList<>(linesBackup);
                                } else {
                                    System.out.println("⚠️ 복원할 내용이 없습니다.");
                                }
                                break;

                            case "e":
                            case "exit":
                                System.out.println("👋 종료합니다.");
                                return;

                            case "r":
                            case "read":
                                File readFile = chooseFile();
                                String result = FileReaderHelper.tryReadFile(readFile);
                                if (result != null) {
                                    System.out.println("✅ 해석 가능, 내용 일부:");
                                    System.out.println(
                                            result.length() > 300 ? result.substring(0, 300) + "..."
                                                    : result);
                                    lastReadContent = result;
                                } else {
                                    System.out.println("❌ 해석 불가: 이진 파일 또는 알 수 없는 형식");
                                }
                                break;

                            case "t":
                            case "transform":
                                if (lastReadContent.isEmpty()) {
                                    System.out.println("⚠️ 먼저 r(read)로 파일을 읽으세요.");
                                } else {
                                    keywords.clear();
                                    for (String line : lastReadContent.split("\n")) {
                                        if (line.strip().isEmpty())
                                            continue;
                                        keywords.add(new JavaKeyWord(line.strip(), "설명 없음", 1));
                                    }
                                    File file = getSaveFile("converted", chooseExtension());
                                    JavaKeyWordSaver.save(file, keywords);
                                    System.out.println("✅ 변환 완료: " + keywords.size() + "개 키워드 저장");
                                }
                                break;

                            case "y":
                            case "append":
                                JavaKeyWord k1 = new JavaKeyWord("interface", "추상 메서드의 집합", 1);
                                JavaKeyWord k2 = new JavaKeyWord("lambda", "간결한 함수 표현식", 1);

                                keywords.add(k1);
                                keywords.add(k2);
                                File file = new File("java_keyword.csv");
                                JavaKeyWordSaver.appendToCsv(file, List.of(k1, k2));
                                System.out.println("✅ CSV에 키워드 2개 추가 저장");
                                break;

                            case "u":
                            case "wordcount":
                                try {
                                    File javaFile = chooseFile();

                                    if (!javaFile.getName().endsWith(".java")) {
                                        System.out.println("⚠️ .java 파일만 선택 가능합니다.");
                                        return;
                                    }

                                    Map<String, Integer> wordStats =
                                            JavaWordCounter.countWordsInJavaFile(javaFile);
                                    JavaWordCounter.printResult(wordStats);

                                    // 저장 여부 묻기
                                    System.out.print("결과를 저장할까요? (y/n): ");
                                    String yn = sc.nextLine().trim().toLowerCase();
                                    if (yn.equals("y")) {
                                        File out = getSaveFile("wordcount", ".txt");
                                        try (PrintWriter pw = new PrintWriter(out, "UTF-8")) {
                                            wordStats.entrySet().stream().sorted(
                                                    (a, b) -> b.getValue().compareTo(a.getValue()))
                                                    .forEach(e -> pw.printf("%-15s : %d\n",
                                                            e.getKey(), e.getValue()));
                                            System.out.println("✅ 저장 완료: " + out.getAbsolutePath());
                                        }
                                    }

                                } catch (Exception e) {
                                    System.out.println("❌ 처리 중 오류 발생: " + e.getMessage());
                                    e.printStackTrace(); // 디버깅을 위해 추가
                                }
                                break;



                            default:
                                System.out.println("⚠️ 알 수 없는 명령입니다.");
                                break;
                        }



                        if (command.equals("q") || command.equals("reset"))
                            break;
                    } catch (Exception e) {
                        System.out.println("❌ 저장 실패: " + e.getMessage());
                    }
                }

            } catch (Exception e) {
                System.out.println("❌ 시스템 오류 발생: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    // 파일 저장 경로 선택
    private static File getSaveFile(String subDir, String extension) {
        File dir = new File("C:/Class250615", subDir);
        if (!dir.exists())
            dir.mkdirs();

        String filename = DateUtil.getNowTime() + extension;
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("저장 위치 선택");
        chooser.setCurrentDirectory(dir);
        chooser.setSelectedFile(new File(dir, filename));

        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        int result = chooser.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            if (!f.getName().endsWith(extension))
                f = new File(f.getAbsolutePath() + extension);
            return f;
        }
        throw new RuntimeException("사용자가 저장을 취소했습니다.");
    }

    // 파일 열기 대화상자
    private static File chooseFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("파일 열기");
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
            return chooser.getSelectedFile();
        else
            throw new RuntimeException("사용자가 파일 선택을 취소했습니다.");
    }

    // 확장자 선택
    private static String chooseExtension() {
        System.out.print("저장 형식을 선택하세요 (txt/csv/html/pdf/excel): ");
        String ext = sc.nextLine().trim().toLowerCase();
        return switch (ext) {
            case "txt" -> ".txt";
            case "csv" -> ".csv";
            case "html" -> ".html";
            case "pdf" -> ".pdf";
            case "excel" -> ".xlsx";
            default -> ".txt";
        };
    }
}
