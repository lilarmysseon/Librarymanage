package cn.itcast.Librarymanage.service;

/*
 * ����Ա��Ϣ
 */
public class Admin {
	private String admin_id;//����ԱID
	private String admin_name;//����Ա��
	private String admin_phone;//����Ա�ֻ���
	private String admin_password;//����Ա����
	
	public Admin() {
		super();
	}
	
	public Admin(String admin_name, String admin_password) {
		super();
		this.admin_name = admin_name;
		this.admin_password = admin_password;
	}

	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_phone() {
		return admin_phone;
	}
	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	
}
