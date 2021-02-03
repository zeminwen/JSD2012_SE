package homework.day09;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;

    public Client() {
        try {
            System.out.println("正在连接服务器：");
            socket = new Socket("localhost", 8088);
            System.out.println("与服务器建立连接");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream(), "utf-8"
                        )
                ), true
        );
        ) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入内容，单独输入exit退出");
            while (true) {
                String line = scanner.nextLine();
                if ("exit".equals(line)) {
                    break;
                }
                pw.println(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}