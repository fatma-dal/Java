public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        
    
        // Order variables -- order1, order2 etc.
        Order order1=new Order();
        Order order2=new Order();
        Order order3=new Order("yassin");
        Order order4=new Order("aziz");
        Order order5=new Order("farouk");

        Item item1=new Item("capuccino", 5.5);

        order1.addItem(item1);
        System.out.println(order1.getStatusMessage() + " your Total is : " + order1.getOrderTotal());
        System.out.println("*****************");
        order1.display();
        System.out.println("*****************");


        order2.setReady(true);
        System.out.println(order2.getStatusMessage());

        System.out.println("*****************");
        order1.display();

        System.out.println("*****************");
        order2.display();

        System.out.println("*****************");
        order3.display();

        System.out.println("*****************");
        order4.display();

        System.out.println("*****************");
        order5.display();

        
        // Application Simulations
        // Use this example code to test various orders' updates
        
    }
}
