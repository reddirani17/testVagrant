package stepDefinitions;

import io.cucumber.java.en.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

public class RCBsteps {
	
	JSONObject jsonObject;
	JSONObject jsonChildObject;
	
	@Given("Json file contains RCB team details is loaded")
	public void json_file_contains_rcb_team_details_is_loaded() throws IOException, ParseException {
		JSONParser parser = new JSONParser();   
        Object obj = parser.parse(new FileReader(System.getProperty("user.dir")+"/src/test/resources/testData/RCBTeamDetails.json"));
        jsonObject =  (JSONObject) obj;
	}

	@Then("Team should have only x {int} foreign players")
	public void team_should_have_only_x_foreign_players(Integer int1) {
		Integer foreignPlayerCount=0;
		JSONArray players = (JSONArray) jsonObject.get("player");
		@SuppressWarnings("rawtypes")
		Iterator it = players.iterator();
		while(it.hasNext()) {
			JSONObject json = (JSONObject) it.next();
			String country = (String) json.get("country");
			if(!country.equalsIgnoreCase("India"))
				foreignPlayerCount++;			
		}
		Assert.assertEquals(int1, foreignPlayerCount);
		
	}

	@Then("Team should have at least y {int} wicket players")
	public void team_should_have_at_least_y_wicket_players(Integer int1) {
		Integer wktPlayerCount=0;
		JSONArray players = (JSONArray) jsonObject.get("player");
		@SuppressWarnings("rawtypes")
		Iterator it = players.iterator();
		while(it.hasNext()) {
			JSONObject json = (JSONObject) it.next();
			String role = (String) json.get("role");
			if(role.equalsIgnoreCase("Wicket-keeper"))
				wktPlayerCount++;			
		}
		if(wktPlayerCount>1)
		Assert.assertTrue((wktPlayerCount>1));
	}

}
