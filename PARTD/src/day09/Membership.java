package day09;

import java.time.LocalDate;

/**
 * 회원 정보를 저장하는 클래스
 */
public class Membership {
    private int id;
    private String name;
    private String nickname;
    private String remark;
    private double point;
    private LocalDate joinDate;

    // 생성자 (모든 필드 초기화)
    // 기존 생성자
    public Membership(int id, String name, String nickname, String remark, double point, LocalDate joinDate) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.remark = remark;
        this.point = point;
        this.joinDate = joinDate;
    }

    // ➕ 새로 추가할 생성자
    public Membership(int id, String name, LocalDate joinDate, String nickname, String remark, double point) {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
        this.nickname = nickname;
        this.remark = remark;
        this.point = point;
    }

    // getter / setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    // 등급 계산 (A/B/C)
    public String getGrade() {
        if (point >= 90)
            return "A";
        else if (point >= 70)
            return "B";
        else
            return "C";
    }

    // 문자열로 회원 정보 표현
    @Override
    public String toString() {
        return String.format(
                "%-5d %-10s %-12s %-15s %-30s %-15.0f %-3s",
                id, name, joinDate.toString(), nickname, remark, point, getGrade());
    }
}