package org.example.Dtos;

import lombok.Data;
import lombok.NonNull;

@Data
public class DiesRequestDto {

   @NonNull
   Integer dies;

   @NonNull
   String playerName;
}
