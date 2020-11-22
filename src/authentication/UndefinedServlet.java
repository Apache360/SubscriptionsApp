package authentication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/undefined-servlet")
public class UndefinedServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.write("<html>" +
                "<head><title>Undefined page</title><head>" +
                "<body>Помилка авторизації" +
                "<form  method='get' action='logout-servlet'>" +
                "<input type='submit' value='Вийти'></form></body>" +
                "</html>");
    }
}
