package io.ukoko.bhwms.enums;

/**
 * 仓库状态枚举
 */
public enum RepoStatus {
    FAULT(0,"故障"),
    NORMAL(1,"正常"),
    FULL(2,"已满"),
    DISCARD(3,"废弃");
    private int c;//编号
    private String m;//描述
    RepoStatus(int c, String m) {
        this.c = c;
        this.m = m;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return "RepoStatus{" +
                "c=" + c +
                ", m='" + m + '\'' +
                '}';
    }
}
