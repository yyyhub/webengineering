package cn.yyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.yyy.mapper.SelectMapper;
import cn.yyy.pojo.SelectExample;
import cn.yyy.pojo.SelectExample.Criteria;
import cn.yyy.pojo.SelectKey;

public class SelectServiceImp {
	@Autowired
	private SelectMapper selectMapper;
	
	public List<SelectKey> getSelectsByClassId(Integer classid) {
		SelectExample selectExample = new SelectExample();
		Criteria criteria = selectExample.createCriteria();
		criteria.andClassidEqualTo(classid);
		List<SelectKey> selectKeys = selectMapper.selectByExample(selectExample);
		return selectKeys;
	}
	
	public List<SelectKey> getSelectsIdByStudentid(Integer studentid) {
		SelectExample selectExample = new SelectExample();
		Criteria criteria = selectExample.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		List<SelectKey> selectKeys = selectMapper.selectByExample(selectExample);
		return selectKeys;
	}
}
