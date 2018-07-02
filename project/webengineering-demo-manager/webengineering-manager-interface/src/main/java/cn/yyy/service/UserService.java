package cn.yyy.service;

import cn.yyy.pojo.User;

public interface UserService {
	public User getUserInfoByUid(Integer userid);
	
	public User getUserByUsername(String username);
	
	public User getUserByPhoneNumber(String phone);
	
	public String getIdentity(User user);
	
	public void addUser(User user);
}
