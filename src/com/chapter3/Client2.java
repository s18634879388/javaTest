package com.chapter3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Administrator on 2017/3/1.
 */
public class Client2{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",10087);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        String str;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        new Thread(new ClientThread(socket)).start();
        while ((str=bufferedReader.readLine())!=null){
            printWriter.print(str);
//            printWriter.flush();
        }
//        printWriter.close();
//        bufferedReader.close();
//        socket.close();

    }

    private static class ClientThread implements Runnable{
        private Socket socket = null;
        BufferedReader bufferedReader = null;
        public ClientThread(Socket socket) throws IOException {
            this.socket = socket;
            bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        }


        @Override
        public void run() {
            String str;
            try {
                while ((str = bufferedReader.readLine())!=null){
                    System.out.println("来自服务器："+str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
//            finally {
//                if (bufferedReader!=null){
//                    try {
//                        bufferedReader.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                if (socket!=null){
//                    try {
//                        socket.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
        }
    }

}
