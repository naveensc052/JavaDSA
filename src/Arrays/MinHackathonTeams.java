package Arrays;

public class MinHackathonTeams {

	public static int minTeams(int p, int teamSize_1, int teamSize_2) {
        for (int team1 = 0; team1 <= p / teamSize_1; team1++) {
            int remainingParticipants = p - team1 * teamSize_1;
            if (remainingParticipants % teamSize_2 == 0) {
                return team1 + remainingParticipants / teamSize_2;
            }
        }
        return -1;
    }

	  public static void main(String[] args) {
	    int participants = 7;
	    int teamSize1 = 3;
	    int teamSize2 = 4;
	    int minTeams = minTeams(participants, teamSize1, teamSize2);

	    if (minTeams == -1) {
	      System.out.println("No valid division possible.");
	    } else {
	      System.out.println("Minimum number of teams: " + minTeams);
	    }
	  }
	}

