import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Random r = new Random();

        List<Animal> animalList = new ArrayList<>(){
            {
                add(new Animal("Dog", Animal.Kind.MAMMAL,7, 10, 30 ));
                add(new Animal("Dog", Animal.Kind.MAMMAL,7, 10, 30 ));
                add(new Animal("Snake", Animal.Kind.REPTILE,1, 1, 50 ));
                add(new Animal("Eagle", Animal.Kind.BIRD,3, 8, 55 ));
                add(new Animal("Shark", Animal.Kind.FISH,2, 100, 45 ));
                add(new Animal("Salamander", Animal.Kind.AMPHIBIAN,1, 0.3, 15 ));
            }
        };

        System.out.println(animalList);

        // zweite im alphabet

        Optional<Animal> secondAnimalInAlphabet = animalList.stream()
                .distinct()
                .sorted(Comparator.comparing(Animal::getName))
                //.peek(System.out::print)
                .skip(1)
                .findFirst();
/* alternative  .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        animals -> animals.get(0)
                ));
                */

        secondAnimalInAlphabet.ifPresent(a -> System.out.println("\nsecond animal in alphabet via name: " + a));
        ;

        //  Berechne per Stream-API die Länge - anzahl der elemente?

        int streamLength = (int) animalList
                .stream()
                .count();

        // max Age

        Optional<Animal> oldestAnimal = animalList.stream()
                .distinct()
                .reduce( (a, b) -> a.getAge() > b.getAge() ? a : b );

        oldestAnimal.ifPresent(System.out::println);

        // durchschnittsalter

        OptionalDouble averageAge = animalList
                .stream()
                .mapToInt(Animal::getAge)
                .average();


        averageAge.ifPresent(a -> System.out.println("avg age: " + a));
        //System.out.println("avg age: " + averageAge.orElse(0));




        // reduce to names string

        String allNames = animalList
                .stream()
                .distinct()
                .map(Animal::getName)
                .reduce("",(a, b) ->  a.equals("") ? a + b : a + ", " + b);

        System.out.println(allNames);

        // Seite 6

        System.out.println("Seite 6");

        Stream.iterate(7, i -> i+9)
                .limit(50)
                .forEach(System.out::println);

        List<Integer> listOfRandomInts = Stream.generate(Math::random)
                .limit(50)
                .distinct()
                .map(x -> Math.round(x*10))
                .filter(x -> x%2 == 0)
                .map(Long::intValue)
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println(listOfRandomInts.size());

        // numeric stream

        List<String> stringListMod3 = IntStream.rangeClosed(21,77)
                .peek(System.out::print)
                .filter( x -> x%3==0)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println(stringListMod3);
        
    }
}
