package server;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        System.out.println("Request");
        printWriter.write("test post");
        printWriter.flush();
        printWriter.close();
    }

    @Override
    protected long getLastModified(HttpServletRequest req) {
        // 这个文本有没有更新过,没有更新返回的状态码是304
        File file = new File(req.getRealPath("index.jsp"));
        System.out.println(file.lastModified() + "-->");
        return file.lastModified();
    }

}
