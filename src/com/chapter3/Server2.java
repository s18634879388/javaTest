package com.chapter3;

import java.io.*;
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
        boolean flag = true;

        public ServerThread(Socket socket) throws IOException {
            this.socket = socket;
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            sockets.add(this);

        }

        @Override
        public void run() {

            while (true){
                if (!flag){
                    break;
                }
                String str;
                try {
                    while ((str = bufferedReader.readLine())!=null){
                        if ((str.substring(str.length()-4)).equalsIgnoreCase("quit")){
                            sockets.remove(this);
                            flag = false;
                            printWriter.println("disconnect");
                            break;
                        }
                        System.out.println(str);
                        //-----循环发送给每一个客户端
                        for (ServerThread st:sockets
                                ) {
                            st.printWriter.println(str);
                        }
                    }

                } catch (IOException e) {
//                    Server2.sockets.remove(socket);
                    e.printStackTrace();

                }
                finally {
                    if (socket!=null){
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }

}
