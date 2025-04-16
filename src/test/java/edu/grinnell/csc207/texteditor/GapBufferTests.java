package edu.grinnell.csc207.texteditor;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class GapBufferTests {
    @Test
    public void bigBufferTest() {
        GapBuffer buf = new GapBuffer();
        for (int i = 0; i < 16384; i++) {
            buf.insert((char) (i % 10 + '0'));
        }
        assertEquals(16384, buf.getSize(), "size");
        assertEquals(16384, buf.getCursorPosition(), "cursor");

        for (int i = 0; i < 300; i++) {
            buf.moveLeft();
        }
        buf.insert('!');
        buf.insert('!');
        buf.delete();
        assertEquals(16385, buf.getSize(), "size");
        assertEquals(16085, buf.getCursorPosition(), "cursor");
    }
    
    @Test
    public void normalInsertTest() {
        GapBuffer sample = new GapBuffer();
        sample.insert('a');
        assertEquals("a", sample.toString());
        sample.insert('b');
        sample.insert('c');
        assertEquals("abc", sample.toString());       
    }
    
    @Test
    public void edgeCaseInsert() {
        GapBuffer sample = new GapBuffer();
        sample.insert('a');
        sample.insert('b');
        sample.insert('c');
        sample.moveLeft();
        sample.moveLeft();
        sample.moveLeft();
        sample.insert('a');
        assertEquals("aabc", sample.toString());
    }
    
    @Test
    public void getCharTest(){
        GapBuffer sample = new GapBuffer();
        sample.insert('a');
        sample.insert('b');
        sample.insert('c');
        assertEquals('a', sample.getChar(0));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            sample.getChar(-1);
        });
    }
    
    @Test
    public void getSizeTest() {
        GapBuffer sample = new GapBuffer();
        sample.insert('h');
        assertEquals(1, sample.getSize());
        sample.insert('e');
        assertEquals(2, sample.getSize());
        sample.insert('y');
        assertEquals(3, sample.getSize());    
    }
    
    @Test
    public void moveAndGetPositionTest(){
        GapBuffer sample = new GapBuffer();
        sample.insert('a');
        sample.insert('b');
        sample.insert('c');
        assertEquals(3, sample.getCursorPosition());
        for (int n = 0; n < sample.getSize() + 1; n++) {
            sample.moveLeft();
        }
        assertEquals(0, sample.getCursorPosition());    
        for (int n = 0; n < sample.getSize() + 1; n++) {
            sample.moveRight();
        }
        assertEquals(3, sample.getCursorPosition());  
    }
    
    @Test
    public void insertTests() {
        GapBuffer sample = new GapBuffer();
        sample.insert('a');
        sample.insert('b');
        sample.insert('c');
        //Edge cases
        sample.insert('d');
        assertEquals("abcd", sample.toString());
        for (int n = 0; n < sample.getSize() + 1; n++) {
            sample.moveLeft();
        }
        sample.insert('e');
        assertEquals("eabcd", sample.toString());
    }
    
    @Test
    public void deleteTests(){
        GapBuffer sample = new GapBuffer();
        sample.insert('c');
        sample.insert('s');
        sample.insert('c');
        sample.delete();
        assertEquals("cs", sample.toString());
        //Edge cases
        for (int n = 0; n < sample.getSize() + 1; n++) {
            sample.moveLeft();
        }
        sample.delete();
        assertEquals("cs", sample.toString());
    }   
    
    @Test
    public void arrayExpansion() {
       GapBuffer sample = new GapBuffer();
        sample.insert('i');
        sample.insert('l');
        sample.insert('o');
        sample.insert('v');
        sample.insert('e');
        sample.insert('c');
        sample.insert('s');
        sample.insert('c');
        sample.insert('n');
        sample.insert('o');
        sample.insert('w');
        assertEquals(11, sample.getSize());    
    }

    @Property
    public void nonNegativeSize(@ForAll @IntRange(min = 0, max = 20) int size) {
        GapBuffer sample = new GapBuffer();
        for(int n = 0 ; n < size; n ++) {
            sample.insert('a');
        } 
        assertTrue(sample.getSize() >= 0);
    }  
}
