package cn.itcast.Librarymanage.domain;

/*
 * ͼ��������ģ��
 */
public class BookItem {
	//����
	private String numbering;//���
	private String bookname;  //����
	private int number; //����
	private String price;  //�۸�
//	private String book_status; //״̬
	//���췽��
	public BookItem() {
		super();
	} 
	
	public BookItem(int number) {
		super();
		this.number = number;
	} 
	
	public BookItem(String numbering, String bookname, int number, String price) {
		super();
		this.numbering = numbering; //���
		this.bookname = bookname; //����
		this.number = number; //����
		this.price = price; //�۸�
//		this.book_status =book_status; //״̬
	}
	//get/set����
	public String getNumbering() {
		return numbering;
	}
	public void setNumbering(String numbering) {
		this.numbering = numbering;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
/*
	public String getBook_status() {
		return book_status;
	}
	public void setBook_status(String book_status) {
		this.book_status = book_status;
	}
*/
}