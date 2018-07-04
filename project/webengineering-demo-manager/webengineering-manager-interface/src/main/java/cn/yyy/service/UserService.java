package cn.yyy.service;

import cn.yyy.pojo.User;

public interface UserService {
	public User getUserInfoByUid(Integer userid);
	
	/**
	 * 根据用户名获取user对象
	 * @param username
	 * @return 如果用户名存在则返回用户对象，如果用户名不存在返回null
	 */
	public User getUserByUsername(String username);
	
	public User getUserByPhoneNumber(String phone);
	
	public String getIdentity(User user);
	
	public void addUser(User user);
}
