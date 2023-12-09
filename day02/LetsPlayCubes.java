package day02;

import java.nio.file.Files;
import java.nio.file.Path;

public class LetsPlayCubes {

    private String challengeInput;

    public LetsPlayCubes(){
        try {
            Path filePath = Path.of("/Users/A59508662/Documents/aoc/day02/aoc2.txt");
            this.challengeInput = Files.readString(filePath);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void checkGameRounds() {
        int possibleGamesIndexSum = 0;
        for (String Round : challengeInput.split("\n")) {
            var splitedRound = Round.split(":");
            if(isRoundPossible(splitedRound[1])) {
                possibleGamesIndexSum += Integer.parseInt(splitedRound[0].split(" ")[1]);
            }
        }
        System.out.println("Possible games: " + possibleGamesIndexSum);
    }

    private boolean isRoundPossible(String Round) {
        boolean possible = true;

        for(String BagPull : Round.split((";"))) {
            var splitedCubes = BagPull.split(",");
            
            for(String ColoredCube : splitedCubes) {
                if(ColoredCube.contains("green") && Integer.parseInt(ColoredCube.stripLeading().split(" ")[0]) > 13)
                    possible = false;
                if(ColoredCube.contains("red") && Integer.parseInt(ColoredCube.stripLeading().split(" ")[0]) > 12)
                    possible = false;
                if(ColoredCube.contains("blue") && Integer.parseInt(ColoredCube.stripLeading().split(" ")[0]) > 14)
                    possible = false;
            }
        }

        return possible;
    }

    public static void main(String[] args) {
        LetsPlayCubes play = new LetsPlayCubes();
        play.checkGameRounds();
    }
}
