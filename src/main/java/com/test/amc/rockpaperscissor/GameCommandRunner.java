package com.test.amc.rockpaperscissor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class GameCommandRunner implements CommandLineRunner {

    private GamePlayService gamePlayService;

    @Autowired
    public GameCommandRunner (GamePlayService gamePlayService) {
        this.gamePlayService = gamePlayService;
    }

    private static Logger logger = LoggerFactory
            .getLogger(GameCommandRunner.class);

    @Override
    public void run(String... args) throws Exception {
        int playAgain = 0;
        while (playAgain != 9) {
        System.out.println("Enter number of games to play>");
        Scanner input = new Scanner(System.in);
        String numberOfGames = input.nextLine();
        try{
            gamePlayService.setInitialNumberOfGames(Integer.parseInt(numberOfGames));
            while (gamePlayService.gameOn()) {
                System.out.println("Computer made a pick>");
                System.out.println("Take your pick, Select '1' for Rock - '2' for Paper - '3' for Scissor");
                String userSelect = input.nextLine();
                String winner = gamePlayService.getGameResults(Integer.parseInt(userSelect));
                System.out.println(winner);
            }
            System.out.println("Aggregate result; Computer wins - "+ gamePlayService.getComputerWins() +" Your wins - "+ gamePlayService.getUserWins());
            System.out.println("Play again ? Press 1 to play again; press 9 to exit");
            playAgain = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException numExc) {
            throw new IllegalArgumentException("Invalid input received, please enter Integer number values");
        }
        }

    }

}
