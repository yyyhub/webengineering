package cn.yyy.pojo;

import java.util.Date;

public class Arrange extends ArrangeKey {
    private Date arrangetime;

    private Date deadline;

    public Date getArrangetime() {
        return arrangetime;
    }

    public void setArrangetime(Date arrangetime) {
        this.arrangetime = arrangetime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}