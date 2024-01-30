package org.example.MainController;

import org.example.Dtos.DiesRequestDto;
import org.example.Dtos.PlayersRequestDto;
import org.example.ServiceLayer.GameService;
import org.example.ServiceLayer.GameServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Controller {

    @Autowired
    private GameService gameService;

    @PostMapping("/addPlayers")
    public @ResponseBody String addPlayers(@RequestBody PlayersRequestDto playersRequestDto) {
        gameService.addPlayerInGame(playersRequestDto);
        return "Players Added";
    }

    @PostMapping("/rollTheDies")
    public @ResponseBody String rollTheDies(@RequestBody DiesRequestDto diesRequestDto){
        return gameService.rollTheDies(diesRequestDto);
    }

}
