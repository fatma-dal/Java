import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        
        return String.format("hello, %s .Lovely to see you.",name);
    }
    
    public String dateAnnouncement() {
        Date date=new Date();
        return "It is currently "+date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        String result;
        if(conversation.indexOf("Alexis")>-1){
            result="Right away, sir. She certainly isn't sophisticated enough for that.";
        }else if(conversation.indexOf("Alfred")>-1){
            result="At your service. As you wish, naturally.";
        }else{
            result="Right. And with that I shall retire.";
        }
        return result;
    }
    public String guestGreeting(String name,String dayPeriod) {
        
        return String.format("Good %S, %s .Lovely to see you.",dayPeriod,name);
    }
	// NINJA BONUS
	// See the specs to overload the guestGreeting method

        // SENSEI BONUS
        // Write your own AlfredQuote method using any of the String methods you have learned!
}

