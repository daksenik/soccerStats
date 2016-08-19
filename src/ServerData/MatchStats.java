package ServerData;

import Engine.MatchUpdater;

/**
 * Created by daksenik on 19.08.2016.
 */
public class MatchStats {
    TeamStats home = null;
    TeamStats away = null;
    String id = "";
    String status = "";
    String period = "";
    String startTime = "";
    int curTime = 0;
    String seasonId = "";
    String stadiumName = "";
    int capacity = 0;
    MatchUpdater matchUpdater = null;

    public MatchStats(MatchUpdater source){
        matchUpdater = source;
        matchUpdater.initializeStats(this);
    }

    public TeamStats getHome() { return home; }
    public TeamStats getAway() { return away; }
    public String getId() { return id; }
    public String getStatus() { return status; }
    public String getPeriod() { return period; }
    public String getStartTime() { return startTime; }
    public int getCurTime() { return curTime; }
    public String getSeasonId() { return seasonId; }
    public String getStadiumName() { return stadiumName; }
    public int getCapacity() { return capacity; }
    public void setHome(TeamStats home) { this.home = home; }
    public void setAway(TeamStats away) { this.away = away; }
    public void setId(String id) { this.id = id; }
    public void setStatus(String status) { this.status = status; }
    public void setPeriod(String period) { this.period = period; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public void setCurTime(int curTime) { this.curTime = curTime; }
    public void setSeasonId(String seasonId) { this.seasonId = seasonId; }
    public void setStadiumName(String stadiumName) { this.stadiumName = stadiumName; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public void update() { matchUpdater.updateStats(this); }
    public void totalUpdate() { matchUpdater.initializeStats(this); }
}
