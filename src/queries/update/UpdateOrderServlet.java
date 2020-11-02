package queries.update;

import model.Order;
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

@WebServlet("/update-order-servlet")
public class UpdateOrderServlet extends HttpServlet {

    @Inject
    Table table;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("idList");
        System.out.println(str);

        table.getOrders().get(Integer.parseInt(request.getParameter("idList")))
                .setCustomer(table.getCustomers().get(Integer.parseInt(request.getParameter("idCustomer"))));
        table.getOrders().get(Integer.parseInt(request.getParameter("idList")))
                .setPublisher(table.getPublishers().get(Integer.parseInt(request.getParameter("idPublisher"))));
        table.getOrders().get(Integer.parseInt(request.getParameter("idList")))
                .setDelivery(table.getDeliveries().get(Integer.parseInt(request.getParameter("idDelivery"))));

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


