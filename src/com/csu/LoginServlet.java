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
		//����piccode
		String piccode = (String)request.getSession().getAttribute("piccode");
		//����checkcode
		String checkcode = request.getParameter("checkcode");
		checkcode = checkcode.toUpperCase();
		response.setContentType("text/html;charset=UTF-8");
		//����һ���ı������PrintWriter�� getWriter������һ�����Է����ַ��ı����ͻ��˵�PrintWriter����
		PrintWriter out = response.getWriter();
		if(checkcode.equals(piccode)){//�ж��������֤���Ƿ���ȷ
			out.println("��֤��������ȷ");
			
		}else{
			out.println("��֤���������");
		}
		out.flush();
		out.close();
	}


}
