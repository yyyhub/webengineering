package cn.yyy.service;

import cn.yyy.pojo.School;

public interface SchoolService {
	public School getSchoolBySchoolId(Integer schoolid);
	
	public String getSchoolNameBySchoolId(Integer schoolid);
	
	public Integer getSchoolIdBySchoolName(String schoolName);
	
	
}
