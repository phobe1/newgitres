package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.Users;

public interface UsersDao {
   
	public Users login(Users u);
	
	public int addUser(Users u);
	
	public List<Users> queryList();
	public List<Users> queryList(int ym);
	
	public int queryCount();
}
