package cn.bdqn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.bdqn.dao.UsersDao;
import cn.bdqn.dao.UsersDaoImpl;
import cn.bdqn.entity.Users;

@Service("userService")
@Transactional
public class UserServiceImpl implements UsersService{

	@Autowired
	private UsersDao ud;
	public UsersDao getUd() {
		return ud;
	}
	public void setUd(UsersDao ud) {
		this.ud = ud;
	}


	@Override
//	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Users login(Users u) {
		System.out.println(u);
		return ud.login(u);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int addUser(Users u) {
		return ud.addUser(u);
	}
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Users> queryList() {
		return ud.queryList();
	}
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public int queryZYS() {
		int zt = ud.queryCount();
		System.out.println(zt);
		//Ã¿Ò³3Ìõ
		//  8/3.0
		return (int) Math.ceil(zt/3.0);
	}
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Users> queryList(int ym) {
		return ud.queryList(ym);
	}

}
