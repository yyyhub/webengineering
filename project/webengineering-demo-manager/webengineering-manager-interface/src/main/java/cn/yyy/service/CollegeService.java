package cn.yyy.service;

import cn.yyy.pojo.College;

public interface CollegeService {
	public College getCollegeByCollegeId(Integer collegeid);
	
	public String getCollegeNameByCollegeId(Integer collegeid);
	
	public Integer getCollegeIdByCollegeName(String collegeName);
	
	public College getCollegeByCollegeName(String collegeName);
	
	public void addCollege(College college);
}
