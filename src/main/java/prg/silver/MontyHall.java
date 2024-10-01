package prg.silver;

import java.util.HashMap;
import java.util.Random;

public class MontyHall {
    private int DOOR_COUNT = 3;
    private int WIN_DOOR = 1;
    private Random random;

    public MontyHall() {
        random = new Random();
    }

    public int chooseDoor() {
        return random.nextInt(DOOR_COUNT) + 1;
    }


    public int openDoor(int chosenDoor) {
        int openedDoor;
        do {
            openedDoor = chooseDoor();
        } while (openedDoor == chosenDoor || openedDoor == WIN_DOOR);
        return openedDoor;

    }


    public int switchDoor(int chosenDoor, int openedDoor) {
        int newDoor;
        do {
            newDoor = chooseDoor();

        } while (newDoor == chosenDoor || newDoor == openedDoor);

        return newDoor;

    }


    public HashMap<Boolean, Integer> playGame(int numIterations) {

        HashMap<Boolean, Integer> result = new HashMap<>();
        for (int i = 0; i < numIterations; i++) {
            int chosenDoor = chooseDoor();
            int openedDoor = openDoor(chosenDoor);
            int switchedDoor = switchDoor(chosenDoor, openedDoor);

            if (switchedDoor == WIN_DOOR) {
                int win = result.containsKey(true) ? result.get(true) + 1 : 1;
                result.put(true, win);
            } else {
                int lost = result.containsKey(false) ? result.get(false) + 1 : 1;
                result.put(false, lost);
            }
        }
        return result;
    }

}

