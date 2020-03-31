package com.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.GoodsDAO;
import com.bit.vo.GoodsVO;

/**
 * Servlet implementation class detailGoodsServlet
 */
@WebServlet("/detailGoods.do")
public class detailGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detailGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		GoodsDAO dao = new GoodsDAO();
		GoodsVO g = dao.getGoods(no);
		response.setContentType("text/html;charset=utf-8");
		String str="";
		str += "��ǰ��ȣ : ";
		str += g.getNo() + "<br>";
		str += "��ǰ�� : ";
		str += g.getItem()+ "<br>";
		str += "���� : ";
		str += g.getPrice() + "<br>";
		str += "���� : ";
		str += g.getQty()+ "<br>";
	
		str += "<img src='upload/"+g.getFname()+"'width='200' height='200'><br>";
				
		str += "�󼼼��� :<br> ";
		str += "<textarea readonly rows='10' colos='80'>"+g.getDetail()+"</textarea><br>";
		
		str += "<a href='updateGoods.do?no="+g.getNo()+"'>����</a>";
        str += "<a href='deleteGoods.do?no="+g.getNo()+"'>����</a>";
             
        PrintWriter out = response.getWriter();
         
        out.print(str);
        out.close();
         
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}