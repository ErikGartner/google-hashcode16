/**
 * Created by erik on 11/02/16.
 */
public abstract class MapObject{

    public int r;
    public int c;

    public MapObject(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int distance(MapObject l) {
        return 0;
    }

}
