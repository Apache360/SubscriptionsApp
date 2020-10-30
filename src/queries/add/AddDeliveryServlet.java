package queries.add;

import model.Customer;
import model.Delivery;
import model.Table;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/add-delivery-servlet")
public class AddDeliveryServlet extends HttpServlet {

    @Inject
    Table table;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        table.getDeliveries().add(new Delivery(
                getStringUTFParameter(request.getParameter("addDeliveryName")),
                getStringUTFParameter(request.getParameter("addDeliveryPhone")),
                getStringUTFParameter(request.getParameter("addDeliveryEmail"))
        ));
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/admin-servlet?idCheckBox=on&customerCheckBox=on&publisherCheckBox=on&deliveryCheckBox=on" +
                        "&customerPhoneCheckBox=on&customerAddressCheckBox=on&publisherPhoneCheckBox=on" +
                        "&publisherAddressCheckBox=on&publisherEmailCheckBox=on" +
                        "&deliveryPhoneCheckBox=on&deliveryEmailCheckBox=on");
        dispatcher.forward(request, response);
    }

    private String getStringUTFParameter(String parameter){
        return new String(parameter.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }
}


