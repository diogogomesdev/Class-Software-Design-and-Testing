import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element{

    Wall(int x, int y) {
        super(x, y);
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#311111"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), " ");
    }

    public boolean equals(Position o) {
        if (position.getX() == o.getX() && position.getY() == o.getY()) return true;
        return false;
    }
}
