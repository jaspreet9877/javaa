import java.util.Scanner;

public class loanprovider {
    public static void main(String[] args) {
        System.out.println("RPG LOAN PROVIDERS");
        System.out.println("Loan Type\tInterest Rate");
        System.out.println("1. Home Loan\t4.2%");
        System.out.println("2. Car Loan\t3.9%");
        System.out.println("3. Gold Loan\t5.2%");
        System.out.println("4. Study Loan\t2.8%");
        System.out.println("5. Business Loan\t5.8%");
        System.out.println("6. Exit\n");

        Scanner white= new Scanner(System.in);

        System.out.print("Enter your family annual income: $");
        double annualIncome = white.nextDouble();

        if (annualIncome < 80000) {
            System.out.println("You are not eligible to get the loan from RPG Loan Providers.");
        } else {
            System.out.print("\nEnter the loan types you want to select (comma-separated): ");
            String loanTypesInput = white.next();
            String[] loanTypes = loanTypesInput.split(",");

            if (loanTypes.length < 2) {
                throw new IllegalArgumentException("You must select at least two loans.");
            }

            System.out.print("Enter the number of monthly installments (6 to 60 months): ");
            int numInstallments = white.nextInt();

            if (numInstallments < 6 || numInstallments > 60) {
                throw new IllegalArgumentException("Invalid number of monthly installments. It should be between 6 and 60.");
            }

            double overallInterestRate = 0.0;

            System.out.println("\nEnter the loan amount for each loan type:");
            for (String loanType : loanTypes) {
                System.out.print(loanType + " loan amount: $");
                double loanAmount = white.nextDouble();

                if (loanAmount > 500000) {
                    overallInterestRate -= 0.10;
                }

                double interestRate = getInterestRate(loanType);
                overallInterestRate += interestRate;

                double totalLoanAmount = loanAmount + (loanAmount * overallInterestRate);
                double monthlyInstallment = totalLoanAmount / numInstallments;

                System.out.println("Total loan amount to pay: $" + totalLoanAmount);
                System.out.println("Monthly installment amount: $" + monthlyInstallment);
                System.out.println();
            }
        }
    }

    private static double getInterestRate(String loanType) {
        switch (loanType.trim().toLowerCase()) {
            case "1":
            case "home loan":
                return 0.042;
            case "2":
            case "car loan":
                return 0.039;
            case "3":
            case "gold loan":
                return 0.052;
            case "4":
            case "study loan":
                return 0.028;
            case "5":
            case "business loan":
                return 0.058;
            default:
                throw new IllegalArgumentException("Invalid loan type.");
        }
    }
}
