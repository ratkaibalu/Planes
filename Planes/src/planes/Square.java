package planes;

/**
 * Square osztály - a Planes nevű ősosztályból származik le
 * @author Balu
 */
public class Square extends Planes{

    /**
     * Ez a Square osztály konstruktora.<br>
     * Elvárja az x,y koordinátákat, illetve az adott síkidom oldalhosszát majd
     * meghívja a super() metódust, a metódus beállítja a síkidom szimbólumát.
     * @param x az adott síkidom középpontjának az x értéke
     * @param y az adott síkidom középpontjának az y értéke
     * @param SideLength az adott síkidom oldalának a hossza
     */
    public Square(float x, float y,float SideLength){
        super("S",x,y,SideLength);
    }

    /**
     * A calculate() metódus számítja ki a síkidom 4 koordinátáját amit majd
     * elment a coordinates tömbbe. Ez a metódus felülírja az ősosztálybeli
     * metódust. Először létrehoz egy m változót, ez lesz az adott síkidom
     * magassága, majd ezzel számításokba kezd.
     */
    @Override
    public void calculate() {
        coordinates[0] = getX() + (getLength() / 2);
        coordinates[1] = getX() - (getLength() / 2);
        coordinates[2] = getY() + (getLength() / 2);
        coordinates[3] = getY() - (getLength() / 2);
    }
}
