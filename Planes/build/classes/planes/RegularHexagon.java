package planes;

/**
 * RegularHexagon osztály - a Planes nevű ősosztályból származik le
 * @author Balu
 */

public class RegularHexagon extends Planes{

    /**
     * Ez a RegularHexagon osztály konstruktora.<br>
     * Elvárja az x,y koordinátákat, illetve az adott síkidom oldalhosszát majd
     * meghívja a super() metódust, a metódus beállítja a síkidom szimbólumát.
     * @param x az adott síkidom középpontjának az x értéke
     * @param y az adott síkidom középpontjának az y értéke
     * @param SideLength az adott síkidom oldalának a hossza
     */
    public RegularHexagon(float x, float y, float SideLength){
        super("H",x,y,SideLength);
    }
    /**
     * A calculate() metódus számítja ki a síkidom 4 koordinátáját amit majd
     * elment a coordinates tömbbe. Ez a metódus felülírja az ősosztálybeli
     * metódust. Először létrehoz egy m változót, ez lesz az adott síkidom
     * magassága, majd ezzel számításokba kezd.
     */
    @Override
    public void calculate() {
        double m = Math.sqrt((getLength() * getLength() - (getLength() / 2) * (getLength() / 2)));

        coordinates[0] = getX() + getLength();
        coordinates[1] = getX() - getLength();
        coordinates[2] = getY() + (float)(m);
        coordinates[3] = getY() - (float)(m);
    }
}
