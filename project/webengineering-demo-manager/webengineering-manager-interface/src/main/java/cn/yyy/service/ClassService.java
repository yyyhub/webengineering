package cn.yyy.service;

import java.util.List;

import cn.yyy.pojo.Class;

public interface ClassService {
	public Class getClassByClassId(Integer classid);
	
	public List<Class> getAllClassByCourseid(Integer courseid);
}
