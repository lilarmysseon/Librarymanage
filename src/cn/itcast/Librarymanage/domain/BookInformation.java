package cn.itcast.Librarymanage.domain;



import javax.xml.crypto.Data;

/*
 * ͼ��״̬
 */
public class BookInformation {
	private String numbering;//ͼ��ID
	private String user_name;//�������name
	private Data borrow_data;//����ʱ��
    private Data return_data;//����ʱ��
    private String book_status;//ͼ��״̬
  
  /*  
	public BookInformation(String numbering) {
		super();
		this.numbering = numbering;
	}
*/
	public BookInformation(String numbering, String user_name) {
		super();
		this.numbering = numbering;
		this.user_name = user_name;
	}

	public BookInformation(String numbering, String user_name,   String book_status) {
		super();
		this.numbering = numbering;
		this.user_name = user_name;
		this.book_status = book_status;
	}
	
	public BookInformation() {
		super();
	}

	public String getNumbering() {
		return numbering;
	}

	public void setNumbering(String numbering) {
		this.numbering = numbering;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String getBook_status() {
		return book_status;
	}

	public void setBook_status(String book_status) {
		this.book_status = book_status;
	}
//���黹��ʱ��
	public Data getBorrow_data() {
		return borrow_data;
	}

	public void setBorrow_data(Data borrow_data) {
		this.borrow_data = borrow_data;
	}

	public Data getReturn_data() {
		return return_data;
	}

	public void setReturn_data(Data return_data) {
		this.return_data = return_data;
	}
	
	
}
