package org.example.Entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Data
public class Board {
    Board(){
        this.loadData();
    }
    private Map<Integer, Integer> snakes=new HashMap<>();
    private Map<Integer, Integer> ladders=new HashMap<>();

    public void loadData(){

        /*
         62 5
            33 6
            49 9
            88 16
            41 20
            56 53
            98 64
            93 73
            95 75
         */
        snakes.put(62,5);
        snakes.put(33,6);
        snakes.put(49,9);
        snakes.put(88,16);
        snakes.put(41,20);
        snakes.put(56,53);
        snakes.put(98,64);
        snakes.put(93,73);
        snakes.put(95,75);
        /*
            2 37
            27 46
            10 32
            51 68
            61 79
            65 84
            71 91
            81 100

  */
        ladders.put(2,37);
        ladders.put(27,46);
        ladders.put(10,32);
        ladders.put(52,68);
        ladders.put(61,79);
        ladders.put(65,84);
        ladders.put(71,91);
        ladders.put(81,100);

    }


}
