package com.chapter3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/3/1.
 */
public class Server {
    public static void main(String[] args) throws IOException {
//        String s = InetAddress.getLocalHost().getHostAddress().toString();
//        System.out.println(s);
        while (true){
            start();
        }

    }
    public static void start() throws IOException{
        ServerSocket serverSocket = new ServerSocket(10088);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        OutputStream outputStream = socket.getOutputStream();
        String len;
        StringBuffer tt = new StringBuffer();
        while ((len = bufferedReader.readLine())!=null){
            System.out.println(len);
            tt.append(len);
        }
        socket.shutdownInput();
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write(tt.toString());
        printWriter.flush();
        printWriter.close();
        outputStream.close();
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
