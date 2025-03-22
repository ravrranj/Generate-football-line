import java.util.*;
import java.util.Scanner;;

public class arrangeKids {

    public static void arrangeKids(int [] kids, List<integer> currentArrangement, boolean[] used, List<List<integer>> result) {

        //base case : if the current arrangement has all kids , add to result
        if(currentArrangement.size() == kids.length) {
            result.add(new ArrayList<>(currentArrangement));
            return;
        }

        // Try placing each kid in the arrangement
        for (int i = 0; i < kids.length; i++) {
            if (!used[i]) { //if the kid is not already placed
                used[i] = true;  // Mark the kid as used
                currentArrangement.add(kids[i]) ; // Place the kid

                arrangeKids(kids, currentArrangement, used, result); // Recursion for next position
            
                //backtrack
                used[i] = false;
                currentArrangement.remove(currentArrangement.size() - 1);

            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        //taking input for number of kids
        System.out.print("Kids present : ");
        int N = sc.nextInt();

        int[] kids = new int[N];  //Array to store kids numbers

        // Taking input for kids IDs (or numbers)
        System.out.println("Enter the kids numbers: ");
        for (int i = 0; i < N; i++) {
            kids[i] = sc.nextInt();
        }
        
        //Printing the input to confirm it's correct
        System.out.println("Kids: " + Arrays.toString(kids));
        
        sc.close();
    }
}