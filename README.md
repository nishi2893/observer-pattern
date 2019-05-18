# Observer Pattern

College football rankings are determined by many polls. The two most influential are the Associated Press (AP) and USA Today polls. Each poll has a number of registered voters. Each week during the college football season the voters cast their ballot via computer and when all the ballots have been received, the polls are tabulated and the teams ranked. After the polls are tabulated, the AP and USA Today notify all their subscribing members (newspapers, sports magazines, online services, TV sports) and the subscribers receive the latest polls on Sunday afternoons. 

In this program, the voting process has been implemented with the use of observer design pattern. The voters will be limited to 100. Each voter shall implement a randomized voting process for 25 teams. Randomly ascribe a number between 1 and 25, without duplication, to each team. Only one team can be #1, #2, et cetera, for each voter. Sixty of the voters must be assigned to the AP poll and the sixty to the USA Today poll.  Twenty voters belong to both polls.

After each poll has received all their votes, have the poll count the votes by simply subtracting each team’s vote from 26 and adding the result to a total for the team.  For example, if a subset of voters voted for UCLA as #1, #9, #10 and #12, the vote would sum 26-1 + 26-9 + 26-10 + 26 – 12 = 72. After all tabulations are done, sort the teams from high to lowest totals. This is the weekly poll. Notify all subscribers. 

The subscribers all subscribe to both polls. After each subscriber has received both polls, they should update their respective displays. The subscriber display is the output of the program.

## What I used?

- Java
- Observer design pattern



