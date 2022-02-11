package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import org.junit.Test;
import static org.junit.Assert.*;

public class test {
    //@Test
    public void testSeed() {
        String[] a = new String[1];
        a[0] = "N412334141412Sdd:q";
        Main.main(a);
    }

    //@Test
    public void testSeed1() {
        String[] a = new String[1];
        a[0] = "laa:q";
        Main.main(a);
    }

    //@Test
    public void testSeed2() {
        String[] a = new String[1];
        a[0] = "l:q";
        Main.main(a);
    }

    @Test
    public void testSeed3() {
        String[] a = new String[1];
        a[0] = "n3415218040718096461ssdsddaddaa:q";
        Main.main(a);
    }

}
