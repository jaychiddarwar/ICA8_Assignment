package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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
        String filename = "urinal.dat";
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
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
//    public void testFile() throws FileNotFoundException{
////        FileNotFoundException exception ;
////        try{
////            new urinals().openFile();
////        }catch (FileNotFoundException e){
////            exception = e;
////        }
////        assertEquals(FileNotFoundException.class, exception);
//        FileNotFoundException thrown = assertThrows(FileNotFoundException.class, ()->new urinals().openFile(), "File not available");
//        Assertions.assertEquals("File not available", thrown.getMessage());
//    }

    @Test
    public void testValidUrinals(){
        assertEquals(-1, new urinals().validStringUrinals("11111"));
    }


    @Test
    public void testCreateFileName(){
        File file = new File("./");
        String content[] = file.list();
        String ans = "";
        for (String val :content){
            if(val.length() > 4 && val.substring(0,4).equals("rule")){
                ans = val;
                break;
            }
        }
        ans = ans.substring(0, ans.length() - 4);
        ans = ans.substring(4, ans.length());
        if (ans.equals("")){
            ans = "0";
        }
        assertEquals(ans, new urinals().createFileName());
    }

    @Test
    public void badFileName(){
        List<String> arr = new ArrayList<>();
        File file = new File("./");
        String content[] = file.list();
        for (String val :content){
            if(val.length() > 4 && val.substring(0,4).equals("rule")){
                arr.add(val);
            }
        }
        assertEquals(1, arr.size());
    }



}
