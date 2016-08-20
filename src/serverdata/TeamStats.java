package serverdata;

/**
 * Created by daksenik on 19.08.2016.
 */
public class TeamStats {
    public Team team = null;
    public static String[] statFields = {
        "attacks",
        "ball_safe",
        "corner_kicks",
        "dangerous_attacks",
        "fouls",
        "free_kicks",
        "goal_attempts",
        "goal_kicks",
        "offsides",
        "red_card",
        "saves",
        "substitutions",
        "throw_ins",
        "yellow_card",
        "yellow_red_card",
        "shots_on_target",
        "shots_off_target",
        "shots_total",
        "possessions"
    };
    static String[] statNames = {
            "Attacks count",
            "Ball safe",
            "Corners",
            "Dangerous attacks",
            "Fouls",
            "Free kicks",
            "Goal attempts",
            "Goal kicks",
            "Offsides",
            "Red cards",
            "Saves",
            "Substitutions",
            "Throwings",
            "Yellow cards",
            "Red-after-yellow cards",
            "Shots on target",
            "Shots off target",
            "Shots total",
            "Possession"
    };
    int score = 0;
    int regularScore = 0;
    int penaltyScore = 0;
    String formation;

    int[]stats;
    public TeamStats() {
        team = new Team();
        stats = new int[statFields.length];
    }

    public int getStat(int idx) { return stats[idx]; }
    public int getScore() { return score; }
    public int getRegularScore() { return regularScore; }
    public int getPenaltyScore() { return penaltyScore; }
    public String getFormation() { return formation; }

    public void setStat(int idx, int val) { stats[idx] = val; }
    public void setScore(int val) { score = val; }
    public void setRegularScore(int val) { regularScore = val; }
    public void setPenaltyScore(int val) { penaltyScore = val; }
    public void setFormation(String val) { formation = val; }

    @Override
    public String toString(){
        String result = team.toString() + "\n\tScore : " + score + "\n\tPenalty score : " + penaltyScore +
                "\n\tRegular score : " + regularScore + "\n\tFormation : " + formation + "\n";
        for(int i=0; i < statNames.length; i++)result += "\t\t" + statNames[i] + " : " + stats[i] + "\n";
        return result;
    }


}
