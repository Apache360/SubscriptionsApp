package authentication;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout-servlet")
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("cookiePass");
        session.removeAttribute("cookieLogin");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/log-in");
        dispatcher.forward(request, response);
    }
}
