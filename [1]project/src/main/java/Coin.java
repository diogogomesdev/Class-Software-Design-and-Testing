import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element{

    Coin(int x, int y) {
        super(x, y);
    }

    void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), ".");
    }

    public boolean equals(Position o) {
        if (this.position.getX() == o.getX() && this.position.getY() == o.getY()) return true;
        return false;
    }

}
