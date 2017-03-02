package com.chapter3;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/1.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        String s = InetAddress.getLocalHost().getHostAddress().toString();
        while (true){
            Scanner scanner = new Scanner(System.in);
            Socket socket = null;
            if (scanner.hasNext()){
                socket = new Socket("localhost",10088);
            }
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write(s+":   "+"\n"+scanner.next());
            printWriter.flush();
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String len;
            while((len=bufferedReader.readLine())!=null){
                System.out.println("客户端"+len);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
            System.out.println("...............");

        }


    }
}
