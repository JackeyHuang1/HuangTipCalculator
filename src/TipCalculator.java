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
        String[] itemList = new String[10000]; // makes an array to save the names of the items entered so they can be printed later, learned from https://www.w3schools.com/java/java_arrays.asp
        int index = 0;

        while (cost != -1) {
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): "); // repeatedly asks for cost and item names until the user enters -1
            cost = scan.nextDouble();
            scan.nextLine();
            totalCost += cost;
            if (cost != -1) {
                System.out.print("Enter the item: ");
                String itemName = scan.nextLine();
                itemList[index] = itemName + ": $" + String.format("%.2f", cost); // changes number to the hundredths, learned from https://stackoverflow.com/questions/2538787/how-to-print-a-float-with-2-decimal-places-in-java#:~:text=In%20short%2C%20the%20%25.,the%20format%20specifier%20(%20%25%20).
                index += 1;
            }
        }

        totalCost += 1;
        String roundedTotalCost = String.format("%.2f", totalCost); // saves the different costs for each situation and saves them to the nearest hundredths
        String totalTip = String.format("%.2f", (totalCost * tipNum * 0.01));
        String totalAfterTip = String.format("%.2f", ((totalCost * tipNum * 0.01) + totalCost));
        String personBeforeTip = String.format("%.2f", (totalCost / groupNum));
        String personTip = String.format("%.2f", ((totalCost * tipNum * 0.01)/ groupNum));
        String totalPersonCost = String.format("%.2f", ((totalCost * tipNum * 0.01) + totalCost) / groupNum);

        System.out.println("---------------------------------------"); // displays all the costs
        System.out.println("Total bill before tip: $" + roundedTotalCost);
        System.out.println("Total percentage: " + tipNum + "%");
        System.out.println("Total tip: $" + totalTip);
        System.out.println("Total bill with tip: $" + totalAfterTip);
        System.out.println("Per person cost before tip: $" + personBeforeTip);
        System.out.println("Tip per person: $" + personTip);
        System.out.println("Total cost per person: $" + totalPersonCost);
        System.out.println("---------------------------------------");
        System.out.println("Items ordered: ");

        for (String orders : itemList) { // prints out the names of the items and stops after the limit of the items is reached
            if (orders != null) {
                System.out.println(orders);
            }
        }
    }
}