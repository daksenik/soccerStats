import serverdata.MatchStats;

/**
 * Created by daksenik on 19.08.2016.
 */
public class Test {
    public static void main(String[] args) {
        MatchStats ms = new MatchStats(new engine.MatchUpdater("http://api.sportradar.us/soccer-t2/eu/matches/9c1ef21d-f57e-43d5-bdd0-364d4970d813/boxscore.xml?api_key=jr6dgq5wm78dvda9pdvp4msb"));
        System.out.println(ms);
    }
}
