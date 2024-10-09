package lab_1;

import lab_1.moving_strategies.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hero king = new Hero("King", new MovingStrategyWalking());
        Hero villain = new Hero("Villain", new MovingStrategyRunning());
        Hero hero = new Hero("Hero", new MovingStrategyNone());

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

        Scanner scanner = new Scanner(System.in);
        while_cycle:
        while (true) {
            System.out.print("Your turn. Choose action: ");
            String command = scanner.nextLine();

            switch (command) {
                case "0":
                    break while_cycle;
                case "1":
                    hero.setMovingStrategy(new MovingStrategyNone());
                    break;
                case "2":
                    hero.setMovingStrategy(new MovingStrategyWalking());
                    break;
                case "3":
                    hero.setMovingStrategy(new MovingStrategyRunning());
                    break;
                case "4":
                    hero.setMovingStrategy(new MovingStrategyOnHorse());
                    break;
                case "5":
                    hero.setMovingStrategy(new MovingStrategyFlying());
                    break;
                default:
                    System.out.println("Unknown action: " + command + ". Try again.");
                    continue;
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
