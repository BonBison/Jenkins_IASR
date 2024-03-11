import java.util.Random;

class Dinosaur {
    String name;
    String type;
    int health;
    int damage;

    public Dinosaur(String name, String type, int health, int damage) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public String getNameWithHealth() {
        return name + " [" + health + "]";
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void decreaseHealth(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean canBefriend(Dinosaur other, Random random) {
        return this.type.equals(other.getType()) && random.nextBoolean();
    }
}