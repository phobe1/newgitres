package cn.bdqn.entity;

import java.util.Date;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private Date birthday;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public Users(String username, String password, Date birthday) {
		this.username = username;
		this.password = password;
		this.birthday = birthday;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password="
				+ password + ", birthday=" + birthday + "]";
	}
	
	

}