package authentication;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/authentication")
public class AuthenticationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookieLogin = new Cookie("login", request.getParameter("login"));
        Cookie cookiePass = new Cookie("password", request.getParameter("password"));
        boolean undefined=true;
        cookiePass.setMaxAge(30 * 60);
        HttpSession session = request.getSession();
        session.setAttribute("cookieLogin", cookieLogin);
        session.setAttribute("cookiePass", cookiePass);
        response.addCookie(cookieLogin);
        response.addCookie(cookiePass);

        RequestDispatcher dispatcher;
        if (cookieLogin.getValue().equals("admin") & cookiePass.getValue().equals("1111")){
            dispatcher = request.getRequestDispatcher("/admin-servlet");
            dispatcher.forward(request, response);
            undefined=false;
        }
        if(cookieLogin.getValue().equals("user") & cookiePass.getValue().equals("1111")){
            dispatcher = request.getRequestDispatcher("/user-servlet");
            dispatcher.forward(request, response);
            undefined=false;
        }
        if(undefined) {
            dispatcher = request.getRequestDispatcher("/undefined-servlet");
            dispatcher.forward(request, response);
        }
    }
}
