package com.crx.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crx.dao.UserDAO;
import com.crx.model.User;
import com.google.gson.Gson;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO udao = new UserDAO(); 
    
    public UserServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		switch (flag) {
		case "login":
			login(request,response);
			break;
		case "findAll":
			findAll(request,response);
			break;
		case "add":
			add(request,response);
			break;
		case "deleteOne":
			deleteOne(request,response);
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
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		List<User> user = udao.findByName(username);
		request.setAttribute("userlist", user);
		request.getRequestDispatcher("user_list.jsp").forward(request, response);
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = (User) request.getSession().getAttribute("updateUser");
		user.setUsername(username);
		user.setPassword(password);
		udao.update(user);
		findAll(request, response);
	}


	private void yupdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		User user = udao.findById(Integer.parseInt(id));
		request.getSession().setAttribute("updateUser", user);
		Gson gson = new Gson();
	    String json = gson.toJson(user);
	    response.getWriter().print(json);
	}


	private void deleteOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		udao.delete(Integer.parseInt(id));
		findAll(request, response);
	}


	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username,password);
		udao.add(user);
		findAll(request, response);
	}


	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> user = udao.findByPage(request);
		request.getSession().setAttribute("userlist", user);
		request.getRequestDispatcher("user_list.jsp").forward(request, response);
	}


	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username =request.getParameter("username");
	    String password =request.getParameter("password");
	    User user = new User(username,password);
	    
	    User u = udao.login(user);
	    if(u==null){
	    	request.setAttribute("mess", "对不起用户不存在或密码错误");
	    	request.getRequestDispatcher("index.jsp").forward(request, response);
	    }else{
	    	request.getSession().setAttribute("user", u);
	    	request.getRequestDispatcher("main.jsp").forward(request, response);
	    }
	 }

}
