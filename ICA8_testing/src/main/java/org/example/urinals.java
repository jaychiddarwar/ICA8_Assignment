package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class urinals {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(System.in);
        String inp = "";
        System.out.println("How you want ot proceed \n1. Keyboard \n2. File");
        inp = sc.next();
        boolean valid = true;
        String type ="" ;
        if (inp.equals("1") || inp.equalsIgnoreCase("keyboard")){
            type = "Keyboard";
        }else if(inp.equalsIgnoreCase("2" ) || inp.equalsIgnoreCase("file")){
            type = "File";
        }else {
            System.out.println("Invalid Input, Please run Program again");
            valid = false;

        }

        if (valid){
            urinals u = new urinals();
            List<String> arr ;
            List<String> results = new ArrayList<>();
            if(type.equalsIgnoreCase("file")){
                arr = u.openFile();

            } else{
                arr = u.getInputFromKeyboard();

            }
            for(String val : arr){
                String ans = "";
                if(u.validStringUrinals(val) == -1){
                    results.add(String.valueOf(-1));
                    ans = "-1";

                } else if (u.invalidCharacter(val) == -1) {
                    results.add(String.valueOf(-1));
                    ans = "-1";

                } else {
                    ans = "" +  u.logic(val);
                    results.add(ans);
                }
                System.out.println("For String `" + val + "` answer is : " + ans);
            }
            String ans = u.createFileName();
            u.outputToFile(results, Integer.parseInt(ans));

        }




    }

    public void outputToFile(List<String> result, int counter){
        try{
            File file, rename;
            if (counter == 0){

                file = new File("rule" +".txt");
            }
            else {
                file = new File("rule" + counter +".txt");
            }
            rename = new File("rule" + ++counter + ".txt");
            file.renameTo(rename);

            FileWriter fileWriter = new FileWriter("rule" + counter +".txt");
            for (String val:result){
                fileWriter.write(val + "\n");
            }
            fileWriter.close();
        } catch (IOException e){
            System.err.println(e);
        }

    }

    public String createFileName(){
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
        System.out.println(ans);
        return ans;
    }

    public List<String> openFile() throws FileNotFoundException{
        List<String> strs = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader("urinal.dat");
            Scanner freader = new Scanner(fileReader);
            while(freader.hasNextLine()){
//                System.out.println(freader.nextLine());
                strs.add(freader.nextLine());

            }
            return strs;
        }catch (FileNotFoundException e){
            System.err.println(e);
            throw e;
        }
    }

    public List<String> getInputFromKeyboard() {
        List<String> strs = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        while(!temp.equals("-1")){
            strs.add(temp);
            temp = sc.nextLine();
        }

        return strs;
    }

    public int validStringUrinals(String inp){
        char[] temp = inp.toCharArray();
        for(int i = 0; i < temp.length; i++){
            if(temp[i] == '1' && i + 1< temp.length && temp[i+1] == '1'){
                return -1;
            }
        }
        return 1;
    }

    public int invalidCharacter(String inp){
        char[] temp = inp.toCharArray();
        for(int i = 0; i < temp.length; i++){
            if(temp[i]!='0' && temp[i]!='1'){
                return -1;
            }
        }
        return 1;
    }


    public int logic(String inp){
        char[] temp = inp.toCharArray();
        int counter = 0;
        if (temp.length == 1  ){
            if (temp[0] == '0'){
                return 1;
            }
            else {
                return 0;
            }
        }
        if (temp[0] == '0' && temp[1] == '0' ){
            counter++;
            temp[0] = '1';
        }
        if (temp[inp.length() -1 ] == '0' && temp[inp.length() -2] == '0'){
            counter ++;
            temp[inp.length() -1 ] = '1';
        }

        for (int i =1 ; i < temp.length -1 ; i++){
            if (temp[i] == '0' && i -1 > 0 && i +1 < temp.length && temp[i-1] == '0' && temp[i+1] == '0'){
                counter++;
                temp[i] = '1';
            }
        }

//        System.out.println(temp);
//        System.out.println(counter);
        return counter;
    }
}
