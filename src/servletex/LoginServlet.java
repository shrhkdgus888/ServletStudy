package servletex;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServlet�� ����ؼ�, ���ο� �ʿ��� �޼������ ��������.
	//�������� ���������� jsp������ ó���� ���� ����� ��û�ߴ��ǵ�, �ڹ��ڵ带 ��û�ؾߵȴٴ� ��Ȳ 
	//�ٵ� �ڹ��ڵ带 ��û�ϴ°� ���̾ȉ�, �� �Ű�ü�� �ʿ��ϴٴ¸��� web.xml���� ���� �������� ������ ���!
public class LoginServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("�α��� ���� �ʱ�ȭ");
	
	}
	
	@Override
	public void destroy() {
		System.out.println("�α��� ���� �Ҹ�");
	}
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("�α��� ����!");
//	}
	//��û�޼���
		//- get��û(�ּ�â���� ������ ��û�ϴ°�)�� ��� ó���� ���ΰ�?
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* jsp�� ������ �������� ���� ���ο��� �������� ��. */
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		
		if(userid.equals(userpw)){
			resp.sendRedirect("/main.jsp");
			System.out.println("�α��� ����!");
		}else{
			resp.sendRedirect("/login.jsp");
			System.out.println("�α��� ����!");
		}
	}
}
