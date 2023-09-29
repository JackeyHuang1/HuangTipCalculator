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
        double cost = 0;
        double totalCost = cost;
        String[] itemList = new String[groupNum-1];
        int index = 0;

        while (cost != -1) {
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
            cost = scan.nextDouble();
            scan.nextLine();
            totalCost += cost;
            if (cost != -1) {
                System.out.print("Enter the item: ");
                String itemName = scan.nextLine();
                itemList[index] = itemName + ": $" + String.format("%.2f", cost);
                index += 1;
            }
        }
        totalCost += 1;
        double roundedTotalCost = Math.round(totalCost*100.0)/100.0;
        double totalTip = Math.round(roundedTotalCost * tipNum * 0.01 * 100.0) / 100.0;
        double totalAfterTip = Math.round((totalTip + roundedTotalCost)*100.0) / 100.0;
        double personBeforeTip = Math.round((roundedTotalCost / groupNum) * 100.0) / 100.0;
        double personTip = Math.round(totalTip / groupNum * 100.0) / 100.0;
        double totalPersonCost = Math.round((totalTip+ totalCost)/groupNum*100.0)/100.0;

        System.out.println("---------------------------------------");
        System.out.println("Total bill before tip: $" + roundedTotalCost); // learned to round from https://stackoverflow.com/questions/8825209/rounding-decimal-points
        System.out.println("Total percentage: " + tipNum + "%");
        System.out.println("Total tip: $" + totalTip);
        System.out.println("Total bill with tip: $" + totalAfterTip);
        System.out.println("Per person cost before tip: $" + personBeforeTip);
        System.out.println("Tip per person: $" + personTip);
        System.out.println("Total cost per person: $" + totalPersonCost);
        System.out.println("---------------------------------------");
        System.out.println("Items ordered: ");
        for (String orders : itemList) {
            System.out.println(orders);
        }
    }
}