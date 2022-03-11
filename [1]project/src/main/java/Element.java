import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    Position position;

    Element(int x, int y){
        position = new Position(x, y);
    }

    abstract void draw(TextGraphics graphics);

}