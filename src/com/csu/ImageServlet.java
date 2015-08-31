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

public class ImageServlet extends HttpServlet{//继承HttpServlet
	
	//实现父类方法
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//定义一个图片缓存BufferedImage用以暂存图片，设置高、宽
		BufferedImage  bi = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		//从图片缓存中得到一个图g
		Graphics g = bi.getGraphics();
		//定义一个颜色c
		Color c = new Color(200,150,255);
		//将g的颜色设为c
		g.setColor(c);
		//将图g填充进指定的矩形。fillRect
		g.fillRect(0, 0, 68, 22);
		//将所有字母和输入存入一个字符数组。toCharArray：Converts this string to a new character array
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		//从字符数组中随机获取四个字符
		//首先生成随机数
		Random r = new Random();
		int len = ch.length,index;//获取字符数组的长度
		StringBuffer sb = new StringBuffer();//定义一个StringBuffer来缓存字符
		for (int i = 0; i < 4; i++) {//循环4次随机获取四个字符
			index = r.nextInt(len);//nexyInt(n) 返回一个大于0小于n的随机整数，即ch中随机的下标
			g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));//给g一个随机的颜色
			g.drawString(ch[index]+"", (i*15)+3, 18);//将字符画入g中
			sb.append(ch[index]);//将字符组合起来存入sb
		}
		request.getSession().setAttribute("piccode", sb.toString());//将sb转换成字符串，存入session
		ImageIO.write(bi, "JPG", response.getOutputStream());//将bi以jpg格式写出
				 
	}
	
}
