package org.example.ServiceLayer;

import org.example.Dtos.DiesRequestDto;
import org.example.Dtos.PlayersRequestDto;
import org.example.Entities.Win;
import org.example.Repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GameServiceImp implements GameService {

    @Autowired
    private GameRepository gameRepository;

     private String playerOne=null;
     private String playerTwo=null;
    Map<String, Integer> playerDiesMapping=new HashMap<>();
    Map<String, Integer> playerselection=new HashMap<>();
    public void addPlayerInGame(PlayersRequestDto playersRequestDto){
        List<String> playersList=playersRequestDto.getPlayersList();
        if(playersList.size()!=2)throw new RuntimeException("Invalid Number of players");

        for (String st: playersList) {
            if( st==null || st.length()==0 ) throw new RuntimeException("Name Is Empty");
            playerDiesMapping.put(st, 0);
            playerselection.put(st,0);
            if(playerOne==null){
                playerOne=st;
            }
            else{
                playerTwo=st;
            }

        }
    }

    public String rollTheDies(DiesRequestDto diesRequestDto){
        int dies=diesRequestDto.getDies();
        int diesVal=dies;
        String player=diesRequestDto.getPlayerName();

        if(playerselection.get(playerTwo)<playerselection.get(playerOne)){
            if(player.equals(playerOne))
                throw new RuntimeException("Invalid move, plz give a chance to "
                        +playerTwo+" No of chances  you & player2 -> " +playerselection.get(player)
                        +" "+playerselection.get(playerOne)
                        );
        }
        else if(player.equals(playerTwo)){
            throw new RuntimeException("Invalid move, plz give a chance to "
                    +playerOne+" No of chances  you & player2 -> " +playerselection.get(player)
                    +" "+playerselection.get(playerOne));

        }
            playerselection.put(player, playerselection.get(player) + 1);


        if(dies<1 || dies>6)
            throw new RuntimeException("Tne number you enter is not considered, Plz give from 1 to 6 ");

        if(!playerDiesMapping.containsKey(player)){
            throw new RuntimeException("Invalid player, The player you enter is not in game");
        }
        int prev=playerDiesMapping.get(player);
         dies=playerDiesMapping.get(player)+dies;
        if(gameRepository.containsSnake(dies)){
            dies=gameRepository.snakeBite(dies);
        }

        if(gameRepository.containsLadder(dies)){
            dies=gameRepository.climbLabber(dies);
        }
        playerDiesMapping.put(player,dies);
        String st= player +" rolled a "+diesVal+" and moved from "+prev+" to "+dies;

        gameRepository.saveHistroy(st);


        Integer ans=playerDiesMapping.get(player);

        if(ans==100){
            String data= gameRepository.getWinData();
            data=data+player+" wins the game";
            return data;
        }

        return ans.toString();

    }
}
