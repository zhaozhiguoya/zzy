package com.crx.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crx.dao.MenuDAO;
import com.crx.dao.SubmenuDAO;
import com.crx.dao.UserDAO;
import com.crx.model.Menu;
import com.crx.model.Submenu;
import com.crx.model.User;


@WebServlet("/SubmenuServlet")
public class SubmenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	private UserDAO udao = new UserDAO();
	private MenuDAO mdao = new MenuDAO();
	private SubmenuDAO sdao = new SubmenuDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		switch (flag) {
		case "findAll":
			findAll(request,response);
			break;
		case "add":
			add(request,response);
			break;
		case "findMenu":
			findMenu(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
		case "yupdate":
			yupdate(request,response);
			break;
		case "update":
			update(request,response);
			break;
		case "findByName":
			findByName(request,response);
			break;	
		default:
			break;
		}
	}

	private void findByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		List<Submenu> submenu = sdao.findByName(title);
		request.setAttribute("submenu", submenu);
		request.getRequestDispatcher("submenu_list.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		int mid = Integer.parseInt(request.getParameter("select"));
		String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		String uid = request.getParameter("uid");
		username = udao.findById(Integer.parseInt(uid)).getUsername();
		User user = udao.findByName1(username);
		int id = Integer.parseInt(request.getParameter("id"));
		String content = request.getParameter("content");
		int type;
		if(content==null||content.length()==0){
			Menu menu = mdao.findById(mid);
			type = menu.getType()+1; 
		}else{
			//Submenu smenu = sdao.findById(mid);
			type = 4;
			System.out.println(mid);
		}
		Submenu submenu = new Submenu(id,title,type,mid,time,user.getId(),content);
		sdao.update(submenu);
		findAll(request, response);
	}

	private void yupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Menu> menu1 = mdao.findOnemenu();
		List<Menu> menu2 = mdao.findTwomenu();
		List<Submenu> menu3 = sdao.findThreemenu();
		request.setAttribute("menu1", menu1);
		request.setAttribute("menu2", menu2);
		request.setAttribute("menu3", menu3);
		String id=request.getParameter("id");
		Submenu smenu = sdao.findById(Integer.parseInt(id));
		request.getSession().setAttribute("smenu", smenu);
		request.getRequestDispatcher("submenu_update.jsp").forward(request, response);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		sdao.delete(Integer.parseInt(id));
		findAll(request, response);
	}

	private void findMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<Menu>menu = mdao.findAll();
		//username = request.getParameter("username");
		//request.getSession().setAttribute("username", username);
		List<Menu> menu1 = mdao.findOnemenu();
		List<Menu> menu2 = mdao.findTwomenu();
		List<Submenu> menu3 = sdao.findThreemenu();
		request.setAttribute("menu1", menu1);
		request.setAttribute("menu2", menu2);
		request.setAttribute("menu3", menu3);
		request.getRequestDispatcher("submenu_add.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		int mid = Integer.parseInt(request.getParameter("select"));
		String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		String content = request.getParameter("content");
		int type;
		System.out.println(mid);
		Menu menu = mdao.findById(mid);
		if(content==null||content.length()==0){
			type = menu.getType()+1; 
		}else{
			//Submenu submenu = sdao.findById(mid);
			type = 4;
		}
		//username = request.getParameter("username");
		//System.out.println(username);
		User user = udao.findByName1(username);
		Submenu submenu = new Submenu(title,type,mid,time,user.getId(),content);
		sdao.add(submenu);
		findAll(request, response);
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Submenu> submenu = sdao.findByPage(request);
		username = request.getParameter("username");
		//request.getSession().setAttribute("username", username);
		request.setAttribute("submenu", submenu);
		request.getRequestDispatcher("submenu_list.jsp").forward(request, response);
	}

}
