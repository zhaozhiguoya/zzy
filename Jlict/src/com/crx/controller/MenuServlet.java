package com.crx.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crx.dao.MenuDAO;
import com.crx.model.Menu;
import com.crx.model.User;
import com.google.gson.Gson;


@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuDAO mdao = new MenuDAO();
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
		case "findOnemenu":
			findOnemenu(request,response);
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
		List<Menu> menu = mdao.findByName(title);
		request.setAttribute("menu", menu);
		request.getRequestDispatcher("menu_list.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		System.out.println(title);
		String v = request.getParameter("select");
		//System.out.println(v);
		int value = Integer.parseInt(v);
		int id = Integer.parseInt(request.getParameter("id"));
		int type;
		if(value==0){
			type = 1;
			Menu menu = new Menu(id,title,type);
			mdao.update(menu);
		}else{
		    type = 2;
			int mid = value;
			Menu menu = new Menu(id,title,type,mid);
			mdao.update(menu);
		}
		findAll(request, response);
	}

	private void yupdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Menu> menu = mdao.findOnemenu();
		request.setAttribute("menu", menu);
		String id=request.getParameter("id");
		Menu smenu = mdao.findById(Integer.parseInt(id));
		request.setAttribute("smenu", smenu);
		request.getRequestDispatcher("menu_update.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		mdao.delete(Integer.parseInt(id));
		findAll(request, response);
	}

	private void findOnemenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Menu> menu = mdao.findOnemenu();
		request.setAttribute("menu", menu);
		request.getRequestDispatcher("menu_add.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String v = request.getParameter("select");
		int value = Integer.parseInt(v);
		int type;
		if(value==0){
			type = 1;
			Menu menu = new Menu(title,type);
			mdao.add(menu);
		}else{
		    type = 2;
			int mid = value;
			Menu menu = new Menu(title,type,mid);
			mdao.add(menu);
		}
		findAll(request, response);
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Menu> menu = mdao.findByPage(request);
		request.setAttribute("menu", menu);
		request.getRequestDispatcher("menu_list.jsp").forward(request, response);
	}

}
