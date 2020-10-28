package account_types;

import model.Table;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user-servlet")
public class UserServlet extends HttpServlet {
    @Inject
    Table table;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();

        String publisherCheckBox = request.getParameter("publisherCheckBox");
        String customerCheckBox = request.getParameter("customerCheckBox");
        String deliveryCheckBox = request.getParameter("deliveryCheckBox");
        String idCheckBox = request.getParameter("idCheckBox");
        String customerPhoneCheckBox = request.getParameter("customerPhoneCheckBox");
        String customerAddressCheckBox = request.getParameter("customerAddressCheckBox");
        String publisherPhoneCheckBox = request.getParameter("publisherPhoneCheckBox");
        String publisherAddressCheckBox = request.getParameter("publisherAddressCheckBox");
        String publisherEmailCheckBox = request.getParameter("publisherEmailCheckBox");
        String deliveryPhoneCheckBox = request.getParameter("deliveryPhoneCheckBox");
        String deliveryEmailCheckBox = request.getParameter("deliveryEmailCheckBox");

        String checkBoxValue = " ";

        pw.write("<html>" +
                "<head><title>User page</title><head>" +
                "<body>" +
                "<div align='center'>" +
                "<h1> Сторінка користувача </h1><hr>" +
                "</div>" +
                "<div> " +
                "<h2>Блок вибірки</h2>" +
                "<form class='section' method='get' action='user-servlet'>");

        if (idCheckBox == null) checkBoxValue = " ";
        else checkBoxValue = "checked";
        pw.write("<input type='checkbox' name='idCheckBox' " + checkBoxValue + " > ID ");
        if (customerCheckBox == null) checkBoxValue = " ";
        else checkBoxValue = "checked";
        pw.write( "<input type='checkbox' name='customerCheckBox' " + checkBoxValue + "> Одержувач " );
        if (publisherCheckBox == null) checkBoxValue = " ";
        else checkBoxValue = "checked";
        pw.write("<input type='checkbox' name='publisherCheckBox' " + checkBoxValue + " > Видання ");
        if (deliveryCheckBox == null) checkBoxValue = " ";
        else checkBoxValue = "checked";
        pw.write("<input type='checkbox' name='deliveryCheckBox' " + checkBoxValue + "> Доставка");

        pw.write("<br><b><p>Додаткові параметри:</b></p>");
        if (customerPhoneCheckBox == null) checkBoxValue = " ";
        else checkBoxValue = "checked";
        pw.write("<input type='checkbox' name='customerPhoneCheckBox' " + checkBoxValue + " > Телефон одержувача ");
        if (customerAddressCheckBox == null) checkBoxValue = " ";
        else checkBoxValue = "checked";
        pw.write( "<input type='checkbox' name='customerAddressCheckBox' " + checkBoxValue + "> Адреса одержувача " );
        if (publisherPhoneCheckBox == null) checkBoxValue = " ";
        else checkBoxValue = "checked";
        pw.write("<br><input type='checkbox' name='publisherPhoneCheckBox' " + checkBoxValue + " > Телефон видання ");
        if (publisherAddressCheckBox == null) checkBoxValue = " ";
        else checkBoxValue = "checked";
        pw.write("<input type='checkbox' name='publisherAddressCheckBox' " + checkBoxValue + "> Адреса офісу видання");
        if (publisherEmailCheckBox == null) checkBoxValue = " ";
        else checkBoxValue = "checked";
        pw.write("<input type='checkbox' name='publisherEmailCheckBox' " + checkBoxValue + "> Пошта видання");
        if (deliveryPhoneCheckBox == null) checkBoxValue = " ";
        else checkBoxValue = "checked";
        pw.write("<br><input type='checkbox' name='deliveryPhoneCheckBox' " + checkBoxValue + "> Телефон доставки");
        if (deliveryEmailCheckBox == null) checkBoxValue = " ";
        else checkBoxValue = "checked";
        pw.write("<input type='checkbox' name='deliveryEmailCheckBox' " + checkBoxValue + "> Пошта доставки");

        pw.write("<br><input type='submit' value='SELECT'><br>");

        if (publisherCheckBox != null | customerCheckBox != null | deliveryCheckBox != null | idCheckBox != null){
            pw.write( "<table border='4'>" +
                    "<tr align='center'>");
            if (idCheckBox != null) pw.write("<td><b>ID</b></td>");
            if (customerCheckBox != null) pw.write("<td><b>Одержувач</b></td>");
            if (customerPhoneCheckBox != null) pw.write( "<td><b>Телефон одержувача</b></td>");
            if (customerAddressCheckBox != null) pw.write( "<td><b>Адреса одержувача</b></td>");

            if (publisherCheckBox != null) pw.write("<td><b>Видання</b></td>");
            if (publisherPhoneCheckBox != null) pw.write( "<td><b>Телефон видання</b></td>");
            if (publisherAddressCheckBox != null) pw.write( "<td><b>Адреса офісу видання</b></td>");
            if (publisherEmailCheckBox != null) pw.write( "<td><b>Почта видання</b></td>");

            if (deliveryCheckBox != null) pw.write( "<td><b>Доставка</b></td>");
            if (deliveryPhoneCheckBox != null) pw.write( "<td><b>Телефон доставки</b></td>");
            if (deliveryEmailCheckBox != null) pw.write( "<td><b>Пошта доставки</b></td>");

            for(int i = 0; i < table.getOrders().size(); i++){
                pw.write("<tr>");
                if (idCheckBox != null) pw.write("<td>"+table.getOrders().get(i).getId()+"</td>");
                if (customerCheckBox != null) pw.write("<td>"+table.getOrders().get(i).getCustomer().getName()+"</td>");
                if (customerPhoneCheckBox != null) pw.write( "<td>"+table.getOrders().get(i).getCustomer().getPhoneNumber()+"</td>");
                if (customerAddressCheckBox != null) pw.write( "<td>"+table.getOrders().get(i).getCustomer().getAddress()+"</td>");

                if (publisherCheckBox != null) pw.write("<td>"+table.getOrders().get(i).getPublisher().getName()+"</td>");
                if (publisherPhoneCheckBox != null) pw.write( "<td>"+table.getOrders().get(i).getPublisher().getPhoneNumber()+"</td>");
                if (publisherAddressCheckBox != null) pw.write( "<td>"+table.getOrders().get(i).getPublisher().getAddress()+"</td>");
                if (publisherEmailCheckBox != null) pw.write( "<td>"+table.getOrders().get(i).getPublisher().getEmail()+"</td>");

                if (deliveryCheckBox != null) pw.write( "<td>"+table.getOrders().get(i).getDelivery().getName()+"</td>");
                if (deliveryPhoneCheckBox != null) pw.write( "<td>"+table.getOrders().get(i).getDelivery().getPhoneNumber()+"</td>");
                if (deliveryEmailCheckBox != null) pw.write( "<td>"+table.getOrders().get(i).getDelivery().getEmail()+"</td>");

                pw.write("</tr>");
            }
            pw.write(    "</table>");}
        pw.write( "</form>" +
                "<hr>" +
                "</div>" +
                "<form  method='get' action='logout-servlet'>" +
                "<input type='submit' value='LOG OUT'>" +
                "</form>" +
                "</body>" +
                "</html>");
    }
}

