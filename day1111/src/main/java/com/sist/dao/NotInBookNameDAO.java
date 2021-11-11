package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.NotInBookNameVo;

/*
 고객이름을 입력받아서 그 고객이 주문하지 않는 도서명을 출력하기
  String sql = select bookname from book 
  where bookid not in(select bookid from orders 
  where custid = (select custid from customer where name = ?));
 */
public class NotInBookNameDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "c##madang";
	String password = "madang";
	
	
	public ArrayList<NotInBookNameVo> searchBookName(String name){
		ArrayList<NotInBookNameVo>list = new ArrayList<NotInBookNameVo>();
		String sql= "select bookname from book  where bookid not in(select bookid from orders where custid = (select custid from customer where name = ?))";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new NotInBookNameVo(rs.getString(1)));
						}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}
		
		
		return list;
	}
}