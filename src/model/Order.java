package model;

public class Order {
    private int id;
    private Customer customer;
    private Delivery delivery;
    private Publisher publisher;
    static private int currentId=0;

    Order(Customer customer, Delivery delivery, Publisher publisher) {
        currentId++;
        this.id = currentId;
        this.customer = customer;
        this.delivery = delivery;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
