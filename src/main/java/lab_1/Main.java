package lab_1;

import lab_1.moving_strategies.*;

import java.util.Arrays;

public class Main {
    private static final Hero king = new Hero("King", new MovingStrategyWalking());
    private static final Hero villain = new Hero("Villain", new MovingStrategyRunning());
    private static final Hero hero = new Hero("Hero", new MovingStrategyNone());

    public static void printInfo () {
        System.out.println("========================================");
        System.out.println("Start positions:");
        System.out.println("========================================");
        System.out.println(king);
        System.out.println(villain);
        System.out.println(hero);

        System.out.println("========================================");
        System.out.println("Actions:");
        System.out.println("========================================");
        System.out.println("0 - exit");
        System.out.println("1 - do not move");
        System.out.println("2 - walk");
        System.out.println("3 - run");
        System.out.println("4 - move by horse");
        System.out.println("5 - move by plane");
        System.out.println("========================================");
    }

    public static void main(String[] args) {
        if (Arrays.stream(args).toList().contains("--info")) {
            printInfo();
            System.exit(0);
        }

        if (args.length == 0) {
            System.out.println("Please enter your actions as string as first argument to the program.");
            System.exit(1);
        }

        System.out.println("========================================");

        String moves = args[0];

        for_cycle:
        for (int i = 0; i < moves.length(); i++) {
            System.out.print("Your turn. Choose action: ");
            char command = moves.charAt(i);
            System.out.println(command);

            switch (command) {
                case '0':
                    break for_cycle;
                case '1':
                    hero.setMovingStrategy(new MovingStrategyNone());
                    break;
                case '2':
                    hero.setMovingStrategy(new MovingStrategyWalking());
                    break;
                case '3':
                    hero.setMovingStrategy(new MovingStrategyRunning());
                    break;
                case '4':
                    hero.setMovingStrategy(new MovingStrategyOnHorse());
                    break;
                case '5':
                    hero.setMovingStrategy(new MovingStrategyFlying());
                    break;
                default:
                    System.out.println("Unknown action: " + command + ".");
                    System.exit(1);
            }

            System.out.println("========================================");
            System.out.println("Everyone moved:");

            king.move();
            villain.move();
            hero.move();

            System.out.println(king);
            System.out.println(villain);
            System.out.println(hero);
        }

        System.out.println("========================================");
    }
}
