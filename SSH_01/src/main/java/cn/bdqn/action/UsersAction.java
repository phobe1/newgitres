package cn.bdqn.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.bdqn.entity.Users;
import cn.bdqn.service.UserServiceImpl;
import cn.bdqn.service.UsersService;

import com.opensymphony.xwork2.ActionSupport;

@Controller("usersAction")
public class UsersAction extends ActionSupport{
	private Users user;
	@Autowired
	private UsersService userService;
	private Users addUser;
	private int zys;
	private int ym=1;
	private List<Users> list=new ArrayList<Users>();
	
	public int getYm() {
		return ym;
	}

	public void setYm(int ym) {
		this.ym = ym;
	}

	public int getZys() {
		return zys;
	}

	public void setZys(int zys) {
		this.zys = zys;
	}

	public List<Users> getList() {
		return list;
	}

	public void setList(List<Users> list) {
		this.list = list;
	}

	public Users getAddUser() {
		return addUser;
	}

	public void setAddUser(Users addUser) {
		this.addUser = addUser;
	}

	public UsersService getUserService() {
		return userService;
	}

	public void setUserService(UsersService userService) {
		this.userService = userService;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	public String login(){
		Users u = userService.login(user);
		if(u!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String addUsers(){
		System.out.println(121212);
		System.out.println(addUser);
		int i = userService.addUser(addUser);
		System.out.println("---->i:"+i);
		if(i!=0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	public String queryList(){
		list = userService.queryList(this.getYm());
		zys = userService.queryZYS();
		System.out.println("zys:"+zys);
		return SUCCESS;
	}
	
	
}
