package com.test.amc.rockpaperscissor;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class GamePlayService {

    private int DEFAULT_NUMBER_OF_GAMES = 5;
    private int RANDOM_INT_GEN_BOUND = 3;
    private int RANDOM_INT_GEN_CONSTANT = 1;

    private AtomicInteger initialNumberOfGames = new AtomicInteger(DEFAULT_NUMBER_OF_GAMES);
    private AtomicInteger gameCounter = new AtomicInteger(0);
    AtomicInteger computerWins = new AtomicInteger(0);
    AtomicInteger userWins = new AtomicInteger(0);

    public void setInitialNumberOfGames(int numberOFGamesToPlay) {
        initialNumberOfGames.set(numberOFGamesToPlay);
        gameCounter.set(numberOFGamesToPlay);
        computerWins.set(0);
        userWins.set(0);
    }
    public boolean gameOn() {
        if(gameCounter.get() > 0 && (computerWins.get() < Math.round((double) initialNumberOfGames.get()/2) && userWins.get() < Math.round((double) initialNumberOfGames.get()/2)) ) {
            gameCounter.decrementAndGet();
            return true;
        }
        return false;
    }

    public String getGameResults(int userSelect) {
        String result;
        RockPaperScissor computerPick = computerPick();
        RockPaperScissor userPick = RockPaperScissor.valueOf(userSelect);
        if (computerPick.equals(userPick)) {
            result = "Its a tie!";
        } else if (computerPick.beats(userPick)) {
            result = "You loose!";
            computerWins.incrementAndGet();
        } else {
            result = "You win!";
            userWins.incrementAndGet();
        }
        return result + "- - Computer pick was - " + computerPick.toString();
    }

    public int getComputerWins() {
        return computerWins.get();
    }

    public int getUserWins() {
        return userWins.get();
    }

    RockPaperScissor computerPick() {
        int randomValue = generateRandomIntBt1And3();
        return RockPaperScissor.valueOf(randomValue);
    }

    private int generateRandomIntBt1And3() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(RANDOM_INT_GEN_BOUND) + RANDOM_INT_GEN_CONSTANT;
    }
}
