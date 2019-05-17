//author: Nishigandha

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class USATodayPolls implements Subject
{
	private ArrayList<Observer> observers;              //list of subscribers
	private int numberOfVoters=50;
	private ArrayList<FootballTeam> footballTeams;         //array of teams
	
	public USATodayPolls(ArrayList<FootballTeam> teams) {
		
        this.observers = new ArrayList<Observer>();                //create arraylist of subscribers
		
		this.footballTeams=teams;
		
	}
	
	  
	// This method is called whenever data changes
	
	    public void dataISChanged() {
	    	
	    	//get latest data
	    	Random rand=new Random();                    //create random number between 1 to 25 
			int min=1;
			int max=25;
			int totalVotes=0;
			int currentValue=0;
			
			
	    	for(int i=1;i<=numberOfVoters;i++)            //loop until number of voters
	    		{
	    		int num=rand.nextInt(max-min)+min;       //voter will randomly pick up the team to vote
	    		
	    		FootballTeam team=footballTeams.get(num-1);  //get the football team object based on the number picked by the voter
	    		team.getVoters().add(i);                      //insert the voter number to the arraylist inorder to calculate the total votes
	    		
	    				
	    	}
	    	
	    	Iterator<FootballTeam> iterator = footballTeams.iterator();  //iterator for football teams arraylist
	    	
	    	while(iterator.hasNext())
	    	{
	    		totalVotes=0;
	    		currentValue=0;
	    		FootballTeam team=iterator.next();                      //get the football team object
	    		Iterator<Integer> it=team.getVoters().iterator();       //iterator for the voters arraylist to calculate the total votes
				while(it.hasNext())
				{
					currentValue=it.next();
					
					totalVotes=totalVotes+(26-currentValue);                //calculate total votes for each teams given by the formaula in problem
					
				}
				team.setTotalVotes(totalVotes);
				//System.out.println("TotalVotes for team "+team.getTeamName()+" is "+team.getTotalVotes());
	    	}
	    	
	    	//sorting an array based on the total votes
	    	
	    	Collections.sort(footballTeams, new FootballTeamComparator());   //use of comparator to compare the total votes of various teams
	  
	        notifyObservers();                                //after the teams are sorted, notify the updated list to the registered subscribers
	    	
	    }

	@Override
	public void register(Observer ob) {                  //register the subscribers
		if(ob == null)
		    throw new NullPointerException("Null observer");
		if(!observers.contains(ob))
			observers.add(ob);
		
	}

	@Override
	public void unregister(Observer ob) {                 //unregister the subscribers
		observers.remove(observers.indexOf(ob));
		
	}

	@Override
	public void notifyObservers() {                       //notify the observers or subscribers
		for (Iterator<Observer> it = 
	              observers.iterator(); it.hasNext();) 
	        { 
	            Observer ob = it.next();
	            ob.update(footballTeams);   //pass sorted list
	            
	        } 
		
	
		
	}

}
