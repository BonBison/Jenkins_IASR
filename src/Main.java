import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Dinosaur[] dinosaurs = {
                new Dinosaur("Тираннозавр", "плотоядный", 100, 25),
                new Dinosaur("Стегозавр", "травоядный", 105, 19),
                new Dinosaur("Велоцираптор", "плотоядный", 80, 20),
                new Dinosaur("Трицератопс", "травоядный", 110, 20),
                new Dinosaur("Альбертозавр", "плотоядный", 90, 23),
                new Dinosaur("Брахиозавр", "травоядный", 160, 18),
                new Dinosaur("Спинозавр", "плотоядный", 130, 22),
                new Dinosaur("Паразауролоф", "травоядный", 115, 16),
                new Dinosaur("Анкилозавр", "травоядный", 120, 19),
                new Dinosaur("Дилофозавр", "плотоядный", 85, 18)
        };

        Random random = new Random();
        int index1 = random.nextInt(10);
        int index2 = random.nextInt(10);

        while (index1 == index2) {
            index2 = random.nextInt(10);
        }

        Dinosaur dino1 = dinosaurs[index1];
        Dinosaur dino2 = dinosaurs[index2];

        System.out.println(dino1.getName() + " встречает " + dino2.getName() + "а! Что же будет?");

        if (dino1.canBefriend(dino2, random)) {
            System.out.println(dino1.getName() + " замечает, что 2-й братан по вкусняшкам. И они решают подружиться! ♥");
        } else {
            System.out.println("Кажется, первый жаждет крови, - они решают сразиться!");
            while (dino1.isAlive() && dino2.isAlive()) {
                System.out.println(dino1.getNameWithHealth() + " атакует " + dino2.getNameWithHealth() + ", нанося ему урон, равный " + dino1.damage);
                dino2.decreaseHealth(dino1.getDamage());
                if (dino2.isAlive()) {
                    System.out.println(dino2.getNameWithHealth() + " атакует " + dino1.getNameWithHealth() + ", нанося ему урон, равный " + dino2.damage);
                    dino1.decreaseHealth(dino2.getDamage());
                }
            }

            if (dino1.isAlive()) {
                System.out.println(dino1.getNameWithHealth() + " победил!");
            } else if (dino2.isAlive()) {
                System.out.println(dino2.getNameWithHealth() + " победил!");
            } else {
                System.out.println("Ничья! Оба динозавра погибли в битве.");
            }
        }
    }
}