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
        return (int)Math.ceil(Math.sqrt(distanceSq(l)));
    }

    public int distanceSq(MapObject l) {
        return Math.abs(r*r - l.r * l.r) + Math.abs(c*c - l.c * l.c);
    }

}
