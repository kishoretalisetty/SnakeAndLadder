package org.example.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
//@AllArgsConstructor
public class PlayersRequestDto {
    @NonNull
    List<String> playersList=new ArrayList<>();
}
