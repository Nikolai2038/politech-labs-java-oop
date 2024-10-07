package lab_1;

import lab_1.moving_strategies.MovingByCar;
import lab_1.moving_strategies.MovingByHorse;
import lab_1.moving_strategies.MovingByPlane;

public class Main {
    public static void main(String[] args) {
        Hero king = new Hero("King", new MovingByHorse());
        Hero hero = new Hero("Hero", new MovingByCar());
        Hero villain = new Hero("Villain", new MovingByPlane());

        System.out.println("========================================");
        System.out.println("Start positions:");
        System.out.println("========================================");
        System.out.println(king);
        System.out.println(hero);
        System.out.println(villain);

        king.move();
        hero.move();
        villain.move();

        System.out.println("========================================");
        System.out.println("Everyone moved:");
        System.out.println("========================================");
        System.out.println(king);
        System.out.println(hero);
        System.out.println(villain);
        System.out.println("========================================");
    }
}
