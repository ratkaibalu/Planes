package planes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ez a PlanesMake osztály - ez az osztály végzi főként a beolvasást,kiíratást
 * és egyéb műveleteket.
 * @author Balu
 */
public class PlanesMake {
    /**
     * Ebbe a tömbbe tárolódnak el a síkidomok szimbólumai,x,y koordinátái és oldalhossza.
     * 
     */
    private final ArrayList<Planes> planes;
    /**
     * Ebbe a tömbbe rakódnak majd az x koordináták
     */
    public ArrayList<Float> listX;
    /**
     * Ebbe a tömbbe rakódnak majd az y koordináták
     */
    public ArrayList<Float> listY;
    /**
     * Ebbe a tömbbe kerül majd a legkisebb téglalap koordinátái 
     */
    public float[] result;

    /**
     * Ez a PlanesMake konstruktora, nem vár el semmilyen értéket, de létrehoz 4 tömböt
     */
    public PlanesMake() {
        planes = new ArrayList<>();
        listY = new ArrayList<>();
        listX = new ArrayList<>();
        result = new float[4];
    }

    /**
     * Ez a függvény végzi a beolvasást scenner segítségével.
     * Elmenti a síkidomok darabszámát, majd beolvassa a síkidomok fajtáját,
     * középpontjainak koordinátáját és az oldalhosszát.
     * @param filename A file neve
     * @throws FileNotFoundException Ezt a hibát dobja ha a file nem létezik
     * @throws InvalidInputException Ezt a hibát dobja ha a file-ban hibásan vannak megadva az adatok.
     */
    public void read(String filename) throws FileNotFoundException, InvalidInputException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
        int numPlanes = sc.nextInt();
        while(sc.hasNext()) {
            Planes plane;
            String symbol = sc.next();
            float x = sc.nextFloat();
            float y = sc.nextFloat();
            float Length = sc.nextFloat();
            switch (symbol){
                case "C":
                    plane = new Circle(x,y,Length);
                    break;
                case "T":
                    plane = new RegularTriangle(x,y,Length);
                    break;
                case "S":
                    plane = new Square(x,y,Length);
                    break;
                case "H":
                    plane = new RegularHexagon(x,y,Length);
                    break;
                default:
                    throw new InvalidInputException();
            }
            planes.add(plane);
        }
    }
    /**
     * Ez a függvény tölti fel az x és y listákat számokkal.
     */
    public void fillLists(){
        for(Planes p : planes){
            p.calculate();
            listX.add(p.getCoordinates()[0]);
            listX.add(p.getCoordinates()[1]);
            listY.add(p.getCoordinates()[2]);
            listY.add(p.getCoordinates()[3]);
        }
    }
    /**
     * Ez a függvény kiszámolja a legkisebb téglalap koordinátáit, minimum és maximumkiválasztást hajt végre az x és y listákon.
     */
    public void makeResult(){
        // X max
        result[0] = listX.get(0);
        // X min
        result[1] = listX.get(0);
        //Y max
        result[2] = listY.get(0);
        //Y min
        result[3] = listY.get(0);
        for(int i = 0; i<listX.size();i++){
            if(result[0] < listX.get(i)){
                result[0] = listX.get(i);
            }
            if(result[1] > listX.get(i)){
                result[1] = listX.get(i);
            }
        }
        for(int i=0; i< listY.size();i++){
            if(result[2] < listY.get(i)){
                result[2] = listY.get(i);
            }
            if(result[3] > listY.get(i)){
                result[3] = listY.get(i);
            }
        }
    }
    
    /**
     * Ez a függvény kiíratja a megadott, megkapott értékeket,síkidomokat.
     */
    public void report() {
        
        System.out.println("Síkidomok: ");
        for(Planes p : planes) {
            System.out.println(p);
        }
        System.out.println("Legkisebb téglalap koordinátái amiben benne van az "
        + "összes síkidom: ");
        System.out.println("Téglalap A koordinátája: (" + result[0] +"," + result[2] + ")");
        System.out.println("Téglalap B koordinátája: (" + result[0] +"," + result[3] + ")");
        System.out.println("Téglalap C koordinátája: (" + result[1] +"," + result[2] + ")");
        System.out.println("Téglalap D koordinátája: (" + result[1] +"," + result[3] + ")");
    }
    /**
     * Ez a metódus törli a planes tömb elemeit.
     */
    public void clear(){
        planes.clear();
    }
}
