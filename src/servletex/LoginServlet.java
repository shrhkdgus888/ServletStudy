package servletex;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServlet을 상속해서, 내부에 필요한 메서드들을 재정의함.
	//기존에는 브라우저에서 jsp파일의 처리에 대한 결과를 요청했던건데, 자바코드를 요청해야된다는 상황 
	//근데 자바코드를 요청하는건 말이안됌, 즉 매게체가 필요하다는말→ web.xml파일 ㄱㄱ 내가만든 서블릿을 등록!
public class LoginServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("로그인 서블릿 초기화");
	
	}
	
	@Override
	public void destroy() {
		System.out.println("로그인 서블릿 소멸");
	}
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("로그인 서비스!");
//	}
	//요청메서드
		//- get요청(주소창으로 서버에 요청하는것)을 어떻게 처리할 것인가?
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* jsp에 응답할 브라우저를 만들어서 내부에서 포워딩을 함. */
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		
		if(userid.equals(userpw)){
			resp.sendRedirect("/main.jsp");
			System.out.println("로그인 성공!");
		}else{
			resp.sendRedirect("/login.jsp");
			System.out.println("로그인 실패!");
		}
	}
}
