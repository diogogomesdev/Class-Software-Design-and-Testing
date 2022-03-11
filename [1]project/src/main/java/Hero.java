import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero extends Element{

    Hero(int x, int y){
        super(x,y);
    }

    public void setPosition(Position pos){
        this.position.setX(pos.getX());
        this.position.setY(pos.getY());
    }

    public void draw(TextGraphics graphics){

    }

    public Position moveUp(){
        return new Position(position.getX(), position.getY()-1);
    }

    public Position moveRight(){
        return new Position(position.getX()+1, position.getY());
    }

    public Position moveDown(){
        return new Position(position.getX(), position.getY()+1);
    }

    public Position moveLeft(){
        return new Position(position.getX()-1, position.getY());
    }

}
