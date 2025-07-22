package day09;

import java.io.*; // 파일 저장/읽기 등 입출력 관련 기능
import java.time.LocalDate; // 날짜 정보(가입일 등) 사용
import java.text.SimpleDateFormat; // 백업파일에 날짜를 넣기 위한 포맷
import java.util.*; // List, Scanner 등 유틸리티 클래스

/**
 * 📋 회원 관리 프로그램
 * 주요 기능: 회원 등록, 삭제, 수정, 정렬, 저장, 불러오기, 백업, 경로 변경 등
 */
public class D05MemberManagerAppMine {

    // 👉 프로그램 전체에서 사용할 전역 변수 선언
    private static final Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 스캐너
    private static final List<Membership> members = new ArrayList<>(); // 회원 정보를 담을 리스트
    private static File csvFile = new File("members.csv"); // CSV 저장 파일 기본 위치
    // private static int nextId = 1; // 회원 ID 자동 증가용

    public static void main(String[] args) {
        System.out.println("📋 회원 관리 프로그램 시작");

        loadFromCsv(); // 이전에 저장된 데이터 불러오기

        boolean run = true;
        while (run) {
            // 👉 메인 메뉴 출력
            System.out.println("\n작업 메뉴를 선택하세요.");
            System.out.println("[A] 회원 추가  [R] 회원 삭제  [U] 회원 수정");
            System.out.println("[P] 포인트 수정  [L] 회원 목록 보기");
            System.out.println("[O] 포인트 내림차순  [N] 이름 오름차순");
            System.out.println("[CD] 경로 변경  [PWD] 현재 경로 확인");
            System.out.println("[S] 저장 및 종료");

            String menu = sc.nextLine().trim().toUpperCase(); // 입력값 정리

            // 👉 선택된 메뉴 실행
            switch (menu) {
                case "A" -> addMember(); // 회원 추가
                case "R" -> removeMember(); // 회원 삭제
                case "U" -> updateMember(); // 회원 수정
                case "P" -> updatePoint(); // 포인트만 수정
                case "L" -> showMembers(); // 목록 출력
                case "O" -> sortByPoint(); // 포인트 기준 정렬
                case "N" -> sortByName(); // 이름 기준 정렬
                case "CD" -> changeDirectory(); // 경로 변경
                case "PWD" -> System.out.println("현재 경로: " + csvFile.getAbsolutePath());
                case "S" -> {
                    saveToCsv(); // 저장
                    backupCsv(); // 백업
                    System.out.println("🛑 프로그램을 종료합니다.");
                    run = false;
                }
                default -> System.out.println("⚠️ 잘못된 메뉴입니다.");
            }
        }
    }

    /**
     * ✅ 회원 추가
     * - ID는 자동 증가
     * - 가입일은 현재 날짜
     */
    private static void addMember() {
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine()); // 사용자 입력

            System.out.print("이름: ");
            String name = sc.nextLine();

            System.out.print("별명: ");
            String nickname = sc.nextLine();

            System.out.print("비고: ");
            String remark = sc.nextLine();

            System.out.print("포인트: ");
            double point = Double.parseDouble(sc.nextLine()); // 숫자 입력 받기

            LocalDate joinDate = LocalDate.now(); // 현재 날짜로 가입일 설정

            // 👉 회원 객체 생성 후 리스트에 추가
            members.add(new Membership(id, name, nickname, remark, point, joinDate));
            System.out.println("✅ 회원 추가 완료 (ID: " + id + ")");
        } catch (Exception e) {
            System.out.println("❌ 입력 오류: 숫자 형식 확인");
        }
    }

    /**
     * ✅ 회원 삭제
     * - ID 정확히 입력하면 바로 삭제
     * - 실패 시 → 관리자 인증 후 유사 검색 가능
     */
    private static void removeMember() {
        System.out.print("삭제할 회원의 ID 입력: ");
        String input = sc.nextLine().trim();

        try {
            int id = Integer.parseInt(input); // 입력값을 숫자로 변환
            boolean removed = members.removeIf(m -> m.getId() == id); // 해당 ID의 회원 제거
            if (removed) {
                System.out.println("✅ 삭제 완료");
                return;
            }
        } catch (NumberFormatException e) {
            // 숫자가 아니면 예외 처리하고 유사 검색으로 이동
        }

        // 정확히 일치하는 ID가 없으면 유사 검색 시도
        System.out.print("❓ 정확히 일치하는 회원이 없습니다. 유사 회원을 찾을까요? (Y/N): ");
        if (!sc.nextLine().trim().equalsIgnoreCase("Y")) {
            System.out.println("취소되었습니다.");
            return;
        }

        // 🔐 관리자 인증
        System.out.print("👮 관리자 ID: ");
        String adminId = sc.nextLine().trim();
        System.out.print("🔐 관리자 PW: ");
        String adminPw = sc.nextLine().trim();
        if (!adminId.equals("ADMIN") || !adminPw.equals("ADMIN")) {
            System.out.println("❌ 인증 실패");
            return;
        }

        // 유사 검색: 이름, ID, 별명 중 일부 포함하는 회원 찾기
        System.out.print("이름 또는 ID 일부 입력: ");
        String keyword = sc.nextLine().trim().toLowerCase();

        List<Membership> results = members.stream()
                .filter(m -> String.valueOf(m.getId()).contains(keyword)
                        || m.getName().toLowerCase().contains(keyword)
                        || m.getNickname().toLowerCase().contains(keyword))
                .toList();

        if (results.isEmpty()) {
            System.out.println("❌ 유사 회원 없음");
            return;
        }

        // 유사 회원 목록 출력
        results.forEach(System.out::println);
        System.out.print("삭제할 회원 ID 입력: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean removed = members.removeIf(m -> m.getId() == id);
        System.out.println(removed ? "✅ 삭제 완료" : "❌ 삭제 실패");
    }

    /**
     * ✅ 회원 정보 수정
     * - ID 또는 이름으로 조회
     * - 정확히 일치하지 않으면 관리자 인증 후 유사 검색 가능
     */
    private static void updateMember() {
        System.out.print("수정할 회원의 ID 또는 이름 입력: ");
        String input = sc.nextLine().trim().toLowerCase();

        List<Membership> candidates = new ArrayList<>();

        try {
            int id = Integer.parseInt(input); // 숫자 → ID
            Membership m = findMemberById(id);
            if (m != null)
                candidates.add(m);
        } catch (NumberFormatException e) {
            // 문자 → 이름 또는 별명 검색
            candidates = members.stream()
                    .filter(m -> m.getName().toLowerCase().contains(input)
                            || m.getNickname().toLowerCase().contains(input))
                    .toList();
        }

        // 일치하는 후보 없음 → 관리자 인증 후 유사 검색
        if (candidates.isEmpty()) {
            System.out.print("❓ 유사 회원을 찾아볼까요? (Y/N): ");
            if (!sc.nextLine().trim().equalsIgnoreCase("Y"))
                return;

            // 관리자 인증
            System.out.print("👮 관리자 ID: ");
            String adminId = sc.nextLine().trim();
            System.out.print("🔐 관리자 PW: ");
            String adminPw = sc.nextLine().trim();
            if (!adminId.equals("ADMIN") || !adminPw.equals("ADMIN")) {
                System.out.println("❌ 인증 실패");
                return;
            }

            System.out.print("이름/ID 일부 입력: ");
            String keyword = sc.nextLine().trim().toLowerCase();

            candidates = members.stream()
                    .filter(m -> String.valueOf(m.getId()).contains(keyword)
                            || m.getName().toLowerCase().contains(keyword)
                            || m.getNickname().toLowerCase().contains(keyword))
                    .toList();

            if (candidates.isEmpty()) {
                System.out.println("❌ 유사 회원 없음");
                return;
            }
        }

        // 후보 회원 출력 후 선택
        candidates.forEach(System.out::println);
        System.out.print("수정할 회원의 ID 입력: ");
        int id = Integer.parseInt(sc.nextLine());
        Membership m = findMemberById(id);
        if (m == null) {
            System.out.println("❌ 해당 ID 없음");
            return;
        }

        // 수정 항목 입력
        System.out.print("수정 항목 입력 [name/nickname/remark/point]: ");
        String field = sc.nextLine().trim().toLowerCase();

        switch (field) {
            case "name" -> {
                System.out.print("새 이름: ");
                m.setName(sc.nextLine());
            }
            case "nickname" -> {
                System.out.print("새 별명: ");
                m.setNickname(sc.nextLine());
            }
            case "remark" -> {
                System.out.print("새 비고: ");
                m.setRemark(sc.nextLine());
            }
            case "point" -> {
                System.out.print("새 포인트: ");
                m.setPoint(Double.parseDouble(sc.nextLine()));
            }
            default -> System.out.println("❌ 항목 오류");
        }

        System.out.println("✅ 수정 완료");
    }

    /**
     * ✅ 포인트만 따로 수정
     */
    private static void updatePoint() {
        System.out.print("ID 입력: ");
        int id = Integer.parseInt(sc.nextLine());
        Membership m = findMemberById(id);
        if (m == null) {
            System.out.println("❌ 회원 없음");
            return;
        }

        System.out.print("변경할 포인트: ");
        m.setPoint(Double.parseDouble(sc.nextLine()));
        System.out.println("✅ 포인트 수정 완료");
    }

    /**
     * ✅ 전체 회원 목록 출력
     */
    private static void showMembers() {
        if (members.isEmpty()) {
            System.out.println("⚠️ 회원이 없습니다.");
            return;
        }

        // ✅ 헤더
        System.out.printf("%-6s %-14s %-12s %-20s %20s%n", "ID", "이름", "가입일", "별명", "포인트");
        System.out.println(
                "------------------------------------------------------------------------------------------------------");

        // ✅ 회원 출력
        for (Membership m : members) {
            System.out.printf(
                    "%-6d %-14s %-12s %-20s %,20.0f%n",
                    m.getId(),
                    m.getName(),
                    m.getJoinDate(),
                    m.getNickname(),
                    m.getPoint());

            // ✅ 비고 출력 (줄바꿈 + 들여쓰기 유지)
            String remark = m.getRemark();
            int chunkSize = 50;
            if (remark != null && !remark.isEmpty()) {
                for (int i = 0; i < remark.length(); i += chunkSize) {
                    String part = remark.substring(i, Math.min(i + chunkSize, remark.length()));
                    System.out.printf("      ⮡ 비고: %s%n", part);
                }
            }
        }
    }

    /**
     * ✅ 포인트 내림차순 정렬
     */
    private static void sortByPoint() {
        members.sort(Comparator.comparingDouble(Membership::getPoint).reversed());
        System.out.println("📌 포인트 높은 순으로 정렬 완료");
        showMembers();
    }

    /**
     * ✅ 이름 오름차순 정렬
     */
    private static void sortByName() {
        members.sort(Comparator.comparing(Membership::getName));
        System.out.println("📌 이름 가나다순 정렬 완료");
        showMembers();
    }

    /**
     * ✅ CSV 저장
     * - 현재 회원 데이터를 파일에 저장
     */
    private static void saveToCsv() {
        try (PrintWriter pw = new PrintWriter(csvFile)) {
            pw.println("ID,이름,가입일,별명,비고,포인트"); // ✅ 헤더 추가
            for (Membership m : members) {
                pw.printf("%d,%s,%s,%s,%s,%.2f%n",

                        m.getId(), m.getName(), m.getJoinDate(), m.getNickname(),
                        m.getRemark(), m.getPoint()); // ✅ 필드 순서 수정

            }
            System.out.println("💾 저장 완료");
        } catch (IOException e) {
            System.out.println("❌ 저장 중 오류 발생");
        }
    }

    /**
     * ✅ CSV 불러오기
     * - 이전 저장된 회원 데이터를 다시 불러옴
     * - nextId는 가장 큰 ID 다음으로 보정
     */
    private static void loadFromCsv() {
        if (!csvFile.exists())
            return;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            int maxId = 0;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    if (line.toLowerCase().contains("id"))
                        continue; // 헤더 건너뛰기
                }

                String[] t = line.split(",");
                int id = Integer.parseInt(t[0]);
                String name = t[1];
                LocalDate joinDate = LocalDate.parse(t[2]);
                String nickname = t[3];
                double point = Double.parseDouble(t[4]);
                String remark = t[5];

                members.add(new Membership(id, name, joinDate, nickname, remark, point));
                if (id > maxId)
                    maxId = id;
            }

            // nextId = maxId + 1;
            System.out.println("📂 데이터 불러오기 완료 (" + members.size() + "명)");
        } catch (IOException e) {
            System.out.println("❌ 불러오기 실패");
        }
    }

    /**
     * ✅ 백업 파일 저장
     * - 저장 시점의 데이터를 백업 파일로 따로 저장
     */
    private static void backupCsv() {
        try {
            String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File backup = new File("backup_members_" + date + ".csv");

            try (PrintWriter pw = new PrintWriter(backup)) {
                for (Membership m : members) {
                    pw.printf("%d,%s,%s,%s,%s,%.2f%n",
                            m.getId(), m.getName(), m.getJoinDate(), m.getNickname(), m.getRemark(), m.getPoint());

                }
            }

            System.out.println("🗂 백업 완료: " + backup.getName());
        } catch (IOException e) {
            System.out.println("❌ 백업 실패");
        }
    }

    /**
     * ✅ 저장 디렉토리 변경
     */
    private static void changeDirectory() {
        System.out.print("변경할 디렉토리 경로 입력: ");
        String path = sc.nextLine().trim();
        File newDir = new File(path);

        if (!newDir.exists() || !newDir.isDirectory()) {
            System.out.println("❌ 디렉토리를 찾을 수 없습니다.");
            return;
        }

        csvFile = new File(newDir, "members.csv");
        System.out.println("✅ 디렉토리 변경 완료: " + csvFile.getAbsolutePath());
    }

    /**
     * ✅ ID로 회원 객체 찾기
     */
    private static Membership findMemberById(int id) {
        return members.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
