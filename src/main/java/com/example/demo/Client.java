package com.example.demo;

import com.example.demo.Models.Pacientes;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;



    private ObjectInput objectInput;
    private ObjectOutputStream objectOutputStream;
    Pacientes paciente;

    public Client(Socket socket){
        try {
            this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            this.objectInput = new ObjectInputStream(socket.getInputStream());

        }
        catch (IOException ex){
            closeEverything(socket, objectInput, objectOutputStream);
        }
    }

    public void sendObject() {
        try {
            if (paciente != null) {
                objectOutputStream.writeObject(paciente);
                objectOutputStream.flush();
                System.out.println("Pacientes object sent to the server");
            }
        }

        catch(IOException e){
            closeEverything(socket, objectInput, objectOutputStream);
        }

    }


    public void closeEverything(Socket socket, ObjectInput objectInput, ObjectOutputStream objectOutputStream){
        try{
            if(objectInput != null){
                objectInput.close();
            }
            if(objectOutputStream != null){
                objectOutputStream.close();
            }
            if(socket != null){
                socket.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }



}
