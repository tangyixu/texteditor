package edu.grinnell.csc207.texteditor;


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

    /**
     * Construct a gap buffer with pre-established array.
     *
     * @param text the text to be the backingData array.
     */
    public GapBuffer(String text) {
        this.backingData = text.toCharArray();
        this.indexLeftCursor = 0;
        this.indexRightCursor = INITIAL_LENGTH - 1;
        this.size = 0;
    }

    /**
     * Inserts character ch into the buffer at the left cursor's current
     * position.
     *
     * @param ch The character to be inserted.
     */
    public void insert(char ch) {
        if (this.size == this.backingData.length - 1) {
            expand();
        }
        this.backingData[this.indexLeftCursor] = ch;
        this.indexLeftCursor++;
        this.size++;
    }

    /**
     * Expand the array when there is no room in the gap.
     */
    public void expand() {
        if (this.indexLeftCursor == this.indexRightCursor) {
            char[] newArr = new char[this.backingData.length * 2];
            System.arraycopy(this.backingData, 0, newArr, 0, indexLeftCursor);
            System.arraycopy(this.backingData, this.indexRightCursor,
                    newArr, newArr.length - this.indexRightCursor,
                    this.backingData.length - this.indexRightCursor);
            this.backingData = newArr;
            this.indexRightCursor = this.backingData.length + this.indexRightCursor;
        }
    }

    /**
     * Deletes the character at the one index to the left of left cursor's
     * current position.
     */
    public void delete() {
        if (this.indexLeftCursor != 0) {
            this.backingData[indexLeftCursor - 1] = 0;
            this.indexLeftCursor--;
            this.size--;
        }  
    }

    /**
     * Returns the current position of the left cursor.
     *
     * @return the current position of the left cursor.
     */
    public int getCursorPosition() {
        return this.indexLeftCursor;
    }

    /**
     * Moves the cursor one position backwards.
     */
    public void moveLeft() {
        if (this.indexLeftCursor != 0 && this.indexRightCursor != 0) {
            this.backingData[this.indexRightCursor]
                    = this.backingData[this.indexLeftCursor - 1];
            this.backingData[this.indexLeftCursor - 1] = 0;
            this.indexLeftCursor--;
            this.indexRightCursor--;
        }
    }

    /**
     * Moves the cursor one position forwards.
     */
    public void moveRight() {
        if (this.indexRightCursor < this.backingData.length - 1) {
            this.backingData[this.indexRightCursor + 1]
                    = this.backingData[this.indexLeftCursor];
            this.indexLeftCursor++;
            this.indexRightCursor++;
        }
    }

    /**
     * Return the size of the backingData.
     *
     * @return the size of the backingData.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Returns the ith character of the array, zero-indexed.
     *
     * @param i
     * @return the character at index i.
     * @throws IndexOutOfBoundsException when i is invalid.
     */
    public char getChar(int i) {
        if (i < this.indexLeftCursor) {
            return this.backingData[i];
        } else if (i < this.indexRightCursor) {
            return this.backingData[this.indexRightCursor + i - this.indexLeftCursor];
        } else {
            return this.backingData[i + this.indexRightCursor - this.indexLeftCursor];
        }
    }

    /**
     * Returns the contents of the gab buffer as a String.
     *
     * @return a string as the contents.
     */
    @Override
    public String toString() {
        String result = "";
        for (int n = 0; n < this.backingData.length; n++) {
            if (this.indexLeftCursor == this.indexRightCursor) {
                result += this.backingData[n];
            }
            if (n < this.indexLeftCursor || n > this.indexRightCursor) {
                result += this.backingData[n];
            }
        }
        return result;
    }
}
