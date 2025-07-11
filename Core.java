/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Core extends Thread {
    Socket socket;
    private PrintWriter send;
    private Scanner receive;
    public int def;

    public Core(Socket s) throws IOException {
        socket = s;
        send = new PrintWriter(socket.getOutputStream(), true);
        receive = new Scanner(socket.getInputStream());
        run();
    }

    public void run() {
        Random ran = new Random();
        try {
            def = ran.nextInt(1, 100);
            send.println(def);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


