package model;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
public class Table implements Serializable {

    private List<Publisher> publishers;
    private List<Customer> customers;
    private List<Delivery> deliveries;
    private List<Order> orders;
    static int id=0;

    public Table(){
        publishers = new ArrayList<>();
        customers = new ArrayList<>();
        deliveries = new ArrayList<>();
        orders = new ArrayList<>();

        customers.add(new Customer("Анатолій Романович Дмитренко", "50206, Чернівецька область, місто Чернівці, пров. 50 років Жовтня, 40","0998577958"));
        customers.add(new Customer("Георгій Йосипович Павлюк", "93213, Чернігівська область, місто Чернігів, пров. Лесі Українки, 25","0506802828"));
        customers.add(new Customer("Боднаренко Євген Борисович", "01583, Волинська область, місто Луцьк, просп. Михайла Грушевського, 86","0506140427"));
        customers.add(new Customer("Іван Олексійович Микитюк", "15676, Запорізька область, місто Запоріжжя, пл. 40 років Перемоги, 30","0993016123"));
        customers.add(new Customer("Леонід Федорович Антоненко", "61795, Миколаївська область, місто Миколаїв, просп. Леніна, 84","0969124581"));

        publishers.add(new Publisher("Тетрада", "08161, Київська обл., Києво-Святошинський р-н, с.Тарасівка, вул.Київська, 77/9", "0672316706", "tetrada@ukr.net"));
        publishers.add(new Publisher("МРІЇ ЗБУВАЮТЬСЯ", "07400, Київська обл., м.Бровари, вул.Металургів,47", "0459473621", "zoshit@zoshit.com"));
        publishers.add(new Publisher("БРІСК", "61020, г. Харьков, ул. Новомосковская, 4а", "0577833122", "brisk-office@ukr.net"));

        deliveries.add(new Delivery("Нова Пошта","0984500609","support@novaposhta.ua"));
        deliveries.add(new Delivery("Укрпошта","0800300545","ukrposhta@ukrposhta.ua"));

        orders.add(new Order(customers.get(0),deliveries.get(1),publishers.get(0)));
        orders.add(new Order(customers.get(1),deliveries.get(1),publishers.get(0)));
        orders.add(new Order(customers.get(1),deliveries.get(1),publishers.get(1)));
        orders.add(new Order(customers.get(2),deliveries.get(0),publishers.get(2)));
        orders.add(new Order(customers.get(2),deliveries.get(0),publishers.get(1)));
        orders.add(new Order(customers.get(3),deliveries.get(0),publishers.get(2)));
        orders.add(new Order(customers.get(4),deliveries.get(0),publishers.get(1)));
        orders.add(new Order(customers.get(4),deliveries.get(1),publishers.get(0)));
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
