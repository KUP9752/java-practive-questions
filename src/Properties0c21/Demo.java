package Properties0c21;
import static org.junit.Assert.*;

import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {
        PropertyCollection properties = new PropertyCollection();
        IntStream.range(0,1000).forEach(
                i -> {
                    properties.addProperty(new House(Type.SEMIDETACHED, 2));
                    properties.addProperty(new House(Type.TERRACED, 2));
        }
        );
        IntStream.range(0,100).forEach(
                i -> {
                    properties.addProperty(new House(Type.DETACHED, 2));
                    properties.addProperty(new Bungalow(Type.SEMIDETACHED));
                    properties.addProperty(new Flat());
                }
        );
        IntStream.range(0,20).forEach(
                i -> {
                    properties.addProperty(new Maisonette(2));
                    properties.addProperty(new Bungalow(Type.DETACHED));
                    properties.addProperty(new Bungalow(Type.TERRACED));
                }
        );
        System.out.println(properties.getHouses().size() + " houses");
        System.out.println(properties.getBungalows().size() + " bungalows");
        System.out.println(properties.getFlats().size() + " flats");
        System.out.println(properties.getMaisonettes().size() + " maisonettes");
        System.out.println(properties.getTerracedHouses().size() + " terraced houses");

        assertEquals(2240, properties.getHouses().size());
        assertEquals(140, properties.getBungalows().size());
        assertEquals(120, properties.getFlats().size());
        assertEquals(20, properties.getMaisonettes().size());
        assertEquals(1020, properties.getTerracedHouses().size());
    }
}
