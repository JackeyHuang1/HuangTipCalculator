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
        String[] itemList = new String[10000];
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
        String roundedTotalCost = String.format("%.2f", totalCost);
        String totalTip = String.format("%.2f", (totalCost * tipNum * 0.01));
        String totalAfterTip = String.format("%.2f", ((totalCost * tipNum * 0.01) + totalCost));
        String personBeforeTip = String.format("%.2f", (totalCost / groupNum));
        String personTip = String.format("%.2f", ((totalCost * tipNum * 0.01)/ groupNum));
        String totalPersonCost = String.format("%.2f", ((totalCost * tipNum * 0.01) + totalCost) / groupNum);

        System.out.println("---------------------------------------");
        System.out.println("Total bill before tip: $" + roundedTotalCost);
        System.out.println("Total percentage: " + tipNum + "%");
        System.out.println("Total tip: $" + totalTip);
        System.out.println("Total bill with tip: $" + totalAfterTip);
        System.out.println("Per person cost before tip: $" + personBeforeTip);
        System.out.println("Tip per person: $" + personTip);
        System.out.println("Total cost per person: $" + totalPersonCost);
        System.out.println("---------------------------------------");
        System.out.println("Items ordered: ");

        for (String orders : itemList) {
            if (orders != null) {
                System.out.println(orders);
            }
        }
    }
}