package com.gprogrammers.rem.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gprogrammers.rem.types.State;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;

public class StatesReader {


    public  static List<State> getAllStates() {
        //read from file json file

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String filePath="src/main/resources/static/json/states.json";
            File statesJsonFile= new File(filePath);
            if(!statesJsonFile.exists()) return null;

            List<State> states= objectMapper.readValue(statesJsonFile, new TypeReference<List<State>>(){});

            return states;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }




    }

}
