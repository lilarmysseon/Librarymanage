package cn.itcast.Librarymanage.service;

public class User {
	private String user_id;//读者ID
	private String user_name;//读者名
	private String user_phone;//读者手机号
	private String user_password;//读者密码
	
	public User() {
		super();
	}
	
	public User(String user_id, String user_name, String user_phone, String user_password) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_password = user_password;
	}
	
	public User(String user_name, String user_password) {
		super();
		this.user_name = user_name;
		this.user_password = user_password;
	}

	public String getuser_id() {
		return user_id;
	}
	public void setuser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getuser_name() {
		return user_name;
	}
	public void setuser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getuser_phone() {
		return user_phone;
	}
	public void setuser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getuser_password() {
		return user_password;
	}
	public void setuser_password(String user_password) {
		this.user_password = user_password;
	}

}


