package jdbcexample;

import java.sql.*;

public class DBIntractions implements DBInterface {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;

	public Connection getConnection() {
		String sql = "jdbc:mysql://localhost:3306/db";
		String username = "root";
		String password = "mysql123";
		try {
			conn = DriverManager.getConnection(sql, username, password);
		} catch (SQLException s) {
			System.out.println(s.getMessage());
		}
		return conn;
	}

	public void releaseResources() {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}

	}

	public void createMember(Profile p) {
		conn = getConnection();
		String insert = "insert into tab(name,addr,id) values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getAddress());
			pstmt.setInt(3, p.getId());
			pstmt.executeUpdate();
			System.out.println("Member Successfully Inserted!!");
		} catch (SQLException s) {
			System.out.println(s.getMessage());
		}

	}

	public void display() {
		conn = getConnection();
		String data = "select * from tab";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(data);
			System.out.println("----------------------");
			while (rs.next()) {
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				int id = rs.getInt("id");
				System.out.println("Name is " + name);
				System.out.println("ID is " + id);
				System.out.println("Address is " + addr);
				System.out.println("----------------");
			}

		} catch (SQLException ss) {
			System.out.println(ss.getMessage());
		}
	}

	public void update(Profile p) {
		conn = getConnection();
		String update = "update tab set name = ?,addr = ?,id=? where id = ?  ";
		try {
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getAddress());
			pstmt.setInt(3, p.getId());
			pstmt.setInt(4, p.getUid());
			int status = pstmt.executeUpdate();
			if (status != 0) {
				System.out.println("Member Successfully updated!!");
			}
			display();
		} catch (SQLException s) {
			System.out.println(s.getMessage());
		}

	}

	public void delete(Profile p) {
		conn = getConnection();
		String delete = "delete from tab where id = ?";
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, p.getId());
			int status = pstmt.executeUpdate();
			if (status != 0) {
				System.out.println("Member Successfully deleted!!");
			}
			display();
		} catch (SQLException s) {
			System.out.println(s.getMessage());
		}

	}

	public void search(Profile p3) {
		conn = getConnection();
		boolean flag = true;
		String search = "select * from tab where id=?";
		try {
			pstmt = conn.prepareStatement(search);
			pstmt.setInt(1, p3.getId());
			rs = pstmt.executeQuery();
			System.out.println("----------------------");
			while (rs.next()) {
				flag = false;
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				int id = rs.getInt("id");
				System.out.println("Name is " + name);
				System.out.println("ID is " + id);
				System.out.println("Address is " + addr);
				System.out.println("----------------");
			}

		} catch (SQLException ss) {
			System.out.println(ss.getMessage());
		}
		if (flag) {
			System.out.println("Search unsucessful.....\n");
		}

	}

}
