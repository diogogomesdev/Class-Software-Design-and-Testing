import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Game {

    Terminal terminal;
    TextGraphics graphics;
    Screen screen;
    Arena arena;

    Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(40, 20);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        arena = new Arena();
    }

    private void processKey(KeyStroke key) {
        arena.processKey(key);
    }

    public void run() throws IOException {
        KeyStroke key;
        while(true) {
            screen.clear();
            arena.draw(screen.newTextGraphics());
            screen.refresh();
            key = screen.readInput();
            if(key.getKeyType() == KeyType.EOF) break;
            if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') break;
            processKey(key);
        }
    }

}
