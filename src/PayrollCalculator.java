public class PayrollCalculator {

    public static double calculateWeeklyPay(String type, double hours, double rate) {
        if (hours < 0 || rate < 0) return 0;

        switch (type) {
            case "FULL_TIME":
                return hours <= 40 ? hours * rate : 40 * rate + (hours - 40) * rate * 1.5;
            case "PART_TIME":
                return Math.min(hours, 25) * rate;
            case "CONTRACTOR":
                return hours * rate;
            case "INTERN":
                return Math.min(hours, 20) * rate * 0.8;
            default:
                return 0;
        }
    }

    public static double calculateTaxDeduction(double pay, boolean insurance) {
        double tax;

        if (pay <= 500) tax = pay * 0.10;
        else if (pay <= 1000) tax = pay * 0.15;
        else if (pay <= 2000) tax = pay * 0.20;
        else tax = pay * 0.25;

        if (insurance) tax -= 50;

        return Math.max(tax, 0);
    }

    public static void processPayroll(String[] types, double[] hours, double[] rates, String[] names) {
        int n = Math.min(Math.min(types.length, hours.length), Math.min(rates.length, names.length));

        double highest = -1, lowest = Double.MAX_VALUE, total = 0;
        String highName = "", lowName = "";
        int overtime = 0;

        System.out.printf("%-10s %-12s %-10s %-10s %-10s\n", "Name", "Type", "Hours", "Pay", "Tax");

        for (int i = 0; i < n; i++) {
            double pay = calculateWeeklyPay(types[i], hours[i], rates[i]);
            double tax = calculateTaxDeduction(pay, true);
            System.out.printf("%-10s %-12s %-10.2f %-10.2f %-10.2f\n", names[i], types[i], hours[i], pay, tax);

            if (pay > highest) {
                highest = pay;
                highName = names[i];
            }

            if (pay < lowest) {
                lowest = pay;
                lowName = names[i];
            }

            if (types[i].equals("FULL_TIME") && hours[i] > 40) {
                overtime++;
            }

            total += pay;
        }

        System.out.println();
        System.out.println("Highest: " + highName + " ($" + highest + ")");
        System.out.println("Lowest: " + lowName + " ($" + lowest + ")");
        System.out.printf("Average: $%.2f\n", total / n);
        System.out.println("Overtime count: " + overtime);
    }

    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Omair", "Ahmed", "Omar", "Salim", "Said"};

        processPayroll(types, hours, rates, names);
    }
}
