package server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import server.response.entity.ResponseEntity;
/**
 * Author   :   ${USER}
 * Create   :   ${DATE}
 * Describe :  了解cookie 请求头等
 */
public abstract class BaseJsonServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void onResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        //处理子类
        ResponseEntity responseEntity = null;

        try {
            responseEntity = onHandler(req, resp);
        } catch (Exception e) {
            responseEntity = new ResponseEntity();
        }

        PrintWriter printWriter = resp.getWriter();
		String responseJsonStr = JSON.toJSONString(responseEntity);
//        String responseJsonStr = "ttt";
        printWriter.write(responseJsonStr);
        printWriter.flush();
        printWriter.close();
    }

    protected abstract ResponseEntity onHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
/**
 * {
 * code:"0000"
 * msg:"�ɹ�"
 * data:{}
 * }
 */
