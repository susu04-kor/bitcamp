package com.bit.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.MemberDAO;
import com.bit.vo.MemberVO;

/**
 * Servlet implementation class insertMemberServlet
 */
@WebServlet("/insertMember.do")
public class insertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");	//�ѱۼ���

		PrintWriter out = response.getWriter();
		String str ="<html>";
		str +="<form method='post' action='insertMember.do'>";
		
		str += "���̵� : ";
		str += "<input type='text' name='id'><br><br>";
		
		str += "��й�ȣ: ";
		str += "<input type='password' name='pwd'><br><br>";
		
		str += "�̸�: ";
		str += "<input type='text' name='name'><br><br>";
			
		str += "����ó: ";
		str += "<input type='tel' name='tel' "
				+ "pattern='[0-9]{3}-[0-9]{4}-[0-9]{4}' placeholder='010-1234-5678'><br><br>";
		
		str += "����: ";
		str += "<input type='date' name='birth'><br><br>";
		
		str += "�̸���: ";
		str += "<input type='email' name='email'><br><br>";
		
		str += "����: ";
		str += "<input type='radio' name='gender' value='����'> ����  "
			   + "<input type='radio' name='gender' value='����'>���� <br><br>";

		str += "������: ";
		str += "<input type='radio' name='blood' value='a'> a��  "
				+ " <input type='radio' name='blood' value='b'> b�� "
				+ " <input type='radio' name='blood' value='o'> o�� " 
				+ " <input type='radio' name='blood' value='ab'> ab��<br><br> " ;
				
		str += "���: ";
		str += "<input type='checkbox' name='hobby' value='����'>����"
				+ "<input type='checkbox' name='hobby' value='��ȭ'>��ȭ"
				+ "<input type='checkbox' name='hobby' value='���ǰ���'>���ǰ���"
				+ "<input type='checkbox' name='hobby' value='����'>����"
				+ "<input type='checkbox' name='hobby' value='�'>�<br><br>";
		
		str += "URL: ";
		str += "<input type='url' name='url'><br><br>";
		
		str += "����:<br> ";
		str += "<select name = 'job' size='0'>" 
				+ "<option value='�ڿ���'>�ڿ���</option>"
				+ "<option value='ȸ���'>ȸ���</option>"
				+ "<option value='�л�'>�л�</option>"
				+ "<option value='�ֺ�'>�ֺ�</option>"
				+ "<option value='��Ÿ'>��Ÿ</option>"
				+ "</select><br><br>";
		
		str += "�Ұ�:<br> ";
		str += "<textarea name='intro' rows='10' cols='60'></textarea><br><br>";
		
		str += "<input type='submit' value='����'>";
		str += "<input type='reset' value='���'>";
		
		str +="</form>";
		str += "</html>";
		out.print(str);
		out.close();
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		MemberVO m = new MemberVO();
		m.setId(request.getParameter("id"));
		m.setPwd(request.getParameter("pwd"));
		m.setName(request.getParameter("name"));
		m.setTel(request.getParameter("tel"));
		m.setBirth(request.getParameter("birth"));
		m.setEmail(request.getParameter("email"));
		m.setGender(request.getParameter("gender"));
		m.setBlood(request.getParameter("blood"));
		m.setHobby(Arrays.toString((request.getParameterValues("hobby"))));
		m.setUrl(request.getParameter("url"));
		m.setJob(request.getParameter("job"));
		m.setIntro(request.getParameter("intro"));
		
		MemberDAO dao = new MemberDAO();
		int re = dao.insertMember(m);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(re > 0) {
			out.println("ȸ�����Կ� �����Ͽ����ϴ�.");
//			response.sendRedirect("");
		}else {
			out.println("ȸ�����Կ� �����Ͽ����ϴ�.");
			out.close();
		}
	}

}