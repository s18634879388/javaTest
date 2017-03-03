package com.chapter3;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2017/3/1.
 */
public class Client2{


    private  Socket socket = null;
    private BufferedReader bufferedReader = null;
    private  PrintWriter printWriter = null;
    private boolean flag = true;

    public static void main(String[] args) throws IOException {
            new Client2().startup();

    }
    public void startup() throws UnknownHostException {
        BufferedReader bufferedReader1 = null;
        String user = InetAddress.getLocalHost().getHostAddress().toString();
        try {
            socket = new Socket("172.16.15.31",10087);
//            printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"),true);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            printWriter.println(user+"上线了！");
            String str;
            bufferedReader1 = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
            new Thread(new ClientThread()).start();
            while (flag&&(str=bufferedReader1.readLine())!=null){
                if (!flag){
                    break;
                }
                printWriter.println(user+" :  "+str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader1!=null){
                try {
                    bufferedReader1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private class ClientThread implements Runnable{

        @Override
        public void run() {
            while (true){
                if (!flag){
                    break;
                }
                String str;
                try {
                    while ((str = bufferedReader.readLine())!=null){
                        if (str.equalsIgnoreCase("disconnect")){
                            flag = false;
                            System.out.println("按任意键并回车以确定退出");
                        }
                        if (!str.equalsIgnoreCase("disconnect")){
                            System.out.println(str);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
