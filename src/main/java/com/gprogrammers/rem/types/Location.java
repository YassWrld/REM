package com.gprogrammers.rem.types;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    public int stateCode;
    public int cityCode;
    public String address=null;
}
