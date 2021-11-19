package com.douzone.jblog.vo.dto;

public class CategoryDto {
	private Long no;
	private String name;
	private String desc;
	private String blog_id;
	private int cnt;

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(String blog_id) {
		this.blog_id = blog_id;
	}

	@Override
	public String toString() {
		return "CategoryDto [no=" + no + ", name=" + name + ", desc=" + desc + ", blog_id=" + blog_id + ", cnt=" + cnt
				+ "]";
	}

}
