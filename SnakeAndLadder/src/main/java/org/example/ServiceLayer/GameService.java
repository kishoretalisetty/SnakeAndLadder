package org.example.ServiceLayer;

import org.example.Dtos.DiesRequestDto;
import org.example.Dtos.PlayersRequestDto;

public interface GameService {
    void addPlayerInGame(PlayersRequestDto playersRequestDto);
     String rollTheDies(DiesRequestDto diesRequestDto);
}
