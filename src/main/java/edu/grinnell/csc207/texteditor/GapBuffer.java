package edu.grinnell.csc207.texteditor;

import java.util.Arrays;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {
    
    private char[] backingData;
    private int indexLeftCursor;
    private int indexRightCursor;
    private int size;
    private static final int INITIAL_LENGTH = 10;
    
    /**
     * Construct a gap buffer.
     */
    public GapBuffer() {
        this.backingData = new char[INITIAL_LENGTH];
        this.indexLeftCursor = 0;
        this.indexRightCursor = INITIAL_LENGTH - 1;
        this.size = 0;
    }
    
    public void insert(char ch) {
        
    }
    
    public void expand() {
        if(this.indexLeftCursor == this.indexRightCursor) {
            char[] newArr = new char[this.backingData.length*2];
            
        }
        
    }

    public void delete() {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public int getCursorPosition() {
        throw new UnsupportedOperationException("Unimplemented method 'getCursorPosition'");
    }

    public void moveLeft() {
        throw new UnsupportedOperationException("Unimplemented method 'moveLeft'");
    }

    public void moveRight() {
        throw new UnsupportedOperationException("Unimplemented method 'moveRight'");
    }

    public int getSize() {
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }

    public char getChar(int i) {
        throw new UnsupportedOperationException("Unimplemented method 'getChar'");
    }

    public String toString() {
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
}
