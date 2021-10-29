package com.douzone.jblog.vo;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/* Feild 위에 @ 들은
   UserController join Method의 BindingResult result에서 사용되는데
   조건이 맞지 않으면 result.hasErrors()가 true가 나오게 된다
 */
public class UserVo {
	// private Long no;

	@NotEmpty
	@Length(min = 2, max = 16)
	private String id;

	@NotEmpty
	@Length(min = 2, max = 8)
	private String name;

	@NotEmpty
	@Length(min = 2, max = 16)
	private String password;

	// 보류
	private String joinDate;

	private String role;

	/*
	 * public Long getNo() { return no; }
	 * 
	 * public void setNo(Long no) { this.no = no; }
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserVo [id=" + id + ", name=" + name + ", password=" + password + ", joinDate=" + joinDate + ", role="
				+ role + "]";
	}

}
