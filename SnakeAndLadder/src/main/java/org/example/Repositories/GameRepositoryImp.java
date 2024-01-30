package org.example.Repositories;

import org.example.Entities.Board;
import org.example.Entities.Win;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRepositoryImp implements GameRepository{

    @Autowired
    private Board board;

    @Autowired
    private Win win;

    @Override
    public boolean containsSnake(Integer n) {
//        if(board.getSnakes().isEmpty()){
//            board.loadData();
//        }

      return  board.getSnakes().containsKey(n);
    }
    @Override
   public  int snakeBite(Integer n){
        return board.getSnakes().get(n);
    }
    @Override
   public  boolean containsLadder(Integer n){
//        if(board.getLadders().isEmpty()){
//            board
//        }
       return board.getLadders().containsKey(n);
    }
    @Override
    public int climbLabber(Integer n){
        return board.getLadders().get(n);
    }

    @Override
    public void saveHistroy(String result){
        win.getGameData().add(result);
    }

    public String getWinData(){
       return  win.printGameDate();
    }


}
