package cn.yyy.service;

import cn.yyy.pojo.User;

public interface ILoginService {
	public User getUserByUsername(String username);
	
	public User getUserByPhoneNumber(String phone);
}
