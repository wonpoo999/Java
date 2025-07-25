package absoluteTest;

public class JavaKeyWord {
    private String keyword;
    private String korean;
    private int level;

    public JavaKeyWord(String keyword, String korean, int level) {
        this.keyword = keyword;
        this.korean = korean;
        this.level = level;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getKorean() {
        return korean;
    }

    public int getLevel() {
        return level;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setKorean(String korean) {
        this.korean = korean;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return keyword + "," + korean + "," + level;
    }
}
