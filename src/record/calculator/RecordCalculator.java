
package record.calculator;

import java.util.Scanner;

/**
 *
 * @author Bryce Doyle
 * @since 3/19/2022
 * 
 */
public class RecordCalculator {

    
    private static int inputValidation(String prompt)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println(prompt);
        while (!(scan.hasNextInt()))
        {
            System.out.println("That is not an integer! Please enter an integer.");
            scan.nextLine();
        }
        
        int valid = scan.nextInt();
        scan.close();
        
        return valid;
    }
    
    private static double calculateRecord(int win, int loss)
    {
        int total = win + loss;
        double record = (double) win / total * 100;
        
        return record;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int option;
        int win;
        int loss;
        int winThisWeek;
        int lossThisWeek;
        double record;
                
        win = inputValidation("Enter the amount of wins:");
        loss = inputValidation("Enter the amount of losses:");
        option = inputValidation("What would you like to do?\n1 --> Calculate Current Record\n2 --> Add Wins and Losses To a Record and Calculate Record");
        
        if (option == 2)
        {
            winThisWeek = inputValidation("Enter the amount of wins you want to add.");
            win = win + winThisWeek;
            lossThisWeek = inputValidation("Enter the amount of losses you want to add.");
            loss = loss + lossThisWeek;
        }
                
        record = calculateRecord(win, loss);
        System.out.printf("Your team is %d-%d with a percentage of %.2f%%\n", win, loss, record);
    }
    
}
