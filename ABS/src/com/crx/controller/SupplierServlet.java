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

import com.crx.dao.SupCheckDAO;
import com.crx.dao.SupplierDAO;
import com.crx.model.SupCheck;
import com.crx.model.Supplier;
import com.google.gson.Gson;

import net.sf.json.JSONObject;
@WebServlet("/SupplierServlet")
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SupplierDAO sdao = new SupplierDAO();
	private SupCheckDAO scdao = new SupCheckDAO();
	private String isCheck="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String flag=request.getParameter("flag");
	   isCheck=request.getParameter("isCheck");
	   request.setAttribute("isCheck", isCheck);//��Ӧ�̿��ˣ�true  ѡ��false
	   switch (flag) {
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
	      case "deledeSome":
	    	  deledeSome(request,response);
			  break; 
	      case "findByName":
	    	  findByName(request,response);
			  break; 
	      case "ycheck":
	    	  ycheck(request,response);
			  break; 
	      case "supcheck":
	    	  supcheck(request,response);
			  break;
	      case "see":
	    	  see(request,response);
			  break; 
	      case "checkName":
	    	  checkName(request,response);
			  break; 
	default:
		break;
	}
	   
	  
	}

	private void checkName(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name =request.getParameter("name");
		List<Supplier> sups = sdao.findByFullName(name);
		String res ="";
		if(sups.size()>0){
			res="�����ظ����";
		}
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void see(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		Supplier sup=null;
		String str="";
	
		if(Integer.parseInt(id)==0){
			str="nodata";
		}else{
			sup=sdao.findById(Integer.parseInt(id));
		}
		try {
		if(sup==null){
			str="nodata";	
			response.getWriter().print(str);
		}else{
			response.getWriter().print(new Gson().toJson(sup));
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void supcheck(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Supplier sup = sdao.findById(Integer.parseInt(request.getParameter("id")));
		String price=request.getParameter("price");
		String sample=request.getParameter("sample");
		String sat=request.getParameter("sat");
		String delivery=request.getParameter("delivery");
		String f_data=request.getParameter("f_data");
		String quality=request.getParameter("quality");
		String wdate =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        int id = Integer.parseInt(request.getParameter("id"));//((SupCheck)request.getSession().getAttribute("ysc")).getId();
        SupCheck sc = new SupCheck(id,sup,price,sample,sat,delivery,f_data,quality,wdate,"");
        
        
        String status ="";
		//�ж����״̬
		if(price.equals("����")&&sample.equals("�ϸ�")&&delivery.equals("δ����")&&f_data.equals("��ȫ")&&quality.equals("���")&&(Integer.parseInt(sat)>=90)){
			status="�����ͨ��";
		}else{
			status="���δͨ��";
		}
		
		
       //����֮ǰ �жϹ�Ӧ��״̬�Ƿ�Ϊ�Ѿ������ 
        if(sup.getStatus().equals("δ���")){
        	scdao.insert(sc);//������˱�
        }else{
        	scdao.update(sc);
        }
        sup.setStatus(status);
		sdao.updateCheckSup(sup);//���Ĺ�Ӧ�̱�����״̬
		isCheck="true";
		//request.setAttribute("ischeck", "true");//���õ������֮����תҳ�滹�����
		findAll(request, response);
	}

	private void ycheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Supplier sup =sdao.findById(Integer.parseInt(id));
		request.setAttribute("upSup", sup);
		if(!sup.getStatus().equals("δ���")){
		SupCheck sc =scdao.findBySId(Integer.parseInt(id));
		request.setAttribute("upSupCheck", sc);
		}
//		if(sup.getStatus().equals("δ���"))
		   request.setAttribute("opa", "check");
		
		findAll(request, response);
		//Supplier sup = sdao.findById(Integer.parseInt(id));//��ѯ��Ӧ�� ���Ƿ���˹�
		
		
		/*JSONObject json=new JSONObject();
		if(!sup.getStatus().equals("δ���")){
			//����Ѿ���� ����˱�  
			SupCheck sc =scdao.findBySId(Integer.parseInt(id));
			json.put("msg", "ysh");
			JSONObject json1=JSONObject.fromObject(sc);
			json.put("obj", json1);
			
		}else{
			json.put("msg", sup.getName());
		}
		response.getWriter().print(json.toString());*/
		
	}

	private void findByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("name");
		request.setAttribute("suplist", sdao.findByName(username));
		request.getRequestDispatcher("supplier_list.jsp").forward(request, response);
	}

	private void deledeSome(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		 String ids = request.getParameter("ids");
		 if(ids!=null&&!ids.equals("")){
			  ids=ids.substring(0,ids.length()-1);
			  sdao.deleteSome(ids);
		 }
		 findAll(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	
		Supplier upsup = sdao.findById(Integer.parseInt(request.getParameter("id")));
		upsup.setAddress(request.getParameter("address"));
		upsup.setTel(request.getParameter("tel"));
		upsup.setEmail(request.getParameter("email"));
		upsup.setFax(request.getParameter("fax"));
		upsup.setLinkman(request.getParameter("linkman"));
		upsup.setLinkman_tel(request.getParameter("linkman_tel"));
	    sdao.update(upsup);
	    findAll(request, response);
	}

	private void yupdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Supplier updateSup = sdao.findById(Integer.parseInt(id));
		request.setAttribute("updateSup", updateSup);
		if(updateSup.getStatus().equals("δ���"))
		request.setAttribute("opa", "edit");
		findAll(request, response);
	}

	private void deleteOne(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		  String id = request.getParameter("id");
		  sdao.delete(Integer.parseInt(id));
		  findAll(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//isCheck=request.getParameter("isCheck");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String tel=request.getParameter("tel");
		String email=request.getParameter("email");
		String fax=request.getParameter("fax");
		String linkman=request.getParameter("linkman");
		String link_tel=request.getParameter("linkman_tel");
		
		Supplier sup = new Supplier(0,name,address,tel,email,fax,linkman,link_tel,"δ���","");
		sdao.insert(sup);
		findAll(request, response);
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		  List<Supplier> sups = sdao.findAll();
		  request.setAttribute("suplist", sups);
		 
			try {
				request.getRequestDispatcher("supplier_list.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

}
}