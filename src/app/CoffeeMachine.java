package app;

public enum CoffeeMachine implements Drinks {

    ESPRESSO(50) {
        @Override
        public void make() {
            System.out.println("Your ESPRESSO. Enjoy :)");
        }
    },
    CAPPUCINO(60) {
        @Override
        public void make() {
            System.out.println("Your CAPPUCINO. Enjoy :)");
        }
    },
    LATTE(70) {
        @Override
        public void make() {
            System.out.println("Your LATTE. Enjoy :)");
        }
    };

    final int cost;

    CoffeeMachine(int cost) {
        this.cost = cost;
    }
}