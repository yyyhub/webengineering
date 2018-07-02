package cn.yyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.yyy.mapper.ClassMapper;
import cn.yyy.pojo.Class;
import cn.yyy.pojo.ClassExample;
import cn.yyy.pojo.ClassExample.Criteria;

public class ClassServiceImp {
	@Autowired
	private ClassMapper classMapper;
	
	public Class getClassByClassId(Integer classid) {
		Class clazz = classMapper.selectByPrimaryKey(classid);
		if (clazz == null)
			throw new RuntimeException("无此班级");
		return clazz;
	}
	
	public List<Class> getAllClassByCourseid(Integer courseid){
		ClassExample classExample = new ClassExample();
		Criteria criteria = classExample.createCriteria();
		criteria.andCourseidEqualTo(courseid);
		List<Class> classes = classMapper.selectByExample(classExample);
		return classes;
	}
}
