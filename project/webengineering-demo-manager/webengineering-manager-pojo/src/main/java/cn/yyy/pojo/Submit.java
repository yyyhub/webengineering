package cn.yyy.pojo;

public class Submit extends SubmitKey {
    private String submitstatus;

    public String getSubmitstatus() {
        return submitstatus;
    }

    public void setSubmitstatus(String submitstatus) {
        this.submitstatus = submitstatus == null ? null : submitstatus.trim();
    }
}