import ServerData.MatchStats;

/**
 * Created by daksenik on 19.08.2016.
 */
public class Test {
    public static void main(String[] args) {
        MatchStats ms = new MatchStats(new Engine.MatchUpdater("http://api.sportradar.us/soccer-t2/eu/matches/de074b21-67b6-4eba-986e-347594c0e844/boxscore.xml?api_key=jr6dgq5wm78dvda9pdvp4msb"));
        System.out.println(ms);
    }
}
