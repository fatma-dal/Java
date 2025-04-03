import java.util.Random;
import java.util.ArrayList;
public class PuzzleJava{
    public ArrayList<Integer> getTenRolls(){
        Random randMachine = new Random();
        ArrayList<Integer> array=new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            array.add(randMachine.nextInt(20));
        }
        return array;
    }


    public char getRandomLetter(){
        Random randMachine = new Random();
        char[]myArray={'a','z','e','r','t','y','u','i','o','p','q','s','d','f','g','h','j','k','l','m','w','x','c','v','b','n'};
        return myArray[randMachine.nextInt(25)];
    }

    public String generatePassword(){
        String ch="";
        for(int i=0;i<8;i++){
            ch+=getRandomLetter();
        }
        return ch;
    }

    public ArrayList<String> getNewPasswordSet(int n){
        ArrayList<String> passArray=new ArrayList<String>();
        for(int i=0;i<n;i++){
            passArray.add(generatePassword());
        }
        return passArray;
    }
}