package Properties0c21;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PropertyCollection {
    final Set<Property> properties;

    public PropertyCollection(Set<Property> properties) {
        this.properties = properties;
    }
    public PropertyCollection() {
        this(new HashSet<>());
    }

    public void addProperty(Property p) {
        properties.add(p);
    }

    public Set<House> getHouses() {
        Set<House> houses = new HashSet<>();
        properties.stream().filter(
                p -> p instanceof House
        ).forEach(
                h -> houses.add((House) h)
        );
        return houses;
    }

    public Set<Bungalow> getBungalows() {
        Set<Bungalow> bungalows = new HashSet<>();
        properties.stream().filter(
                p -> p instanceof Bungalow
        ).forEach(
                b -> bungalows.add((Bungalow) b)
        );
        return bungalows;
    }

    public Set<Flat> getFlats() {
        Set<Flat> flats = new HashSet<>();
        properties.stream().filter(
                p -> p instanceof Flat
        ).forEach(
                f -> flats.add((Flat) f)
        );
        return flats;
    }

    public Set<Maisonette> getMaisonettes() {
        Set<Maisonette> maisonettes = new HashSet<>();
        properties.stream().filter(
                p -> p instanceof Maisonette
        ).forEach(
                m -> maisonettes.add((Maisonette) m)
        );
        return maisonettes;
    }

    public Set<House> getTerracedHouses() {
        Set<House> houses = getHouses();
        return houses.stream().filter(House::isTerraced)
                .collect(Collectors.toSet());
    }


    public static void main(String[] args) {
        Set<Integer> ints = new HashSet<>(Arrays.asList(0,1,2,3,4,5));
        System.out.println(ints);
        ints.stream().filter(Predicate.isEqual(1));
        System.out.println(ints);
    }
}
