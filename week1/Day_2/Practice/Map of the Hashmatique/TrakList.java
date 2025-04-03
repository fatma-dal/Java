import java.util.HashMap;
import java.util.Set;
public class TrakList{
    public String getOne(HashMap<String,String> songs , String title){
        return songs.get(title);
    }

    public void getAll(HashMap<String,String> songs){
        Set<String> keys=songs.keySet();
        for(String key:keys){
            System.out.println(key+" : "+songs.get(key));
        }
    }
}