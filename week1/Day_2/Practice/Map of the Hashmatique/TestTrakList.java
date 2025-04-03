import java.util.HashMap;
public class TestTrakList{
    public static void main (String[] args) {
        HashMap<String,String> songs=new HashMap<String,String>();
        songs.put("Lose yourself","Look, if you had one shot or one opportunity");
        songs.put("Godzilla","I can swallow a bottle of alcohol and I'll feel like Godzilla");
        songs.put("Venom","When the world gives you a raw deal");
        songs.put("Killshot","When your fans become your haters");

        TrakList generator =new TrakList();

        System.out.println(generator.getOne(songs,"Killshot"));
        generator.getAll(songs);
    }
}