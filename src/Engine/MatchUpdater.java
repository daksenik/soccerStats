package Engine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by daksenik on 19.08.2016.
 */
public class MatchUpdater {
    URL source = null;
    String content;

    public MatchUpdater(String query) {
        try{
            source = new URL(query);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    void updateContent() {
        try{
            HttpURLConnection connection = (HttpURLConnection)source.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String temp;
            StringBuilder response = new StringBuilder();
            while((temp = reader.readLine()) != null) response.append(temp);
            content = response.toString();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void initializeStats(ServerData.MatchStats ms){
        updateContent();
    }
    public void updateStats(ServerData.MatchStats ms){
        updateContent();
    }
}
