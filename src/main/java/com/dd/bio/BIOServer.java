package com.dd.bio;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {
    private static int DEFAULT_PORT = 8060;//默认端口号
    private static ServerSocket serverSocket;//服务接受
    public static void star()throws IOException {
        star(DEFAULT_PORT);
    }

    public synchronized static void star(int port) throws IOException{
        if(serverSocket != null){
            return;
        }
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("服务端已启动，端口号:" + port);
            while(true){
                Socket socket = serverSocket.accept();
                new Thread(new ServerHandler(socket)).start();
            }
        }finally {

        }
    }
}
