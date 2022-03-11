import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element{

    Monster(int x, int y) {
        super(x, y);
    }

    void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "s");
    }

    public void setPosition(Position pos){
        this.position.setX(pos.getX());
        this.position.setY(pos.getY());
    }

    public boolean equals(Position o) {
        if (position.getX() == o.getX() && position.getY() == o.getY()) return true;
        return false;
    }

    public Position moveMonsters(){
        Random random = new Random();
        int pos = random.nextInt(4);

        if(pos == 0){
            return new Position(position.getX()+1, position.getY());
        }
        else if(pos == 1){
            return new Position(position.getX()-1, position.getY());
        }
        if(pos == 2){
            return new Position(position.getX(), position.getY()+1);
        }
        else{
            return new Position(position.getX(), position.getY()-1);
        }
    }
}
