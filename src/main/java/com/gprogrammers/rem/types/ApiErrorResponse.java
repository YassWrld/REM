package com.gprogrammers.rem.types;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {
    public String error;
    public String stackTrace=null;
    final public boolean success = false;
}
