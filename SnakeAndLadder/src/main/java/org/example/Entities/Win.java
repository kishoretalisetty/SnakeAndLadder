package org.example.Entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class Win {
    private List<String> gameData=new ArrayList<>();


    public String printGameDate(){
        String ans="";
       for(String st:gameData){
           ans=ans+st+"\n";
       }

       return ans;
    }
}
