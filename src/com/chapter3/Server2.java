package com.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/2.
 */
public class Server2 {
    public static ArrayList<ServerThread> sockets = new ArrayList<>();
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(10087);
            while (true){
                socket = serverSocket.accept();
                new Thread(new ServerThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static class ServerThread implements Runnable{
        Socket socket = null;
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;

        public ServerThread(Socket socket) throws IOException {
            this.socket = socket;
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(),true);
            sockets.add(this);

        }

        @Override
        public void run() {

            String str;
            try {
                while ((str = bufferedReader.readLine())!=null){
                    printWriter.println("来自客户端："+str);
//                    printWriter.flush();
                }
                for (ServerThread st:sockets
                     ) {
                    st.printWriter.println(str);
                }

            } catch (IOException e) {
                Server2.sockets.remove(socket);
                e.printStackTrace();
            }
        }
    }

}
