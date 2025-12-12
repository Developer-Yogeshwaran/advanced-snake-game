package com.developer.snakegame;

import java.io.*;

public class HighScoreManager {
    private static final String FILE_NAME = "highscore.txt";

    public static void saveHighScore(int score) {
        int highScore = getHighScore();
        if(score > highScore) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                writer.write(String.valueOf(score));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getHighScore() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine();
            return line == null ? 0 : Integer.parseInt(line);
        } catch (IOException | NumberFormatException e) {
            return 0;
        }
    }
}
