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
	
	public static String getCollegeNameByCollegeId(Integer collegeid) {
		CollegeExample collegeExample = new CollegeExample();
		Criteria criteria = collegeExample.createCriteria();
		criteria.andCollegeidEqualTo(collegeid);
		List<College> colleges = collegeMapper.selectByExample(collegeExample);
		if (colleges != null)
			return colleges.get(0).getCollegename();
		return "";
	}
}
