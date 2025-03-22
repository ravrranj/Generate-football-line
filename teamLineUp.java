import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class teamLineUp {

    //Define roles
    static String[] roles = { "Captain", "Vice-Captain", "Striker", "Midfielder", "Defender"};

    public static void generateLineups(String[] players, List<String> lineup, boolean[] used, List<List<String>> result ) {

    //Base case : if all players are in lineup, add it to the result
    if(lineup.size() == players.length) {
        result.add(new ArrayList<>(lineup));
        return;
    }

    //try placing each player in the lineup
    for (int i = 0 ; i < players.length; i++) {
        if (!used[i])  {  // If the player is not already placed 
            used[i] = true; //Mark the player as used 
            lineup.add(players[i]); //Place the player
        
            generateLineups(players, lineup, used, result); // Recursion for the next position

            //Backtrack 
            used[i] = false;
            lineup.remove(lineup.size() - 1);
        }
      }
    }

    public static void main(String args[]){
    Scanner sc = new Scanner(System.in) ;

    //Input number of players
    System.out.print("Enter number of players: ");
    int N = sc.nextInt();
    sc.nextLine(); //Consume the new line chararcter

    String[] players = new String[N]; //Array to store players names

    // Input player names
    System.out.println("Enter the names of the players : ");
    for (int i = 0; i < N; i++) {
        players[i] = sc.nextLine();
    }

    List<List<String>> result = new ArrayList<>();
    generateLineups(players, new ArrayList<>(), new boolean[N], result);

    //Print all possible team lineups with assigned rolses
    System.out.println("\nPossible team lineups with roles : ");
    for(List<String> lineup : result) {
        System.out.println(lineup);
        for ( int i = 0 ; i < lineup.size(); i++) {
            String role = (i < roles.length) ? roles[i] : "Player " + (i + 1);
            System.out.println(role + ":" + lineup.get(i));
        }
        System.out.println("---------------------------");
    }
     sc.close();
    }
}