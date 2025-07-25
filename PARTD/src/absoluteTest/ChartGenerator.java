package absoluteTest;

// 📄 ChartGenerator.java
// 감정 통계 CSV를 기반으로 파이 차트 이미지를 생성합니다.

import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import java.io.*;
import java.util.*;
import java.awt.*;
import java.nio.file.*;

public class ChartGenerator {

    // 📊 감정 통계 차트 이미지 생성
    public static void generateMoodChart(String csvPath, String outputImagePath) throws Exception {
        Map<String, Integer> moodMap = new HashMap<>();

        // 📥 CSV 파일에서 감정 데이터 읽기
        try (BufferedReader reader = new BufferedReader(new FileReader(csvPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String mood = parts[1].trim();
                    moodMap.put(mood, moodMap.getOrDefault(mood, 0) + 1);
                }
            }
        }

        // 📊 파이 차트 데이터셋 생성
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        for (Map.Entry<String, Integer> entry : moodMap.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        // 🖼️ 차트 객체 생성
        JFreeChart chart = ChartFactory.createPieChart("감정 히스토리 분석", dataset, true, true, false);
        PiePlot<?> plot = (PiePlot<?>) chart.getPlot();
        plot.setSectionPaint("긍정", Color.GREEN);
        plot.setSectionPaint("부정", Color.RED);
        plot.setSectionPaint("중립", Color.GRAY);

        // 📂 이미지 저장 폴더가 없으면 생성
        File outFile = new File(outputImagePath);
        outFile.getParentFile().mkdirs(); // ⬅️ 누락 시 저장 안됨

        // 📸 차트 이미지 저장
        ChartUtils.saveChartAsPNG(outFile, chart, 600, 400);

        // ✅ 디버그 로그
        System.out.println("✅ 차트 저장 완료: " + outFile.getAbsolutePath());
    }

    // 📈 감정 CSV에 오늘 감정 추가
    public static void appendMoodStats(String date, String mood) throws IOException {
        Files.createDirectories(Paths.get("charts")); // 디렉토리 보장
        try (FileWriter fw = new FileWriter("mood_stats.csv", true)) {
            fw.write(date + "," + mood + "\n");
        }
    }
}
