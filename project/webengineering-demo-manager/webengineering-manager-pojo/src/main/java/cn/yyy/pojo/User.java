package cn.yyy.pojo;

import java.util.Date;

public class User {
	//用户编号
    private Integer userid;

    //用户名
    private String username;

    //密码（MD5）
    private String password;

    //真实姓名
    private String name;

    //身份证号
    private String idno;

    //手机号
    private String phone;

    //邮箱
    private String mail;

    //注册时间
    private Date jointime;

    //头像url
    private String headicon;
    
    public User(Integer userid, String username, String password, String name, String idno, String phone, String mail, String headicon, Date jointime) {
    	this.setUserid(userid);
    	this.setUsername(username);
    	this.setPassword(password);
    	this.setName(name);
    	this.setIdno(idno);
    	this.setPhone(phone);
    	this.setMail(mail);
    	this.setHeadicon(headicon);
    	this.setJointime(jointime);
    }
    
    public User() {
    	
    }
    

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public Date getJointime() {
        return jointime;
    }

    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }

    public String getHeadicon() {
        return headicon;
    }

    public void setHeadicon(String headicon) {
        this.headicon = headicon == null ? null : headicon.trim();
    }
}