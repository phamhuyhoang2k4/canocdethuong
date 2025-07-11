/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class inter {
    private static PrintWriter send;
    private static Scanner receiver;

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(12345);
        System.out.println("Server waiting ...");

        Socket[] soc = new Socket[100];
        int m = 0;
        int[] num = new int[10];
        Core[] cores = new Core[10]; // để lưu các đối tượng Core

        while (m <= 6) { // 6 người dùng
            Socket s = ss.accept();
            soc[m] = s;

            Core core = new Core(soc[m]);
            cores[m] = core;
            num[m] = core.def;

            System.out.println("m = " + soc[m].getInetAddress() + "-" + soc[m].getPort() + " => " + core.def);
            m++;
        }

        // Chọn người thắng
        Random ran = new Random();
        int go = ran.nextInt(6); // chỉ số người thắng

        System.out.println("KQ: " + num[go]);
        System.out.println("CHM: " + soc[go].getPort());

        // Gửi thông báo cho từng người
        for (int i = 0; i < 6; i++) {
            PrintWriter writer = new PrintWriter(soc[i].getOutputStream(), true);
            if (i == go) {
                writer.println("Chuc mung chien thang");
            } else {
                writer.println("Chuc ban may man");
            }
        }
    }
}

