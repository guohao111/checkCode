package com.csu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收piccode
		String piccode = (String)request.getSession().getAttribute("piccode");
		//接收checkcode
		String checkcode = request.getParameter("checkcode");
		checkcode = checkcode.toUpperCase();
		response.setContentType("text/html;charset=UTF-8");
		//定义一个文本输出流PrintWriter。 getWriter：返回一个可以发送字符文本给客户端的PrintWriter对象
		PrintWriter out = response.getWriter();
		if(checkcode.equals(piccode)){//判断输入的验证码是否正确
			out.println("验证码输入正确");
			
		}else{
			out.println("验证码输入错误");
		}
		out.flush();
		out.close();
	}


}
