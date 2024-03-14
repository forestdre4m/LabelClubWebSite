package com.forestdre4m.labelclub;

import java.io.IOException;


public class lfmStarter {

    public static void main(String[] args) {
        try {
            String exe = "C:\\Users\\FORRE\\AppData\\Local\\Programs\\Python\\Python38\\python.exe";
            String py = "C:\\Users\\FORRE\\Desktop\\LabelClubWebsite\\labelClubServer\\src\\main\\java\\com\\forestdre4m\\labelclub\\LFM.py";
            Process process = Runtime.getRuntime().exec(exe + " " + py);
            System.out.println("LFMed Just Now...");

        } catch (IOException e) {
            System.out.println("调用python脚本时出错：" + e.getMessage());
        }

    }


}