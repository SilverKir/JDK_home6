package prg.silver;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
MontyHall game= new MontyHall();
int iterationsCount=1000;
 HashMap<Boolean,Integer> result = game.playGame(iterationsCount);
 int initialChoice=(result.get(false)*100/iterationsCount);
        System.out.println("Вероятность выигрыша при первоначальном выборе равна: " + initialChoice  +" %");
        System.out.println("Вероятность выигрыша при изменении мнения: " + (100 - initialChoice) +" %");
        }
    }
