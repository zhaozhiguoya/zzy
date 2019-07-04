package com.crx.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crx.dao.MenuDAO;
import com.crx.dao.SubmenuDAO;
import com.crx.model.Menu;
import com.crx.model.Submenu;


@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MenuDAO mdao = new MenuDAO();
    private SubmenuDAO sdao = new SubmenuDAO();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		switch (flag) {
		case "findIndex":
			findIndex(request,response);
			break;
		case "findFirst":
			findFirst(request,response);
			break;
		default:
			break;
		}
	}

	private void findFirst(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		List<Menu> m = mdao.findByMid(Integer.parseInt(id));
		List<Submenu> smenu=new ArrayList<>();
		for(int i=0;i<m.size();i++){
			List<Submenu> submenu = sdao.findByMid(m.get(i).getId());
			smenu.addAll(submenu);
		}
		List<Menu> navs = mdao.findOnemenu();
		List<Menu> menu = mdao.findTwomenu();
		request.getSession().setAttribute("navs", navs);
		request.getSession().setAttribute("menu", menu);
		request.setAttribute("submenu", smenu);
		request.getRequestDispatcher("first.jsp").forward(request, response);
	}

	private void findIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Menu> navs = mdao.findOnemenu();
		List<Menu> menu = mdao.findTwomenu();
		request.getSession().setAttribute("navs", navs);
		request.getSession().setAttribute("menu", menu);
		
		
		request.getRequestDispatcher("mainpage.jsp").forward(request, response);
		
	}

}
