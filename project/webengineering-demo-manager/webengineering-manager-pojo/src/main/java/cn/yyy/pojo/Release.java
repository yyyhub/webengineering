package cn.yyy.pojo;

import java.util.Date;

public class Release extends ReleaseKey {
    private Date releasetime;

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }
}