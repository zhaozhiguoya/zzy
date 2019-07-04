package com.crx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.crx.model.User;
import com.crx.utils.DBService;
import com.crx.utils.Pager;

public class UserDAO implements BaseDAO<User>{
	
	public User login(User user){
		Statement stmt = DBService.getStmt();
		String sql = "select * from user where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'";
		List<User> users = new ArrayList<>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				User u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				users.add(u);
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users.size()>0?users.get(0):null;
	}
	@Override
	public void add(User t) {
		// TODO Auto-generated method stub
		String sql = "insert into user values(null,'"+t.getUsername()+"','"+t.getPassword()+"')";
		Statement stmt = DBService.getStmt();
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		String sql = "update user set username='"+t.getUsername()+"',password='"+t.getPassword()+"' where id="+t.getId();
		Statement stmt = DBService.getStmt();
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql="delete from user where id="+id;
		Statement stmt = DBService.getStmt();
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from user where id="+id;
		return findBySQL(sql).get(0);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from user";
		return findBySQL(sql);
	}
	
	public User findByName1(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from user where username='"+username+"'";
		return findBySQL(sql).get(0);
	}
	
	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		String sql="select * from user where username like '%"+name+"%'";
		return findBySQL(sql);
	}

	@Override
	public List<User> findBySQL(String sql) {
		// TODO Auto-generated method stub
		ResultSet rs;
		List<User> users = new ArrayList<>();
		Statement stmt = DBService.getStmt();
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				User u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				users.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	public List<User> findByPage(HttpServletRequest request){
		String url = "UserServlet?flag=findAll";
		int size = 5;
		int rows = findAll().size();
		int cpage = request.getParameter("pager")==null?1:Integer.parseInt(request.getParameter("pager"));
		String pager = Pager.getPagerStr(url, size, rows, cpage, 1);
		request.setAttribute("pager", pager);
		String sql = "select * from user limit "+(cpage-1)*size+","+size+" ";
		return findBySQL(sql);
		
	}

}
