package Arrayofobjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap; // import the HashMap class
import java.util.List;

public class CandleCollection {

    ArrayList<Candle> list;

    public CandleCollection() {
        this.list = new ArrayList<>();
    }

    public ArrayList<Candle> makeHoorka(String path) throws IOException {

        //try {
        File f1 = new File(path); //Creation of File Descriptor for input file
        String[] row = null;  //Intialize the word Array
        FileReader fr = new FileReader(f1);  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object

//    catch (Exception e){
//            System.out.println("Something is wrong. Maybe no file found? :( ");
//        }
//    Scanner myObj = new Scanner(System.in);
//    String input = myObj.nextLine();  // Read user input

        String s;
        while ((s = br.readLine()) != null)   //Reading Content from the file
        {
            row = s.split(",");
            // row[0] az első oszlop
            //Builder//

            // Create Candle objects with fake data for now
            list.add(new Candle.Builder(row[0])
                    .timestamp(row[0])
                    .openPrice(1.321)
                    .closePrice(1324.0)
                    .high(1324.0)
                    .low(1324.0)
                    .MA5(1324.0)
                    .MA10(1324.0)
                    .MA20(1324.0)
                    .MAinUse(1324.0) //change this
                    .ATR14(1324.0)
                    .CandleSize(1324.0)
                    .CandleType(1324.0, 1325.0, 1330.0, 1322.0)
                    .build()
            );
            System.out.println("Processing date: " + row[0]);
        }

        fr.close();
        return list;
    }

//    public int FindPattern(ArrayList<String> patterntofind, ArrayList<String> bars){
//
//        int matchFound = 0;
//
//        for ( int i = 0; i < bars.size()-10; i++){
//            System.out.println("Checking " + i + ". bar in bars");
//            System.out.println("bar in bars: " + bars.get(i));
//            for (int j = 0; j < patterntofind.size(); j++) {
//                System.out.println("Checking " + j + ". bar in patternToFind");
//                System.out.println("Bar in pattern: " + patterntofind.get(j));
//                if (!bars.get(i+j).equals(patterntofind.get(j))) {
//                    System.out.println("No match");
//                    break;
//                } else if ( j == patterntofind.size()-1) {
//                    System.out.println("Match found");
//                    matchFound++;
//                    this.SaveNextBars(bars.get(i+j+1)); //saving next bar
//                }
//            }
//        }
//    return matchFound;
//    }

//    public void SaveNextBars(String bar){
//        if (bar.equals("beu")) { beu++; }
//        else if (bar.equals("beo")) {beo++;}
//        else if (bar.equals("buo")) {buo++;}
//        else if (bar.equals("buu")) {buu++;}
//    }



    public HashMap<String, Integer> CollectAllPossiblePatternsFromPast (ArrayList<Candle> allCandles, Integer sizeOfPattern) {

        HashMap<String, Integer> hoorka = new HashMap<>(); //Hashmap for collecting the patterns we have found
        String tempCandletype = ""; //temporary String

        for (int i=0; i < allCandles.size(); i++) { //Iterate all candles
            for (int j=0; i < sizeOfPattern; j++) { //Create pattern in tempSpring.
                 tempCandletype += allCandles.get(i+j).getCandleType(); //(get the candletype somehow)
                                                                        // Ha ez egy object: allCandles.get(i+j)
                                                                        // Akkor ez mirt cannot resolve? -> .getCandleType
            }
            if (hoorka.containsKey(tempCandletype)){
                hoorka.get(tempCandletype);
            }
            //Here we check id pattern is already in the map. If yes we increment the value.
            hoorka.put(tempCandletype, hoorka.getOrDefault(tempCandletype, 0) + 1);
        }
        return hoorka;
    }

}

