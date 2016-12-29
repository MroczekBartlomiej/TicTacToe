package org.bmroczek;

import org.bmroczek.GUI.GameInConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToeApplication implements CommandLineRunner {

    @Autowired
    GameInConsole gameInConsole;

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        gameInConsole.game();
    }
}
