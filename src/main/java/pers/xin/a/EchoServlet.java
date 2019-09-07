package pers.xin.a;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/echo")
public class EchoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentThreadName = Thread.currentThread().getName();
        resp.setContentType("text/plant");
        PrintWriter pw = resp.getWriter();
        pw.printf("this request was handled by thread: %s.%n",currentThreadName);
        pw.flush();
        super.doGet(req, resp);
    }
}
