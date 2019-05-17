//author: Nishigandha

import java.util.ArrayList;


public class LATimesSubscriber implements Observer{

	private ArrayList<FootballTeam> footballTeams;
	
	@Override
	public void update(ArrayList<FootballTeam> updatedTeams) {
		this.footballTeams=updatedTeams;
		
		
		
	} 
  
}
