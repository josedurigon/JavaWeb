package com.example.demo.connection;

import com.example.demo.Models.Pacientes;
import com.example.demo.process.Process;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;


public class Client {
    private Socket socket;
    private ObjectInput objectInput;
    private ObjectOutputStream objectOutputStream;
    private static ArrayList<Document> filaArray;

    public Client(Socket socket) {
        try {
            this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            this.objectInput = new ObjectInputStream(socket.getInputStream());
            this.filaArray = new ArrayList<>();
            new Thread(() -> {
                try {
                    while (true) {
                        ArrayList<Pacientes> arrayListPacientes =receiveObject();
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendObject(Pacientes paciente) {
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

    public ArrayList<Pacientes> receiveObject() throws IOException, ClassNotFoundException {


        try {
                filaArray = (ArrayList<Document>) objectInput.readObject();
                System.out.println(filaArray.size());
                ArrayList<Pacientes> filaPacientes = Process.pacientesProcess(filaArray);
                return filaPacientes;

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
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
    public static ArrayList<Pacientes> use(){
        ArrayList<Document> array = filaArray;
        return Process.pacientesProcess(array);

    }

}
