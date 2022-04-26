package planes;

import java.io.FileNotFoundException;
/**
 * Ez a Main osztály, itt keződik el a program lefutása.
 * @author Balu
 */

public class Main {

    /**
     * Ez a Main osztály main() metódusa - itt lehet megadni hogy melyik
     * file-ból olvasson be a program.Itt törtnénik a szimuláció A metódus
     * @param args -
     */
    public static void main(String[] args) {
        
        PlanesMake planes = new PlanesMake();
        try {
            planes.read("ures.txt");
        } catch(FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch(InvalidInputException ex){
            System.out.println("Invalid input!");
            System.exit(-1);
        }
        planes.fillLists();
        planes.makeResult();
        planes.report();
    }
}
