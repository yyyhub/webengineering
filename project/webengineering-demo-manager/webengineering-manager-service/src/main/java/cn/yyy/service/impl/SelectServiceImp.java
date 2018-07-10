package cn.yyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yyy.mapper.SelectMapper;
import cn.yyy.pojo.SelectExample;
import cn.yyy.pojo.SelectExample.Criteria;
import cn.yyy.pojo.SelectKey;
import cn.yyy.service.SelectService;

@Service
public class SelectServiceImp implements SelectService{
	@Autowired
	private SelectMapper selectMapper;
	
	public List<SelectKey> getSelectsByClassId(Integer classid) {
		List<SelectKey> selectKeys = selectMapper.selectByCalssid(classid);
		return selectKeys;
	}
	
	public List<SelectKey> getSelectsIdByStudentid(Integer studentid) {
		List<SelectKey> selectKeys = selectMapper.selectByStudentid(studentid);
		return selectKeys;
	}
}
