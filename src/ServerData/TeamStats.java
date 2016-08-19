package ServerData;

/**
 * Created by daksenik on 19.08.2016.
 */
public class TeamStats {
    Team team = null;
    public static enum statID{
        attacks,
        ballSafe,
        cornerKicks,
        dangerousAttacks,
        fouls,
        freeKicks,
        goalAttempts,
        goalKicks,
        redCard,
        saves,
        throwings,
        yellowCard,
        yellowRedCard,
        shotsOnTarget,
        shotsOffTarget,
        shotsTotal,
        possession
    };
    int score = 0;
    int regularScore = 0;
    int penaltyScore = 0;

    int[]stats = new int[17];
    public TeamStats() {}

    public int getStat(statID idx) { return stats[idx.ordinal()]; }
    public int getScore() { return score; }
    public int getRegularScore() { return regularScore; }
    public int getPenaltyScore() { return penaltyScore; }

    public void setStat(statID idx, int val) { stats[idx.ordinal()] = val; }
    public void setScore(int val) { score = val; }
    public void setRegularScore(int val) { regularScore = val; }
    public void setPenaltyScore(int val) { penaltyScore = val; }
}
