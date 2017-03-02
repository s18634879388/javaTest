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


    private  Socket socket = null;
    private BufferedReader bufferedReader = null;
    private  PrintWriter printWriter = null;

    public static void main(String[] args) throws IOException {
            new Client2().startup();

    }
    public void startup() throws IOException {
        socket = new Socket("localhost",10087);
        printWriter = new PrintWriter(socket.getOutputStream(),true);
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printWriter.println("laosan:");
        String str;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        new Thread(new ClientThread()).start();
        while ((str=bufferedReader.readLine())!=null){
            printWriter.println(str);
        }
    }


    private class ClientThread implements Runnable{

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
        }
    }

}
