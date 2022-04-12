package cn.itcast.Librarymanage.domain;

/*
 * 图书项数据模型
 */
public class BookItem {
	//属性
	private String numbering;//编号
	private String bookname;  //名称
	private int number; //数量
	private String price;  //价格
//	private String book_status; //状态
	//构造方法
	public BookItem() {
		super();
	} 
	
	public BookItem(int number) {
		super();
		this.number = number;
	} 
	
	public BookItem(String numbering, String bookname, int number, String price) {
		super();
		this.numbering = numbering; //编号
		this.bookname = bookname; //名称
		this.number = number; //数量
		this.price = price; //价格
//		this.book_status =book_status; //状态
	}
	//get/set方法
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