package labaks.hscarddirectory;

public class Card {

    int id = 0,
            price = 0,
            attack = 0,
            health = 0;
    String name = null,
            setName = null,
            race = null,
            className = null,
            type = null,
            rarity = null,
            mechanics = null;

    public Card(int id, String name, String setName, String race, String className, int price, int attack, int health, String type, String rarity, String mechanics) {
        this.id = id;
        this.name = name;
        this.setName = setName;
        this.race = race;
        this.className = className;
        this.price = price;
        this.attack = attack;
        this.health = health;
        this.type = type;
        this.rarity = rarity;
        this.mechanics = mechanics;
    }
}
