import java.util.ArrayList;

public class CoffeeKiosk {
    ArrayList<Item> menu;
    ArrayList<Order> orders;

    public CoffeeKiosk() {
        this.menu=new ArrayList<Item>();
        this.orders=new ArrayList<Order>();
    }

    public void addMenuItem (String name,double price){
        Item item=new Item(name, price);
        this.menu.add(item);
        this.menu.get(this.menu.size()-1).setIndex(this.menu.size()-1);       
    }

    public void displayMenu(){
        for(Item item:this.menu){
            System.out.println(item.getIndex() + " "+ item.getName() +" -- "+item.getPrice());
        }
    }

    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        Order newOrder= new Order(name);
        // Show the user the menu, so they can choose items to add.
        displayMenu();
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            
            // Get the item object from the menu, and add the item to the order
            newOrder.addItem(menu.get(Integer.parseInt(itemNumber)));
            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details 
        newOrder.display();
    }
    
}
