package cn.yyy.service;

import java.util.List;

import cn.yyy.pojo.Class;

public interface ClassService {
	/**
	 * 根据班级id获取班级
	 * @param classid
	 * @return 班级对象
	 */
	public Class getClassByClassId(Integer classid);
	
	/**
	 * 根据课程号id返回班级列表
	 * @param courseid
	 * @return 班级列表
	 */
	public List<Class> getAllClassByCourseid(Integer courseid);
}
