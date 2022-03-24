package com.pmart5a.csapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8090);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("Новое соединение установлено");
            out.println("Введите Ваше имя");
            String name = in.readLine();
            out.println("Вы, ребенок? (да/нет)");
            String yesOrNo = in.readLine();
            if (yesOrNo.equals("да")) {
                out.println(String.format("Добро пожаловать в детскую зону, %s! Давайте играть!", name));
            } else {
                out.println(String.format("Добро пожаловать в зону для взрослых, %s! Хорошего отдыха или хорошего" +
                        " рабочего дня!", name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Соединение закрыто");
    }
}