package server;

import server.response.entity.ResponseEntity;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �û��������۵� Servlet
 * @author hcDarren
 *
 */
@WebServlet("/UserCommentServlet")
public class UserCommentServlet extends BaseJsonServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected ResponseEntity onHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//
		
		ResponseEntity responseEntity = new ResponseEntity();
		responseEntity.code = "0033";
		responseEntity.msg = "����ʧ�ܣ��û�δ��¼";
		
		Cookie[] cookies = req.getCookies();
		if(cookies!=null){
		for(Cookie cookie : cookies){
			String userName = cookie.getName();
			if(userName != null){
				responseEntity.code = "0000";
				responseEntity.msg = "���۳ɹ�";
				return responseEntity;
			}
		}
		}
		
		return responseEntity;
	}

}
