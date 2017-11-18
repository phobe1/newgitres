package cn.bdqn.service;

import java.util.List;

import cn.bdqn.entity.Users;

public interface UsersService {
	public Users login(Users u);
	public int addUser(Users u);
	public List<Users> queryList();
	public List<Users> queryList(int ym);
	public int queryZYS();
}
