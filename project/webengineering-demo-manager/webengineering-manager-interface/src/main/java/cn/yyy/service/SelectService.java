package cn.yyy.service;

import java.util.List;

import cn.yyy.pojo.SelectKey;

public interface SelectService {
	public List<SelectKey> getSelectsByClassId(Integer classid);
	
	public List<SelectKey> getSelectsIdByStudentid(Integer studentid);
}
