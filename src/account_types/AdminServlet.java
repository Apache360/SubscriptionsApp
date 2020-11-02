package account_types;

import model.Table;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin-servlet")
public class AdminServlet extends HttpServlet {
    @Inject
    Table table;

    private String publisherCheckBox ;
    private String customerCheckBox;
    private String deliveryCheckBox;
    private String idCheckBox;
    private String customerPhoneCheckBox;
    private String customerAddressCheckBox ;
    private String publisherPhoneCheckBox;
    private String publisherAddressCheckBox ;
    private String publisherEmailCheckBox;
    private String deliveryPhoneCheckBox ;
    private String deliveryEmailCheckBox ;
    private HttpSession session;
    private PrintWriter pw;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8;");
        pw =  response.getWriter();
        session = request.getSession();
        session.setAttribute("table", table);

        idCheckBox = request.getParameter("idCheckBox");
        publisherCheckBox = request.getParameter("publisherCheckBox");
        customerCheckBox = request.getParameter("customerCheckBox");
        deliveryCheckBox = request.getParameter("deliveryCheckBox");
        customerPhoneCheckBox = request.getParameter("customerPhoneCheckBox");
        customerAddressCheckBox = request.getParameter("customerAddressCheckBox");
        publisherPhoneCheckBox = request.getParameter("publisherPhoneCheckBox");
        publisherAddressCheckBox = request.getParameter("publisherAddressCheckBox");
        publisherEmailCheckBox = request.getParameter("publisherEmailCheckBox");
        deliveryPhoneCheckBox = request.getParameter("deliveryPhoneCheckBox");
        deliveryEmailCheckBox = request.getParameter("deliveryEmailCheckBox");

        pw.write(    "<html><head><title>SubsApp/admin</title><head>" +
                "<body>" +
                "<div align='center'>" +
                "<h1> Сторінка адміна </h1>" +
                "</div>" +
                "<hr>");
        select(pw);
        add(pw);
        update(pw);
        delete(pw);
        logOut(pw);
        pw.write("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        pw =  response.getWriter();
        session = request.getSession();
        session.setAttribute("table", table);
        idCheckBox = request.getParameter("idCheckBox");
        publisherCheckBox = request.getParameter("publisherCheckBox");
        customerCheckBox = request.getParameter("customerCheckBox");
        deliveryCheckBox = request.getParameter("deliveryCheckBox");
        customerPhoneCheckBox = request.getParameter("customerPhoneCheckBox");
        customerAddressCheckBox = request.getParameter("customerAddressCheckBox");
        publisherPhoneCheckBox = request.getParameter("publisherPhoneCheckBox");
        publisherAddressCheckBox = request.getParameter("publisherAddressCheckBox");
        publisherEmailCheckBox = request.getParameter("publisherEmailCheckBox");
        deliveryPhoneCheckBox = request.getParameter("deliveryPhoneCheckBox");
        deliveryEmailCheckBox = request.getParameter("deliveryEmailCheckBox");

        pw.write(    "<html>" +
                "<head><title>SubsApp/admin</title><meta charset='utf-8'><head>" +
                "<body>" +
                "<div align='center'>" +
                "<h1> Сторінка адміністратора </h1></div>" +
                "<hr>");
        select(pw);
        add(pw);
        update(pw);
        delete(pw);
        logOut(pw);
        pw.write("</body></html>");
    }

    private void add(PrintWriter pw) {
        pw.write("<div>" +
                "<h2><p align='center'>Блок додавання</h2></p>");
        addOrder(pw);
        addCustomer(pw);
        addPublisher(pw);
        addDelivery(pw);
        pw.write("<hr></div>");
    }

    private void addOrder(PrintWriter pw){
        pw.write("<div><table border='2'><form method='post' action='add-order-servlet'>" +
                "<tr align='center'><td colspan=\"2\"><b>Додавання нового замовлення</b></td></tr>"+
                "<tr><td><b>Одержувач</b></td><td><select name='idCustomer'>");
        for(int i=0; i<table.getCustomers().size();i++){
            pw.write("<option value='" + i + "'>" + table.getCustomers().get(i).getName() + "</option>");
        }
        pw.write("</select></td></tr>" +
                "<tr><td><b>Видання</b></td>" +
                "<td><select name='idPublisher'>");
        for(int i=0; i<table.getPublishers().size();i++){
            pw.write("<option value='" + i + "'>" + table.getPublishers().get(i).getName() + "</option>");
        }
        pw.write("</select></td></tr>" +
                "<tr><td><b>Доставка</b></td><td><select name='idDelivery'>");
        for(int i=0; i<table.getDeliveries().size();i++){
            pw.write("<option value='" + i + "'>" + table.getDeliveries().get(i).getName() + "</option>");
        }
        pw.write("</select></td></tr>" +
                "<tr align='center'><td colspan=\"2\"><input type='submit' value='Додати замовлення'></tr></td></table>" +
                "</form>" +
                "</div>");
    }

    private void addCustomer(PrintWriter pw){
        pw.write("<div><table border='2'><form method='post' action='add-customer-servlet'>" +
                "<tr align='center'><td colspan=\"2\"><b>Додавання нового користувача</b></td></tr>"+
                "<tr><td><b>Нове ім'я одержувача</b></td>"+
                "<td><input type='text' size='15' name='addCustomerName'></td></tr>"+
                "<tr><td><b>Новий телефон одержувача</b></td>" +
                "<td><input type='text' size='15' name='addCustomerPhone'></td></tr>" +
                "<tr><td><b>Нова адреса одержувача</b></td>" +
                "<td><input type='text' size='15' name='addCustomerAddress'></td></tr>"+
                "<tr align='center'><td colspan=\"2\"><input type='submit' value='Додати користувача'></td></tr>" +
                "</table></form></div>");
    }

    private void addPublisher(PrintWriter pw){
        pw.write("<div><table border='2'><form method='post' action='add-publisher-servlet'>" +
                "<tr align='center'><td colspan=\"2\"><b>Додавання нового видання</b></td></tr>"+
                "<tr><td><b>Нове ім'я видання</b></td>"+
                "<td><input type='text' size='15' name='addPublisherName'></td></tr>"+
                "<tr><td><b>Новий телефон видання</b></td>" +
                "<td><input type='text' size='15' name='addPublisherPhone'></td></tr>"+
                "<tr><td><b>Нова адреса офісу видання</b></td>" +
                "<td><input type='text' size='15' name='addPublisherAddress'></td></tr>" +
                "<tr><td><b>Нова пошта видання</b></td>" +
                "<td><input type='text' size='15' name='addPublisherEmail'></td></tr>"+
                "<tr align='center'><td colspan=\"2\"><input type='submit' value='Додати видання'></td></tr>" +
                "</table></form></div>");
    }

    private void addDelivery(PrintWriter pw){
        pw.write("<div><table border='2'><form method='post' action='add-delivery-servlet'>" +
                "<tr align='center'><td colspan=\"2\"><b>Додавання нової доставки</b></td></tr>"+
                "<tr><td><b>Нове ім'я доставки</b></td>"+
                "<td><input type='text' size='15' name='addDeliveryName'></td></tr>"+
                "<tr><td><b>Новий телефон доставки</b></td>" +
                "<td><input type='text' size='15' name='addDeliveryPhone'></td></tr>" +
                "<tr><td><b>Нова пошта доставки</b></td>" +
                "<td><input type='text' size='15' name='addDeliveryEmail'></td></tr>"+
                "<tr align='center'><td colspan=\"2\"><input type='submit' value='Додати доставку'></td></tr>" +
                "</table></form></div>");
    }

    private void select(PrintWriter pw){
        pw.write("<div> " +
                "<h2><p align='center'>Блок вибірки</p></h2>" +
                "<form class='section' method='get' action='admin-servlet'>");
        String checkBoxValue = " ";

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

        pw.write("<br><input type='submit' value='Показати'><br>");

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
                "</div>");
    }

    private void update(PrintWriter pw){
        if (table.getOrders().size()>0) {
            pw.write("<div>" +
                    "<h2><p align='center'>Блок редагування</p></h2>" +
                    "<form method='post' action='update-servlet'>" +
                    "<h3>ID</h3><select name='idList'>");
            table.getOrders().forEach(i -> pw.write("<option value='" + i.getId() + "'>" + i.getId() + "</option>"));
            pw.write("</select>" +
                    "<div><p><h3>Редагування користувача за обраним ID: </h3></p>" +
                    "<table border='2'><tr align='center'><td><b>Нове ім'я одержувача</b></td>"+
                    "<td><b>Новий телефон одержувача</b></td>"+
                    "<td><b>Нова адреса одержувача</b></td></tr>"+
                    "<tr align='center'><td><input type='text' size='15' name='updateCustomerName'></td>" +
                    "<td><input type='text' size='15' name='updateCustomerPhone'></td>" +
                    "<td><input type='text' size='15' name='updateCustomerAddress'></td></tr></table></div>" +

                    "<div><p><h3>Редагування видання за обраним ID: </h3></p>" +
                    "<table border='2'><tr align='center'><td><b>Нове ім'я видання</b></td>"+
                    "<td><b>Новий телефон видання</b></td>"+
                    "<td><b>Нова адреса офісу видання</b></td>"+
                    "<td><b>Нова пошта видання</b></td></tr>"+
                    "<tr align='center'><td><input type='text' size='15' name='updatePublisherName'></td>" +
                    "<td><input type='text' size='15' name='updatePublisherPhone'></td>" +
                    "<td><input type='text' size='15' name='updatePublisherAddress'></td>" +
                    "<td><input type='text' size='15' name='updatePublisherEmail'></td></tr></table></div>" +

                    "<div><p><h3>Редагування доставки за обраним ID: </h3></p>" +
                    "<table border='2'><tr align='center'><td><b>Нове ім'я доставки</b></td>"+
                    "<td><b>Новий телефон доставки</b></td>"+
                    "<td><b>Нова пошта доставки</b></td></tr>"+
                    "<tr align='center'><td><input type='text' size='15' name='updateDeliveryName'></td>" +
                    "<td><input type='text' size='15' name='updateDeliveryPhone'></td>" +
                    "<td><input type='text' size='15' name='updateDeliveryEmail'></td></tr></table></div>" +

                    "<input type='submit' value='Змінити'>" +
                    "</form>" +
                    "</div>");

            pw.write("<div>" +
                    "<form method='post' action='update-order-servlet'><h3>ID</h3><select name='idList'>");
            table.getOrders().forEach(i -> pw.write("<option value='" + i.getId() + "'>" + i.getId() + "</option>"));
            pw.write("</select>" +
                    "<table border='2'>" +
                    "<tr align='center'><td colspan=\"2\"><b>Додавання нового замовлення</b></td></tr>"+
                    "<tr><td><b>Одержувач</b></td><td><select name='idCustomer'>");
            for(int i=0; i<table.getCustomers().size();i++){
                pw.write("<option value='" + i + "'>" + table.getCustomers().get(i).getName() + "</option>");
            }
            pw.write("</select></td></tr>" +
                    "<tr><td><b>Видання</b></td>" +
                    "<td><select name='idPublisher'>");
            for(int i=0; i<table.getPublishers().size();i++){
                pw.write("<option value='" + i + "'>" + table.getPublishers().get(i).getName() + "</option>");
            }
            pw.write("</select></td></tr>" +
                    "<tr><td><b>Доставка</b></td><td><select name='idDelivery'>");
            for(int i=0; i<table.getDeliveries().size();i++){
                pw.write("<option value='" + i + "'>" + table.getDeliveries().get(i).getName() + "</option>");
            }
            pw.write("</select></td></tr>" +
                    "<tr align='center'><td colspan=\"2\"><input type='submit' value='Додати замовлення'></tr></td></table>" +
                    "</form>" +
                    "</div>");
                    pw.write("<hr>");
        }
    }

    private void delete(PrintWriter pw){
        if (table.getOrders().size()>0){
            pw.write("<div>" +
                    "<h2><p align='center'>Блок видалення</p></h2>"+
                    "<form  method='post' action='delete-servlet'>" +
                    "<h3>ID</h3><select name='idToDelete'>");
            table.getOrders().forEach(i -> pw.write("<option value='"+i.getId()+"'>" + i.getId() + "</option>"));
            pw.write("</select>" +
                    "<input type='submit' value='Видалити'>" +
                    "</form>" +
                    "</div>");
        }
    }

    private void logOut(PrintWriter pw){
        pw.write("<br><hr><br>" +
                "<form  method='get' action='logout-servlet'>" +
                "<input type='submit' value='LOG OUT'>" +
                "</form>");
    }
}

