package engine;

/**
 * Created by daksenik on 22.08.2016.
 */
public class RequestBuilder {
    private static String apiKey = "jr6dgq5wm78dvda9pdvp4msb";
    
    public static String getMatchStatsRequest(String matchID){
        StringBuilder sb = new StringBuilder("http://api.sportradar.us/soccer-t2/eu/matches/");
        sb.append(matchID);
        sb.append("/boxscore.xml?api_key=");
        sb.append(apiKey);
        return sb.toString();
    }
}
