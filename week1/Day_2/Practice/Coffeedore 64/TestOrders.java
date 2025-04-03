public class TestOrders {
    public static void main(String[] args) {
    CoffeeKiosk cofee= new CoffeeKiosk();
    cofee.addMenuItem("direct",2.5);
    cofee.addMenuItem("express",1.5);
    cofee.addMenuItem("cappucin",2);
    cofee.addMenuItem("latte",4);
    cofee.displayMenu();
    cofee.newOrder();
    }
}