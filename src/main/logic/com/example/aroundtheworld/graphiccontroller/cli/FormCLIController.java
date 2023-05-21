package com.example.aroundtheworld.graphiccontroller.cli;

import com.example.aroundtheworld.exception.CommandErrorException;
import com.example.aroundtheworld.viewcli.FormViewCLI;

public abstract class FormCLIController implements GraphicCLIController {
    private static final String LONDON = "1";
    private static final String ROME = "2";
    private static final String PARIS = "3";
    private static final String NEW_YORK = "4";
    private static final String VALENCIA = "5";
    private static final String SINGLE = "1";
    private static final String DOUBLE = "2";
    private static final String SHARED = "2";
    private static final String VEGETARIAN = "1";
    private static final String VEGAN = "2";
    private static final String NOPREF = "3";
    private static final String YES = "1";
    private static final String NO = "2";

    FormViewCLI formViewCLI;
    public String executeCity(String line) throws CommandErrorException {
        String city;
        switch (line){
            case LONDON -> city = "London";
            case ROME -> city = "Rome";
            case PARIS -> city = "Paris";
            case NEW_YORK -> city = "New York";
            case VALENCIA -> city = "Valencia";
            default -> throw new CommandErrorException();
        }
        return city;
    }

    public String executeRoom(String inputLine) throws CommandErrorException {
        String room;
        switch (inputLine){
            case SINGLE -> room = "single";
            case DOUBLE -> room = "double";
            default -> throw new CommandErrorException();
        }
        return room;
    }

    public String executeHouse(String inputLine) throws CommandErrorException {
        String room;
        switch (inputLine){
            case SINGLE -> room = "single";
            case SHARED -> room = "shared";
            default -> throw new CommandErrorException();
        }
        return room;
    }

    public int executeFood(String inputLine) throws CommandErrorException {
        int food;
        switch (inputLine){
            case VEGETARIAN -> food = 0;
            case VEGAN -> food = 1;
            case NOPREF -> food = 2;
            default -> throw new CommandErrorException();
        }
        return food;
    }

    public int executeChoice(String inputLine) throws CommandErrorException {
        int choice;
        switch (inputLine){
            case YES -> choice = 1;
            case NO -> choice = 0;
            default -> throw new CommandErrorException();
        }
        return choice;
    }

}