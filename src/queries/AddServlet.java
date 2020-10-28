package queries;

import model.*;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/add-servlet")
public class AddServlet extends HttpServlet {

    @Inject
    Table table;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        table.getOrders().add(new Order(new Customer(getStringUTFParameter(request.getParameter("addCustomer")),"unknown address","unknown phone"),
                new Delivery(getStringUTFParameter(request.getParameter("addDelivery")),"unknown phone","unknown email"),
                new Publisher(getStringUTFParameter(request.getParameter("addPublisher")),"unknown address","unknown phone","unknown email")));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-servlet?idCheckBox=on&publisherCheckBox=on&customerCheckBox=on&deliveryCheckBox=on");
        dispatcher.forward(request, response);
    }


    private String getStringUTFParameter(String parameter){
        return new String(parameter.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }
}


