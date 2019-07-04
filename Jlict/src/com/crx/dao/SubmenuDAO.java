package com.crx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.crx.model.Menu;
import com.crx.model.Submenu;
import com.crx.utils.DBService;
import com.crx.utils.Pager;

public class SubmenuDAO implements BaseDAO<Submenu>{
	@Override
	public void add(Submenu t) {
		String sql;
		if(t.getType()==3){
			sql = "insert into submenu values(null,'"+t.getTitle()+"',"+t.getType()+","+t.getMid()+",'"+t.getTime()+"',"+t.getUid()+",null)";
		}else{
			sql = "insert into submenu values(null,'"+t.getTitle()+"',"+t.getType()+","+t.getMid()+",'"+t.getTime()+"',"+t.getUid()+",'"+t.getContent()+"')";
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
	public void update(Submenu t) {
		String sql;
		//System.out.println(t.getId());
		if(t.getType()==4){
			sql = "update submenu set title='"+t.getTitle()+"',type="+t.getType()+",mid="+t.getMid()+",time='"+t.getTime()+"',uid="+t.getUid()+",content='"+t.getContent()+"' where id="+t.getId();
		}else{
			sql = "update submenu set title='"+t.getTitle()+"',type="+t.getType()+",mid="+t.getMid()+",time='"+t.getTime()+"',uid="+t.getUid()+" where id="+t.getId();
		}
		//System.out.println(sql);
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
		String sql="delete from submenu where id="+id;
		Statement stmt = DBService.getStmt();
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Submenu findById(int id) {
		String sql = "select * from submenu where id="+id;
		return findBySQL(sql).get(0);
	}

	@Override
	public List<Submenu> findAll() {
		String sql = "select * from submenu";
		return findBySQL(sql);
	}

	@Override
	public List<Submenu> findByName(String title) {
		String sql = "select * from submenu where title like '%"+title+"%'";
		return findBySQL(sql);
	}

	@Override
	public List<Submenu> findBySQL(String sql) {
		ResultSet rs;
		List<Submenu> submenus = new ArrayList<>();
		Statement stmt = DBService.getStmt();
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Submenu m = new Submenu();
				m.setId(rs.getInt(1));
				m.setTitle(rs.getString(2));
				m.setType(rs.getInt(3));
				m.setMid(rs.getInt(4));
				m.setTime(rs.getString(5));
				m.setUid(rs.getInt(6));
				m.setContent(rs.getString(7));
				submenus.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return submenus;
	}

	public List<Submenu> findByPage(HttpServletRequest request) {
		String url = "SubmenuServlet?flag=findAll";
		int size = 5;
		int rows = findAll().size();
		int cpage = request.getParameter("pager")==null?1:Integer.parseInt(request.getParameter("pager"));
		String pager = Pager.getPagerStr(url, size, rows, cpage, 1);
		request.setAttribute("pager", pager);
		String sql = "select * from submenu limit "+(cpage-1)*size+","+size+" ";
		return findBySQL(sql);
	}

	public List<Submenu> findThreemenu() {
		String sql = "select * from submenu where content is null";
		return findBySQL(sql);
	}

	public List<Submenu> findByMid(int id) {
		String sql = "select * from submenu where mid="+id;
		return findBySQL(sql);
	}

}
