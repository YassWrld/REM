package com.gprogrammers.rem.types.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class State {
    public String name;
    public int code;
    public City[] cities;
}
