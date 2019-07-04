package com.crx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.crx.model.Menu;
import com.crx.utils.DBService;
import com.crx.utils.Pager;

public class MenuDAO implements BaseDAO<Menu>{

	@Override
	public void add(Menu t) {
		String sql;
		if(t.getType()==1){
		sql = "insert into menu values(null,'"+t.getTitle()+"',"+t.getType()+",null)";
		}else{
		sql = "insert into menu values(null,'"+t.getTitle()+"',"+t.getType()+","+t.getMid()+")";
		}
		Statement stmt = DBService.getStmt();
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Menu t) {
		String sql;
		//System.out.println(t.getId());
		if(t.getType()==1){
			sql = "update menu set title='"+t.getTitle()+"',type="+t.getType()+" where id="+t.getId();
		}else{
			sql = "update menu set title='"+t.getTitle()+"',type="+t.getType()+",mid="+t.getMid()+" where id="+t.getId();
		}
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
		String sql="delete from menu where id="+id;
		Statement stmt = DBService.getStmt();
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Menu findById(int mid) {
		String sql = "select * from menu where id="+mid;
		return findBySQL(sql).get(0);
	}

	@Override
	public List<Menu> findAll() {
		String sql = "select * from menu";
		return findBySQL(sql);
	}

	@Override
	public List<Menu> findByName(String title) {
		String sql = "select * from menu where title like '%"+title+"%'";
		return findBySQL(sql);
	}

	@Override
	public List<Menu> findBySQL(String sql) {
		ResultSet rs;
		List<Menu> menus = new ArrayList<>();
		Statement stmt = DBService.getStmt();
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Menu m = new Menu();
				m.setId(rs.getInt(1));
				m.setTitle(rs.getString(2));
				m.setType(rs.getInt(3));
				m.setMid(rs.getInt(4));
				menus.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menus;
	}
	public List<Menu> findByPage(HttpServletRequest request){
		String url = "MenuServlet?flag=findAll";
		int size = 5;
		int rows = findAll().size();
		int cpage = request.getParameter("pager")==null?1:Integer.parseInt(request.getParameter("pager"));
		String pager = Pager.getPagerStr(url, size, rows, cpage, 1);
		request.setAttribute("pager", pager);
		String sql = "select * from menu limit "+(cpage-1)*size+","+size+" ";
		return findBySQL(sql);
	}

	public List<Menu> findOnemenu() {
		String sql = "select * from menu where mid is null";
		return findBySQL(sql);
	}
	public List<Menu> findTwomenu() {
		String sql = "select * from menu where mid is not null";
		return findBySQL(sql);
	}
	
	public List<Menu> findByMid(int id){
		String sql = "select * from menu where mid="+id;
		return findBySQL(sql);
	}
}
