package planes;

/**
 * Planes ősosztály
 * @author Balu
 */
public abstract class Planes {
    /**
     * x - float típusú adattag, a síkidom középpontnak x koordinátája.
     */
    private float x;
    /**
     * y - float típusú adattag, a síkidom középpontnak y koordinátája.
     */
    private float y;
    /**
     * Length - float típusú adattag, a síkidom oldalhossza.
     */
    private float Length;
    /**
     * symbol - String típusú adattag, a síkidom jele.
     */
    private String symbol;
    /**
     * coordinates - float típusú tömb, a kapott síkidomnak a kiszámolt koordinátái
     * ebbe a tömbbe kerülnek bele.
     */
    public float[] coordinates;
    
    /**
     * Planes ősosztály konstruktora - elvárja a síkidom jelét, középpont 
     * koordinátáját x,y és a síkidom oldalhosszát.
     * @param symbol síkidom jele
     * @param x síkidom középpontjának x koordinátája
     * @param y síkidom középpontjának y koordinátája
     * @param Length síkidom oldalhossza
     */
    public Planes(String symbol,float x, float y,float Length){
        this.symbol = symbol;
        this.x = x;
        this.y = y;
        this.Length = Length;
        coordinates = new float[4];
    }
    /**
     * Ez a függvény visszaadja a coordinates tömb értékeit
     * @return coordinates tömb
     */
    public float[] getCoordinates(){
        return coordinates;
    }
    /**
     * Ez egy absztakt függvény, mindegyik alosztályban ez kerül felülírásra.
     * Ez tölti majd fel a coordinates függvényt számokkal.
     */
    abstract public void calculate();

    /**
     * Ez a függvény visszaadja a síkidom jelét
     * @return síkidom jele
     */
    public String getSymbol(){
        return symbol;
    }

    /**
     * Ez a függvény beállítja a síkidom jelét
     * @param symbol a síkidom jele
     */
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    /**
     * Ez a függvény visszaadja a síkidom középpontjának az x koordinátáját
     * @return  síkidom középpontjának az x koordinátája
     */
    public float getX(){
        return x;
    }
    /**
     * Ez a függvény beállítja a síkidom középpontjának az x koordinátáját
     * @param x síkidom középpontjának az x koordinátája
     */
    public void setX(int x){
        this.x = x;
    }
    /**
     * Ez a függvény visszaadja a síkidom középpontjának az y koordinátáját
     * @return síkidom középpontjának az y koordinátája
     */
    public float getY(){
        return y;
    }
    /**
     * Ez a függvény beállítja a síkidom középpontjának az y koordinátáját
     * @param y síkidom középpontjának az y koordinátája
     */
    public void setY(int y){
        this.y = y;
    }
    /**
     * Ez a függvény visszaadja a síkidom oldalhosszát
     * @return síkidom oldalhossza
     */
    public float getLength(){
        return Length;
    }
    /**
     * Ez a függvény beállítja a síkidom oldalhosszát
     * @param Length síkidom oldalhossza
     */
    public void setLength(float Length){
        this.Length = Length;
    }

    /**
     * Ez a függvény a kiíratásnál segít, először megmondja milyen síkidomról 
     * van szó, majd kiíratja az x,y koordinátáját végül a síkidom oldalhosszát/ sugarát.
     * @return Síkidom : szimbólum , x koordináta, y koordináta, oldalhossz
     */
    @Override
    public String toString() {
        return "Síkidom: " + symbol + ", X koordinátája: " + x + ", Y koordinátája: " + y + ", oldalhossza/sugár: " + Length;
    }
}
