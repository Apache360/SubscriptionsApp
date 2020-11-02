package queries.update;

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

@WebServlet("/update-item-servlet")
public class UpdateItemServlet extends HttpServlet {
    @Inject
    Table table;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8;");
        int id = Integer.parseInt(request.getParameter("idList"));
        int currentID=0;
        for (int i =0;i<table.getOrders().size();i++){
            if (table.getOrders().get(i).getId()==id){currentID=table.getOrders().indexOf(table.getOrders().get(i));}
        }

        if (!getStringUTFParameter(request.getParameter("updateCustomerName")).equals("")){
            table.getOrders().get(currentID).getCustomer().setName(getStringUTFParameter(request.getParameter("updateCustomerName")));}
        if (!getStringUTFParameter(request.getParameter("updateCustomerPhone")).equals("")){
            table.getOrders().get(currentID).getCustomer().setPhoneNumber(getStringUTFParameter(request.getParameter("updateCustomerPhone")));}
        if (!getStringUTFParameter(request.getParameter("updateCustomerAddress")).equals("")){
            table.getOrders().get(currentID).getCustomer().setAddress(getStringUTFParameter(request.getParameter("updateCustomerAddress")));}

        if (!getStringUTFParameter(request.getParameter("updatePublisherName")).equals("")){
            table.getOrders().get(currentID).getPublisher().setName(getStringUTFParameter(request.getParameter("updatePublisherName")));}
        if (!getStringUTFParameter(request.getParameter("updatePublisherPhone")).equals("")){
            table.getOrders().get(currentID).getPublisher().setPhoneNumber(getStringUTFParameter(request.getParameter("updatePublisherPhone")));}
        if (!getStringUTFParameter(request.getParameter("updatePublisherAddress")).equals("")){
            table.getOrders().get(currentID).getPublisher().setAddress(getStringUTFParameter(request.getParameter("updatePublisherAddress")));}
        if (!getStringUTFParameter(request.getParameter("updatePublisherEmail")).equals("")){
            table.getOrders().get(currentID).getPublisher().setEmail(getStringUTFParameter(request.getParameter("updatePublisherEmail")));}

        if (!getStringUTFParameter(request.getParameter("updateDeliveryName")).equals("")){
            table.getOrders().get(currentID).getDelivery().setName(getStringUTFParameter(request.getParameter("updateDeliveryName")));}
        if (!getStringUTFParameter(request.getParameter("updateDeliveryPhone")).equals("")){
            table.getOrders().get(currentID).getDelivery().setPhoneNumber(getStringUTFParameter(request.getParameter("updateDeliveryPhone")));}
        if (!getStringUTFParameter(request.getParameter("updateDeliveryEmail")).equals("")){
            table.getOrders().get(currentID).getDelivery().setEmail(getStringUTFParameter(request.getParameter("updateDeliveryEmail")));}

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
