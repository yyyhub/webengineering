package cn.yyy.service;

import cn.yyy.pojo.College;

public interface CollegeService {
	
	/**
	 * 根据学院id获得学院对象
	 * @param collegeid
	 * @return 学院对象
	 */
	public College getCollegeByCollegeId(Integer collegeid);
	
	/**
	 * 根据学院id获得学院名
	 * @param collegeid
	 * @return 学院名
	 */
	public String getCollegeNameByCollegeId(Integer collegeid);
	
	/**
	 * 根据学院名获得学院id
	 * @param collegeName
	 * @return 学院id
	 */
	public Integer getCollegeIdByCollegeName(String collegeName);
	
	/**
	 * 根据学院名获得学院对象
	 * @param collegeName
	 * @return 学院对象
	 */
	public College getCollegeByCollegeName(String collegeName);
	
	
	/**
	 * 增加学院对象
	 * @param college
	 */
	public void addCollege(College college);
}
