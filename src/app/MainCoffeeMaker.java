package app;

public class MainCoffeeMaker {

    public static void main(String[] args) {

        MakeOrder order = new MakeOrder();

        System.out.println("\033[4m" + "ВІТАЄМО ВАС У НАШІЙ КАВ'ЯРНІ =)" + "\033[0m" + "\n");
        System.out.print("""
                Ознайомтесь з нашою барною картою:
                ESPRESSO, CAPPUCINO, LATTE
                """);
        System.out.print("\n" + "Бажаєте щось замовити? (Y/N): ");

        order.userMakeChoice();
    }
}