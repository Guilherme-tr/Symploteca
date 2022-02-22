package br.edu.ifsp.domain.usecases.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Notification {

    private List<Error> errors = new ArrayList<>();

    public void addError(String message){
        addError(message, null);
    }

    public void addError(String message, Exception e){
        errors.add(new Error(message, e));
    }

    public boolean isCorrect(){
        return errors.isEmpty();
    }

    public boolean hasErrors(){
        return ! isCorrect();
    }

    private static class Error{
        String message;
        Exception casue;

        public Error(String message, Exception casue) {
            this.message = message;
            this.casue = casue;
        }
    }

    public String errorMessage(){
        return errors.stream().map(e -> e.message).collect(Collectors.joining(" ,"));
    }
}