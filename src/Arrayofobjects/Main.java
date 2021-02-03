package Arrayofobjects;

/*
Columns of mainfile
Time	Open	High	Low 	Close	Volume	MA5	MA10	MA20	ATR14
 */
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

                //
                String pathEURUSD = "/home/dani/Documents/FLOW/JAVA/ArraofObjects/src/Arrayofobjects/EURUSDH1noheader.csv";

                //ArrayList<String> toFind = new ArrayList<String>();

                CandleCollection hoorka = new CandleCollection();

                ArrayList<Candle> EURhoorka =  hoorka.makeHoorka(pathEURUSD);

                EURhoorka.forEach( C -> System.out.println(C));


                //(EURhoorka.get(100)).

               // System.out.println("Print candels from EURhoorka: " + EURhoorka);

                //Add candle pattern to find
//                toFind.add("beu");
//                toFind.add("beu");
//                toFind.add("beu");
//                toFind.add("beu");
//                toFind.add("beu");
//                toFind.add("beu");
//                toFind.add("beu");
//                toFind.add("beu");

                //System.out.println("to find: " + toFind);

                //Find pattern//
       // System.out.println("Pattern found: " + hoorka.FindPattern(toFind, EURhoorka) + " times");

                //Forecast//
                //hoorka.MakeStat(hoorka.beo, hoorka.beu, hoorka.buo, hoorka.buu);


    }
        }


