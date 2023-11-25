import java.util.Collections;
import java.util.Comparator;

class Goodie {
    private String name;
    private double price;

    public Goodie(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Bag<T> {
    protected List<T> items;

    public Bag() {
        items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }
}

class CandyBags extends Bag<Goodie> {

    @Override
    public void add(Goodie goodie) {
        // Solo agregar si no existe previamente en la bolsa
        if (!items.contains(goodie)) {
            super.add(goodie);
        }
    }

    public Goodie cheapest() {
        if (items.isEmpty()) {
            return null; // Retorna null si la bolsa está vacía
        }

        // Inicializa con la primera golosina
        Goodie cheapestGoodie = items.get(0);

        // Encuentra la golosina más económica
        for (Goodie goodie : items) {
            if (goodie.getPrice() < cheapestGoodie.getPrice()) {
                cheapestGoodie = goodie;
            }
        }

        return cheapestGoodie;
    }

    public List<Goodie> mostExpensive(int n) {
        if (n <= 0 || items.isEmpty()) {
            return Collections.emptyList(); // Retorna una lista vacía si n es <= 0 o la bolsa está vacía
        }

        // Ordena la lista de golosinas por precio de mayor a menor
        Collections.sort(items, Comparator.comparingDouble(Goodie::getPrice).reversed());

        // Devuelve las n primeras golosinas (las más caras)
        return items.subList(0, Math.min(n, items.size()));
    }
}

public class Main {
    public static void main(String[] args) {
        CandyBags candyBag = new CandyBags();

        Goodie candy1 = new Goodie("Chocolate", 2.5);
        Goodie candy2 = new Goodie("Gummy Bears", 1.8);
        Goodie candy3 = new Goodie("Lollipop", 1.2);
        Goodie candy4 = new Goodie("Caramel", 3.0);

        candyBag.add(candy1);
        candyBag.add(candy2);
        candyBag.add(candy3);
        candyBag.add(candy4);

        System.out.println("Cheapest Candy: " + candyBag.cheapest().getName());

        List<Goodie> mostExpensiveCandies = candyBag.mostExpensive(2);
        System.out.println("Most Expensive Candies: ");
        for (Goodie candy : mostExpensiveCandies) {
            System.out.println(candy.getName() + " - " + candy.getPrice());
        }
    }
}
