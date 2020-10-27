package model;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SessionScoped
public class Table implements Serializable {

    private List<Integer> id;
    private List<Publisher> publishers;
    private List<Customer> customers;
    private List<Delivery> deliveries;
    private static int maxId;

    public Table(){
        publishers = new ArrayList<>();
        customers = new ArrayList<>();
        deliveries = new ArrayList<>();
        id = new ArrayList<>();

        maxId = 5;
        IntStream.range(1, 5+1).forEach(i -> id.add(i));

        publishers.add(new Publisher("Тетрада", "08161, Київська обл., Києво-Святошинський р-н, с.Тарасівка, вул.Київська, 77/9", "0672316706", "tetrada@ukr.net"));
        publishers.add(new Publisher("МРІЇ ЗБУВАЮТЬСЯ", "07400, Київська обл., м.Бровари, вул.Металургів,47", "0459473621", "zoshit@zoshit.com"));
        publishers.add(new Publisher("БРІСК", "\t61020, г. Харьков, ул. Новомосковская, 4а", "0577833122", "brisk-office@ukr.net"));

        customers.add(new Customer("Анатолій Романович Дмитренко", "50206, Чернівецька область, місто Чернівці, пров. 50 років Жовтня, 40","0998577958"));
        customers.add(new Customer("Георгій Йосипович Павлюк", "93213, Чернігівська область, місто Чернігів, пров. Лесі Українки, 25","0506802828"));
        customers.add(new Customer("Боднаренко Євген Борисович", "01583, Волинська область, місто Луцьк, просп. Михайла Грушевського, 86","0506140427"));
        customers.add(new Customer("Іван Олексійович Микитюк", "15676, Запорізька область, місто Запоріжжя, пл. 40 років Перемоги, 30","0993016123"));
        customers.add(new Customer("Леонід Федорович Антоненко", "61795, Миколаївська область, місто Миколаїв, просп. Леніна, 84","0969124581"));

        deliveries.add(new Delivery("Нова Пошта","0984500609","support@novaposhta.ua"));
        deliveries.add(new Delivery("Укрпошта","0800300545","ukrposhta@ukrposhta.ua"));
    }

    public void setId(List<Integer> id) {
        this.id = id;
    }

    public List<Integer> getId() {
        return id;
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
}
