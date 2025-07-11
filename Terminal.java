/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Client;



import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Terminal {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        PrintWriter send = new PrintWriter(socket.getOutputStream(), true);
        Scanner receive = new Scanner(socket.getInputStream());

        try {
            System.out.println("From Server - Your Number: " + receive.nextLine());  // dòng đầu: số random
            System.out.println("From Server - Result: " + receive.nextLine());        // dòng 2: kết quả thắng/thua
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

