/*Author:  Nishigandha*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class ObserverPatternTest {
	
	public static void main(String[] args) {
		
		String teamName="";
		ArrayList<FootballTeam> footballTeams=new ArrayList<FootballTeam>();          //create an arraylist of football teams
		ArrayList<String> APLAtimes = new ArrayList<String>();     //create an array list for teams voted at AP polls displayed by LA times
		ArrayList<String> APESPN = new ArrayList<String>();       //create an array list for teams voted at AP polls displayed by ESPN
		ArrayList<String> USATodayLAtimes = new ArrayList<String>();  //create an array list for teams voted at USAToday polls displayed by LA times
		ArrayList<String> USATodayESPN = new ArrayList<String>(); //create an array list for teams voted at USAToday polls displayed by ESPN
     
		
		try {
			Scanner input=new Scanner(new File("teams.txt"));                 //input file 
			
			while(input.hasNext())
			{
				teamName=input.next();
				FootballTeam team=new FootballTeam();
				team.setTeamName(teamName);             //set the football team name from the text file
				footballTeams.add(team);                          //arraylist of teams is created
				
			}
			input.close();
			
			LATimesSubscriber LAtimes=new LATimesSubscriber();           //created object of subscriber1
			
			ESPNSubscriber espn=new ESPNSubscriber();                    //created object of subscriber2
			
			
			AssociatedPressPolls APpolls=new AssociatedPressPolls(footballTeams);
			
			USATodayPolls USTodaypolls=new USATodayPolls(footballTeams);
			
			System.out.println("\t\t LA Times \t\t\t\t\t\t ESPN\n");
			
			System.out.print("AP \t\t\t USAToday \t\t\t");
			System.out.print("\t AP \t\t\t USAToday");
			System.out.print("\n\n");
			
			APpolls.register(LAtimes);              //register subscriber 1
			APpolls.register(espn);                 //register subscriber 2
			 
			APpolls.dataISChanged();
			
			Iterator<FootballTeam> iterator = footballTeams.iterator();
			
			while(iterator.hasNext())
			{
				String teams=iterator.next().getTeamName();
				APLAtimes.add(teams);
				APESPN.add(teams);
			}
			
			USTodaypolls.register(LAtimes);	
            USTodaypolls.register(espn);
             
        	USTodaypolls.dataISChanged();
        	
        	Iterator<FootballTeam> iterator1 = footballTeams.iterator();
        	
        	while(iterator1.hasNext())
			{
				String teams=iterator1.next().getTeamName();
				USATodayLAtimes.add(teams);
				USATodayESPN.add(teams);
			}
			
			for(int i=0;i<footballTeams.size();i++)
			{
				
				System.out.format("%-20s",+ i+1 + "." + APLAtimes.get(i));
				
			
				System.out.format("\t%-20s", i+1 + "." + USATodayLAtimes.get(i));
				
				
         	     System.out.format("\t\t\t%-20s", i+1 + "." + APESPN.get(i));
					
				System.out.format("\t%-20s", i+1 + "." + USATodayESPN.get(i));
				System.out.print("\n");
	             
			}
			
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}

}


