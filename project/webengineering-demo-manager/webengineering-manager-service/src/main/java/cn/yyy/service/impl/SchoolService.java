package cn.yyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.yyy.mapper.SchoolMapper;
import cn.yyy.pojo.School;
import cn.yyy.pojo.SchoolExample;
import cn.yyy.pojo.SchoolExample.Criteria;

public class SchoolService {

	@Autowired
	private static SchoolMapper schoolMapper;
	
	public static String getSchoolNameBySchoolId(Integer schoolid) {
		SchoolExample schoolExample = new SchoolExample();
		Criteria criteria = schoolExample.createCriteria();
		criteria.andSchoolidEqualTo(schoolid);
		List<School> schools = schoolMapper.selectByExample(schoolExample);
		if (schools != null)
			return schools.get(0).getSchoolname();
		return "";
	}
}
