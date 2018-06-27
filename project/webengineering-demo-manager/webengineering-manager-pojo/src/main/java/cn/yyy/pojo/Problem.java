package cn.yyy.pojo;

public class Problem extends ProblemKey {
    private String problemname;

    private String solvestatus;

    private String problemcontent;

    public String getProblemname() {
        return problemname;
    }

    public void setProblemname(String problemname) {
        this.problemname = problemname == null ? null : problemname.trim();
    }

    public String getSolvestatus() {
        return solvestatus;
    }

    public void setSolvestatus(String solvestatus) {
        this.solvestatus = solvestatus == null ? null : solvestatus.trim();
    }

    public String getProblemcontent() {
        return problemcontent;
    }

    public void setProblemcontent(String problemcontent) {
        this.problemcontent = problemcontent == null ? null : problemcontent.trim();
    }
}