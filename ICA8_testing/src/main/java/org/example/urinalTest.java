package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

public class urinalTest {
    @Test
    public void testCase1(){
        assertEquals(1, new urinals().logic("10001"));
        System.out.println("=== Jay Chiddarwar == TEST TWO EXECUTED ====");
    }

    @Test
    public void fileDoesntExist(){
        String filename = "urinal.dat";
        File file = new File(filename);

        assertTrue(file.exists());
    }

    @Test
    public void emptyFile(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("urinal.dat"));
            assertNotNull(br.readLine());
        } catch (Exception e){
            System.err.println(e);
        }
    }
    @Test
    public void testInvalidString(){
        assertEquals(-1, new urinals().invalidCharacter("1012"));
    }




//    @Test
//    public void testValidString(){
//        assertEquals(1, new urinals().validString("10101"));
//    }
//
//    @Test
//    public void testFromKeyboard(){
//        assertEquals(1, new urinals().validString("10101"));
//    }
}
