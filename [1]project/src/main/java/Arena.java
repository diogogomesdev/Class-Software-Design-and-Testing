import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    private int width = 40;
    private int height = 20;

    Hero hero;

    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    Arena(){
        hero = new Hero(10, 10);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) +
                    1, random.nextInt(height - 2) + 1));
        return coins;
    }

    private ArrayList<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) +
                    1, random.nextInt(height - 2) + 1));
        return monsters;
    }

    private boolean canHeroMove(Position position){
        boolean canMove = true;
        for (Wall wall : walls) {
            if (wall.equals(position)) canMove = false;
        }
        return canMove;
    }

    private void retrieveCoins(Position position){
        for (Coin coin : coins)
            if (coin.equals(position)){
                coins.remove(coin);
                break;
            }
    }

    private void verifyMonsterCollisions(Position position){
        for (Monster monster : monsters)
            if (monster.equals(position)){
                System.out.println("GAME OVER");
                System.exit(0);
            }
    }

    public void moveHero(Position position) {
        if(canHeroMove(position)) {
            retrieveCoins(position);
            verifyMonsterCollisions(position);
            hero.setPosition(position);
        }
    }

    public void moveMonster(Position position, Monster monster) {
        if(canHeroMove(position)) {
            monster.setPosition(position); 
        }
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(hero.position.getX(), hero.position.getY()), "X");
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
        for (Monster monster : monsters)
            monster.draw(graphics);
    }

    public void processKey(KeyStroke key) {

        for (Monster monster : monsters)
            moveMonster(monster.moveMonsters(), monster);

        switch(key.getKeyType()){
            case ArrowUp: {
                moveHero(hero.moveUp());
                break;
            }
            case ArrowDown: {
                moveHero(hero.moveDown());
                break;
            }
            case ArrowRight: {
                moveHero(hero.moveRight());
                break;
            }
            case ArrowLeft: {
                moveHero(hero.moveLeft());
                break;
            }
            default:
                System.out.println("wrong key");

        }

        System.out.println(key);
    }

}
