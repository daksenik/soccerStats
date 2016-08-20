package serverdata;

/**
 * Created by daksenik on 19.08.2016.
 */
public class Team {
    String id = "";
    String name = "";
    String fullName = "";
    String alias = "";
    String country = "";
    String countryCode = "";
    public Team(){}

    public String getId() { return id; }
    public String getName() { return name; }
    public String getFullName(){ return fullName; }
    public String getAlias() { return alias; }
    public String getCountry() { return country; }
    public String getCountryCode(){ return countryCode; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setAlias(String alias) { this.alias = alias; }
    public void setCountry(String country) { this.country = country; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    @Override
    public String toString(){
        return "\tTeam : " + fullName + "[" + alias + "] (" + countryCode + ")";
    }
}
