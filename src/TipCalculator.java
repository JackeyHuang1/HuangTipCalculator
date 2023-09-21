// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the tip calculator!");
        System.out.print("How many people are in your group: ");
        int groupNum = scan.nextInt();
        System.out.print("What's the tip percentage? (0-100): ");
        int tipNum = scan.nextInt();
        System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end)");
        double cost = scan.nextDouble();
        double totalCost = cost;

        while (cost != -1) {
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end)");
            cost = scan.nextDouble();
            totalCost += cost;
        }
        totalCost += 1;
        double roundedTotalCost = Math.round(totalCost*100.0)/100.0);
        double totalTip = roundedTotalCost * tipNum * 0.01;

        System.out.println("---------------------------------------");
        System.out.println("Total bill before tip: $" + roundedTotalCost); // learned to round from https://stackoverflow.com/questions/8825209/rounding-decimal-points
        System.out.println("Total percentage: " + tipNum + "%");
        System.out.println("Total tip: $" + totalTip);
        System.out.println("Total bill with tip: $" + (totalTip + totalCost));
        System.out.println("Per person cost before tip: " + (totalCost/ groupNum));
        System.out.println("Tip per person: ");
        System.out.println("What's the tip percentage? (0-100): ");
    }
}