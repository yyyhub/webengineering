package cn.yyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yyy.mapper.SchoolMapper;
import cn.yyy.pojo.School;
import cn.yyy.pojo.SchoolExample;
import cn.yyy.pojo.SchoolExample.Criteria;
import cn.yyy.service.SchoolService;

@Service
public class SchoolServiceImp implements SchoolService{

	@Autowired
	private SchoolMapper schoolMapper;
	
	public School getSchoolBySchoolId(Integer schoolid) {
		School school = schoolMapper.selectByPrimaryKey(schoolid);
		if (school == null)
			throw new RuntimeException("无此学校");
		return school;
	}
	public String getSchoolNameBySchoolId(Integer schoolid) {
		School school = getSchoolBySchoolId(schoolid);
		return school.getSchoolname();
	}
	
	public Integer getSchoolIdBySchoolName(String schoolName) {
		SchoolExample schoolExample = new SchoolExample();
		Criteria criteria = schoolExample.createCriteria();
		criteria.andSchoolnameEqualTo(schoolName);
		List<School> schools = schoolMapper.selectByExample(schoolExample);
		if (schools == null || schools.size() <= 0)
			return null;
		return schools.get(0).getSchoolid();
	}
}
