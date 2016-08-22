package engine;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by daksenik on 19.08.2016.
 */
public class MatchUpdater {
    URL source = null;
    String content;

    public MatchUpdater(String matchID) {
        try{
            source = new URL(RequestBuilder.getMatchStatsRequest(matchID));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    void updateContent() {
        try{
            HttpURLConnection connection = (HttpURLConnection)source.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String temp;
            StringBuilder response = new StringBuilder();
            while((temp = reader.readLine()) != null) response.append(temp);
            content = response.toString();
            connection.disconnect();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void initializeStats(serverdata.MatchStats ms){
        updateContent();
        updateStats(ms, false);
    }
    public void updateStats(serverdata.MatchStats ms, boolean contentUpd){
        if (contentUpd) updateContent();

        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            StringBuilder toParse = new StringBuilder();
            for (int i = 0; i < content.length(); i++)
                if (content.charAt(i) != ' ' || content.charAt(i - 1) != ' ')
                    toParse.append(content.charAt(i));
            Document doc = builder.parse(new InputSource(new StringReader(toParse.toString())));
            Element root = doc.getDocumentElement();

            Node curNode = root.getFirstChild().getNextSibling();//matches
            curNode = curNode.getFirstChild().getNextSibling();//match
            Element match = (Element)curNode;
            ms.setStatus(match.getAttribute("status").trim());
            ms.setPeriod(match.getAttribute("period").trim());
            if (match.getAttribute("clock").trim().length() == 0) ms.setCurTime(0);
                else ms.setCurTime(Integer.parseInt(match.getAttribute("clock").trim()));
            curNode = curNode.getFirstChild();
            while (curNode != null && !curNode.getNodeName().equals("home"))
                curNode = curNode.getNextSibling();
            if (curNode == null)return;
            parseTeam(curNode, ms.getHome());
            while (curNode != null && !curNode.getNodeName().equals("away"))
                curNode = curNode.getNextSibling();
            if (curNode == null)return;
            parseTeam(curNode, ms.getAway());
            while (curNode != null && !curNode.getNodeName().equals("venue"))
                curNode = curNode.getNextSibling();
            if (curNode == null)return;
            Element stadium = (Element)curNode;
            ms.setStadiumName(stadium.getAttribute("name").trim());
            ms.setCapacity(Integer.parseInt(stadium.getAttribute("capacity").trim()));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void updateStats(serverdata.MatchStats ms){
        updateStats(ms,true);
    }

    public void parseTeam(Node curNode, serverdata.TeamStats ts){
        Element team = (Element)curNode;
        ts.team.setName(team.getAttribute("name").trim());
        ts.team.setFullName(team.getAttribute("full_name").trim());
        ts.team.setAlias(team.getAttribute("alias").trim());
        ts.team.setCountryCode(team.getAttribute("country_code").trim());
        ts.team.setCountry(team.getAttribute("country").trim());
        ts.setFormation(team.getAttribute("formation").trim());
        ts.setScore(Integer.parseInt(team.getAttribute("score").trim()));
        if(team.getAttribute("regular_score").trim().length() != 0)
            ts.setRegularScore(Integer.parseInt(team.getAttribute("regular_score").trim()));
        if(team.getAttribute("penalty_score").trim().length() != 0)
            ts.setPenaltyScore(Integer.parseInt(team.getAttribute("penalty_score").trim()));
        curNode = curNode.getFirstChild().getNextSibling();
        curNode = curNode.getNextSibling().getNextSibling(); //stats follows the scoring
        Element stats = (Element)curNode;
        if(stats == null)return;
        for(int i = 0;i < ts.statFields.length;i++)
            if(stats.hasAttribute(ts.statFields[i]) &&
               stats.getAttribute(ts.statFields[i]).trim().length() != 0)
                ts.setStat(i,Integer.parseInt(stats.getAttribute(ts.statFields[i]).trim()));
    }
}
