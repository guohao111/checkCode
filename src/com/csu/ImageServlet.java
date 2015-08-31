package com.csu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet{//�̳�HttpServlet
	
	//ʵ�ָ��෽��
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//����һ��ͼƬ����BufferedImage�����ݴ�ͼƬ�����øߡ���
		BufferedImage  bi = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		//��ͼƬ�����еõ�һ��ͼg
		Graphics g = bi.getGraphics();
		//����һ����ɫc
		Color c = new Color(200,150,255);
		//��g����ɫ��Ϊc
		g.setColor(c);
		//��ͼg����ָ���ľ��Ρ�fillRect
		g.fillRect(0, 0, 68, 22);
		//��������ĸ���������һ���ַ����顣toCharArray��Converts this string to a new character array
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		//���ַ������������ȡ�ĸ��ַ�
		//�������������
		Random r = new Random();
		int len = ch.length,index;//��ȡ�ַ�����ĳ���
		StringBuffer sb = new StringBuffer();//����һ��StringBuffer�������ַ�
		for (int i = 0; i < 4; i++) {//ѭ��4�������ȡ�ĸ��ַ�
			index = r.nextInt(len);//nexyInt(n) ����һ������0С��n�������������ch��������±�
			g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));//��gһ���������ɫ
			g.drawString(ch[index]+"", (i*15)+3, 18);//���ַ�����g��
			sb.append(ch[index]);//���ַ������������sb
		}
		request.getSession().setAttribute("piccode", sb.toString());//��sbת�����ַ���������session
		ImageIO.write(bi, "JPG", response.getOutputStream());//��bi��jpg��ʽд��
				 
	}
	
}
