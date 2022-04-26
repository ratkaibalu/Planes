package planes;

/**
 * Circle osztály - a Planes nevű ősosztályból származik le
 * @author Balu
 */
public class Circle extends Planes{

    /**
     * Ez a Circle osztály konstruktora.<br>
     * Elvárja az x,y koordinátákat, illetve az adott síkidom oldalhosszát majd
     * meghívja a super() metódust, a metódus beállítja a síkidom szimbólumát.
     * @param x az adott síkidom középpontjának az x értéke
     * @param y az adott síkidom középpontjának az y értéke
     * @param radius az adott síkidom sugarának a hossza
     */
    public Circle(float x,float y,float radius){
        super("C",x,y,radius);
    }
    /**
     * A calculate() metódus számítja ki a síkidom 4 koordinátáját amit majd
     * elment a coordinates tömbbe. Ez a metódus felülírja az ősosztálybeli
     * metódust.
     */
    @Override
    public void calculate(){
        coordinates[0] = getX() + getLength();
        coordinates[1] = getX() - getLength();
        coordinates[2] = getY() + getLength();
        coordinates[3] = getY() - getLength();
    }
}
