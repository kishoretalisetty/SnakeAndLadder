package org.example.Repositories;

public interface GameRepository {
    boolean containsSnake(Integer n);
    int snakeBite(Integer n);

    boolean containsLadder(Integer n);
    int climbLabber(Integer n);

    void saveHistroy(String result);

    String getWinData();
}
