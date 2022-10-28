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
    public void countUrinalTest(){
        System.out.println("====== Jay Sachin Chiddarwar == countUrinalTest TEST ONE EXECUTED =======");
        assertEquals(1, new urinals().logic("10001"));
    }

    @Test
    public void fileDoesntExist(){
        String filename = "urinal.dat";
        File file = new File(filename);

        System.out.println("====== Jay Sachin Chiddarwar == fileDoesntExist TEST TWO EXECUTED =======");
        assertTrue(file.exists());
    }

    @Test
    public void emptyFile(){
        String filename = "urinal.dat";
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            System.out.println("====== Jay Sachin Chiddarwar == emptyFile TEST THREE EXECUTED =======");
            assertNotNull(br.readLine());
        } catch (Exception e){
            System.err.println(e);
        }
    }
    @Test
    public void testInvalidString(){
        System.out.println("====== Jay Sachin Chiddarwar == testInvalidString TEST FOUR EXECUTED =======");
        assertEquals(-1, new urinals().invalidCharacter("1012"));
    }


    @Test
    public void testValidUrinals(){
        System.out.println("====== Jay Sachin Chiddarwar == testValidUrinals TEST FIVE EXECUTED =======");
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
        System.out.println("====== Jay Sachin Chiddarwar == testCreateFileName TEST SIX EXECUTED =======");
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
        System.out.println("====== Jay Sachin Chiddarwar == badFileName TEST SEVEN EXECUTED =======");
        assertEquals(1, arr.size());
    }

    @Test
    public void writeTestsComplete(){
        List<String> arr = new ArrayList<>();
        arr.add("1");
        arr.add("2");
        arr.add("-1");
        urinals urinals = new urinals();
        urinals.outputToFile(arr, 0);
        String filename = "rule1.txt";
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            System.out.println("====== Jay Sachin Chiddarwar == writeTestsComplete TEST EIGHT EXECUTED =======");
            assertNotNull(br.readLine());
        } catch (Exception e){
            System.err.println(e);
        }
    }



}
