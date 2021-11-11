package com.sist.vo;
/*
String sql = select bookname from book 
where bookid not in(select bookid from orders 
where custid = (select custid from customer where name = ?));
*/
public class NotInBookNameVo{
	private String bookname;

	public NotInBookNameVo(String bookname) {
		super();
		this.bookname = bookname;
	}

	public NotInBookNameVo() {
		super();
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	 
	
	
}
