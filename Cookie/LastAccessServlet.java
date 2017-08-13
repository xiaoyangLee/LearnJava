package cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LastAccessServlet
 */
@WebServlet("/LastAccessServlet")
public class LastAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LastAccessServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print("Hello World");
		//��ֹ���������ҳ��
		response.setDateHeader("Expires",0);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		// �趨cookieֵlastAccessTime,���ڼ�¼�û��ϴε�¼��ʱ��
		String lastAccessTime = null;
		// ��ȡ���е�cookie����ֵ���뵽������
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if ("lastAccess".equals(cookies[i].getName())) {
				lastAccessTime = cookies[i].getValue();
				break;
			}
		}
		// �ж��Ƿ��������ΪlastAccess��cookie
		if (lastAccessTime == null) {
			response.getWriter().print("�����״η��ʱ�վ��");
		} else {
			response.getWriter().print("���ϴη��ʵ�ʱ����:" + lastAccessTime);
		}
		//����cookie������ǰ��ʱ����Ϊcookie��ֵ���͵��ͻ���
		String currentTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	
		Cookie cookie  = new Cookie("lastAccess",currentTime);
		//��cookie����Чʱ������Ϊ1Сʱ
		cookie.setMaxAge(60*60);
		//����cookie
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
