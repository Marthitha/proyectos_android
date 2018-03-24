package com.example.marthitha.puzzlemartha.patronfactory;

/**
 * Created by Marthitha on 23/03/2018.
 */

public class PuzzleFactory {
    static PuzzleInt puzzle;
    public static PuzzleInt create (int tipo){
        switch (tipo){
            case 1:
                puzzle= new PuzzleLibre();
                break;
            case 2:
                puzzle= new PuzzleClasico();
                break;
            case 3:
                puzzle= new PuzzleLibre();
                break;
        }
        return puzzle;
    }

}
