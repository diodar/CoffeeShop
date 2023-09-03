package app;

import java.util.Scanner;

import static app.CoffeeMachine.*;

public class MakeOrder {

    static Scanner sc = new Scanner(System.in);
    int espressoTotalCost = 0;
    int cappucinoTotalCost = 0;
    int latteTotalCost = 0;
    int espressoNum = 0;
    int cappucinoNum = 0;
    int latteNum = 0;

    public CoffeeMachine userDrinkChoice() {

        System.out.println("\033[4m" + "ОБЕРІТЬ БУДЬ ЛАСКА НАПІЙ ТА ВКАЖІТЬ КІЛЬКІСТЬ:" + "\033[0m");
        System.out.print("Назва напою: ");

        try {
            String drinksChoice = sc.nextLine();
            String capsDrinkChoice = drinksChoice.toUpperCase();
            return CoffeeMachine.valueOf(capsDrinkChoice);
        } catch (IllegalArgumentException e) {
            System.err.println("Нема такого напою в списку. Спробуйте ще раз:");
            return userDrinkChoice();
        }
    }

    public void userDrinkSwitcher(CoffeeMachine drink, int quantity) {
        switch (drink) {
            case ESPRESSO -> {
                int i = 1;
                do {
                    ESPRESSO.make();
                    espressoTotalCost += ESPRESSO.cost;
                    i++;
                } while (i <= quantity);
                espressoNum += quantity;
            }
            case CAPPUCINO -> {
                int i = 1;
                do {
                    CAPPUCINO.make();
                    cappucinoTotalCost += CAPPUCINO.cost;
                    i++;
                } while (i <= quantity);
                cappucinoNum += quantity;
            }
            case LATTE -> {
                int i = 1;
                do {
                    LATTE.make();
                    latteTotalCost += LATTE.cost;
                    i++;
                } while (i <= quantity);
                latteNum += quantity;
            }
            default -> System.out.println("Нема такого напою: " + drink);
        }
    }

    public static int userNumChoice() {
        System.out.print("Кількість: ");
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Некорректне введення. Спробуйте ще раз.");
            return userNumChoice();
        }
    }

    public void getTotalCost() {
        int needToPay = espressoTotalCost + cappucinoTotalCost + latteTotalCost;
        System.out.println();
        System.out.println("Дякуємо, що скористалися нашим онлайн-баром");
        System.out.println("\033[4m" + "ВИ ЗАМОВИЛИ:" + "\033[0m" + "\n" +
                ESPRESSO + " - " + espressoNum + "\n" +
                CAPPUCINO + " - " + cappucinoNum + "\n" +
                LATTE + " - " + latteNum + "\n" +
                "\033[4m" + "ВСЬОГО ДО СПЛАТИ: " + needToPay + " грн" + "\033[0m");
        sc.close();
    }

    public void userMakeChoice() {

        String question = sc.nextLine().toUpperCase();

        if (question.equals("N")) {
            getTotalCost();
            return;
        }
        if (question.equals("Y")) {
            userDrinkSwitcher(userDrinkChoice(), userNumChoice());
            System.out.print("Бажаєте замовити щось ще? (Y/N): ");
            userMakeChoice();
        } else {
            System.out.println("Некорректне введення. Спробуйте ще раз.");
            userMakeChoice();
        }
    }
}
