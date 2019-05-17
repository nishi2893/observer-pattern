//author: Nishigandha

import java.util.Comparator;

public class FootballTeamComparator implements Comparator<FootballTeam>
{

	@Override
	public int compare(FootballTeam o1, FootballTeam o2) {
		
		Integer votesTeam1=new Integer(o1.getTotalVotes());
		Integer votesTeam2=new Integer(o2.getTotalVotes());
		return votesTeam2.compareTo(votesTeam1);             //here it will compare the total votes of all the teams 
		                                                     //so that the teams are displayed from highest total votes to lowest total votes 
	}

}
