import java.util.ArrayList;

import javax.swing.event.SwingPropertyChangeSupport;
class Order{
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order(){
        this.name="Guest";
        this.items=new ArrayList<Item>();
    }

    public Order(String name){
        this.name=name;
        this.items=new ArrayList<Item>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public boolean isReady() {
        return ready;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }
    
    public String getStatusMessage(){
        return this.ready?"Your order is ready.":"Thank you for waiting. Your order will be ready soon.";
    }

    public double getOrderTotal(){
        double total=0;
        for(Item item :items){
            total+=item.getPrice();
        }
        return total;
    }
    public void display(){
        System.out.println("Customer Name : " +this.name);
        for(Item item:items){
            System.out.println(item.getName() +" - $"+item.getPrice());
        }
        System.out.println("Total : $"+getOrderTotal());
    }
}