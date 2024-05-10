package com.gprogrammers.rem.types;

import com.gprogrammers.rem.types.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class State {
    public String name;
    public int stateCode;
    public City[] cities;

}