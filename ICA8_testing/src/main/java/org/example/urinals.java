package org.example;

public class urinals {
    public static void main(String[] args) {
        String str = "10101";
        int ans = logic(str);




    }

    public void openFile(){

    }

    public static int logic(String inp){
        char[] temp = inp.toCharArray();
        int counter = 0;
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

        System.out.println(temp);
        System.out.println(counter);
        return counter;
    }
}
