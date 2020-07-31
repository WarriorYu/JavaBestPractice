package server;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import server.response.entity.ResponseEntity;
import server.response.entity.UserInfoEntitiy;

    @WebServlet("/LoginServlet")
public class LoginServlet extends BaseJsonServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected ResponseEntity onHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {


        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.code = "0022";
        responseEntity.msg = "用户名或密码错误";

        String userName = req.getParameter("userName");
        if ("Darren".equals(userName)) {
            responseEntity.code = "0000";
            responseEntity.msg = "登录成功	";

            UserInfoEntitiy infoEntitiy = new UserInfoEntitiy();
            infoEntitiy.userName = userName;
            infoEntitiy.userSex = "男";
            responseEntity.data = JSON.toJSONString(infoEntitiy);
			responseEntity.data = "hahah哈哈";

			// 设置登录Cookie 登录有效时间是1天
            Cookie cookie = new Cookie("userName", "Darren");
            cookie.setMaxAge(10); // 设置Cookie的过期时间
            resp.addCookie(cookie);
        }


        return responseEntity;
    }

}
