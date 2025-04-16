package edu.grinnell.csc207.texteditor;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.screen.Screen;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {

    /**
     * Renders the entire GapBuffer to the given screen.
     *
     * @param buf
     * @param screen
     * @throws java.io.IOException
     */
    public static void drawBuffer(GapBuffer buf, Screen screen) throws IOException {
        screen.clear();
        for (int n = 0; n < buf.getSize(); n++) {
            char c = buf.getChar(n);
            screen.setCharacter(n, 0, TextCharacter.fromCharacter(c)[0]);
        }
        screen.setCursorPosition(new TerminalPosition(buf.getCursorPosition(), 0));
        screen.refresh();
    }

    /**
     * The main entry point for the TextEditor application.
     *
     * @param args command-line arguments.
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        if (args.length > 1 || args.length == 0) {
            System.err.println("Usage: java TextEditor <filename>");
            System.exit(1);
        }
        Screen screen = new DefaultTerminalFactory().createScreen();
        Path path = Paths.get(args[0]);
        GapBuffer buf;
        System.out.println("Loading" + path.toString());
        if (Files.exists(path)) {
            buf = new GapBuffer(Files.readString(path));
        } else {
            buf = new GapBuffer();
        }
        screen.startScreen();
        boolean hitEscape = false;
        while (!hitEscape) {
            KeyStroke stroke = screen.readInput();
            switch (stroke.getKeyType()) {
                case Escape:
                    hitEscape = true;
                    break;
                case Character:
                    buf.insert(stroke.getCharacter());
                    break;
                case ArrowLeft:
                    buf.moveLeft();
                    break;
                case ArrowRight:
                    buf.moveRight();
                    break;
                case Backspace:
                    buf.delete();
                    break;
                default:
                    System.out.println("Key cannot be identified.");
                    break;
            }
            drawBuffer(buf, screen);
        }
        Files.writeString(path, buf.toString());
        screen.stopScreen();
    }
}
