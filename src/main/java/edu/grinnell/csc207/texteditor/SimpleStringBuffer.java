
package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
/**
 * A simple text buffer.
 * @author Tiffany Tang
 */
public class SimpleStringBuffer {
    
    private String backingData;
    private int indexOfCursor;
    private int size;

    /**
     * Construct a simple string buffer.
     */
    public SimpleStringBuffer() {
        this.backingData = "";
        this.indexOfCursor = 0;
        this.size = 0;
    }

    /**
     * Inserts character ch into the buffer at the cursor's current position.
     * @param ch The character to be inserted.
     */
    public void insert(char ch) {
       String part1 = backingData.substring(0, this.indexOfCursor);
       String part2 = backingData.substring(this.indexOfCursor, this.size);
       this.backingData = part1 + ch + part2;
       this.moveRight();
       this.size++;
    }

    /**
     * Deletes the character at the cursor's current position.
     */
    public void delete() {
        if (this.size != 0) {
            String part1 = backingData.substring(0, this.indexOfCursor - 1);
            String part2 = backingData.substring(this.indexOfCursor, this.size);
            this.backingData = part1 + part2;
            this.moveLeft();
            this.size--;
        }     
    }
    
    /**
     * Returns the current position of the cursor.
     * @return an integer as the index of the cursor.
     */
    public int getCursorPosition() {
        return this.indexOfCursor;
    }
    
    /**
     * Moves the cursor one position backwards.
     */
    public void moveLeft() {
        if (this.indexOfCursor != 0) {
            this.indexOfCursor--;
        }   
    }
    
    /**
     * Moves the cursor one position forwards.
     */
    public void moveRight() {
        if (this.indexOfCursor != this.size) {
            this.indexOfCursor++;
        } 
    }

    /**
     * Return the size of the backingData.
     * @return the size of the backingData.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Returns the ith character of the buffer, zero-indexed.
     * @param i
     * @return the character at index i.
     * @throws IndexOutOfBoundsException when i is invalid.
     */
    public char getChar(int i) throws IndexOutOfBoundsException {
        if ( i < 0 || i >= this.size ) {
            throw new IndexOutOfBoundsException("Exception: Invalid index");
        } else {
            return this.backingData.charAt(i);
        }     
    }

    /**
     * Returns the contents of the buffer as a String.
     * @return a string as the contents.
     */
    @Override
    public String toString() {
        return this.backingData;
    }
}
