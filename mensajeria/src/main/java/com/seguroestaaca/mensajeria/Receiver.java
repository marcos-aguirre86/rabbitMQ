package com.seguroestaaca.mensajeria;

public class Receiver {

    public static final String RECEIVE_METHOD_NAME = "receiveMessage";

    public void receiveMessage(String message) {
        System.out.println("El emisor a recibido el siguiente mensaje  \"" + message + '"');
    }
}
