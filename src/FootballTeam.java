import java.util.ArrayList;

public class FootballTeam {
	
	private String teamName;
	private int totalVotes;
	private ArrayList<Integer> voters;
	
	public FootballTeam() {
		
		totalVotes=0;
		voters=new ArrayList<Integer>(100);
		for(int i=0;i<voters.size();i++)
		{
			voters.add(0);
		}

	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getTotalVotes() {
		return totalVotes;
	}
	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
	}
	public ArrayList<Integer> getVoters() {
		return voters;
	}
	public void setVoters(ArrayList<Integer> voters) {
		this.voters = voters;
	}
	
	
	
	

}
