
package edu.grinnell.csc207.texteditor;

import org.junit.jupiter.api.Test;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleStringBufferTests {
    
    @Test
    public void normalInsertTest() {
        SimpleStringBuffer sample = new SimpleStringBuffer();
        sample.insert('a');
        assertEquals("a", sample.toString());
        sample.insert('b');
        sample.insert('c');
        assertEquals("abc", sample.toString());       
    }
    
    @Test
    public void edgeCaseInsert() {
        SimpleStringBuffer sample = new SimpleStringBuffer();
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
        SimpleStringBuffer sample = new SimpleStringBuffer();
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
        SimpleStringBuffer sample = new SimpleStringBuffer();
        sample.insert('h');
        assertEquals(1, sample.getSize());
        sample.insert('e');
        assertEquals(2, sample.getSize());
        sample.insert('y');
        assertEquals(3, sample.getSize());    
    }
    
    @Test
    public void moveAndGetPositionTest(){
        SimpleStringBuffer sample = new SimpleStringBuffer();
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
        SimpleStringBuffer sample = new SimpleStringBuffer();
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
        SimpleStringBuffer sample = new SimpleStringBuffer();
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
    
    @Property
    public void nonNegativeSize(@ForAll @IntRange(min = 0, max = 20) int size) {
        SimpleStringBuffer sample = new SimpleStringBuffer();
        for(int n = 0 ; n < size; n ++) {
            sample.insert('a');
        } 
        assertTrue(sample.getSize() >= 0);
    }
}
