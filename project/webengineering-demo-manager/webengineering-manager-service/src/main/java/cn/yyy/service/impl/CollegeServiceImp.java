package cn.yyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yyy.mapper.CollegeMapper;
import cn.yyy.pojo.College;
import cn.yyy.pojo.CollegeExample;
import cn.yyy.pojo.CollegeExample.Criteria;
import cn.yyy.service.CollegeService;

@Service
public class CollegeServiceImp implements CollegeService{
	@Autowired
	private static CollegeMapper collegeMapper;
	
	public College getCollegeByCollegeId(Integer collegeid) {
		College college = collegeMapper.selectByPrimaryKey(collegeid);
		if (college==null)
			return null;
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
