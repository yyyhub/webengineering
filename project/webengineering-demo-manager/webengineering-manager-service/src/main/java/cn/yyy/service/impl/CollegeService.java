package cn.yyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.yyy.mapper.CollegeMapper;
import cn.yyy.pojo.College;
import cn.yyy.pojo.CollegeExample;
import cn.yyy.pojo.CollegeExample.Criteria;

public class CollegeService {
	@Autowired
	private static CollegeMapper collegeMapper;
	
	public College getCollegeByCollegeId(Integer collegeid) {
		College college = collegeMapper.selectByPrimaryKey(collegeid);
		if (college==null)
			throw new RuntimeException("无此学院");
		return college;
	}
	
	public String getCollegeNameByCollegeId(Integer collegeid) {
		College college = getCollegeByCollegeId(collegeid);
		return college.getCollegename();
	}
	
	public Integer getCollegeIdByCollegeName(String collegeName) {
		CollegeExample collegeExample = new CollegeExample();
		Criteria criteria = collegeExample.createCriteria();
		criteria.andCollegenameEqualTo(collegeName);
		List<College> colleges = collegeMapper.selectByExample(collegeExample);
		if (colleges == null || colleges.size() <= 0)
			return null;
		return colleges.get(0).getCollegeid();
	}
	
	public College getCollegeByCollegeName(String collegeName) {
		CollegeExample collegeExample = new CollegeExample();
		Criteria criteria = collegeExample.createCriteria();
		criteria.andCollegenameEqualTo(collegeName);
		List<College> colleges = collegeMapper.selectByExample(collegeExample);
		if (colleges == null || colleges.size() <= 0)
			return null;
		return colleges.get(0);
	}
	
	public void addCollege(College college) {
		collegeMapper.insert(college);
	}
}
