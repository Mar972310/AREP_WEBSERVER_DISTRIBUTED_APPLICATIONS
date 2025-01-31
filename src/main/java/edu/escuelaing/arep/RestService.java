/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.escuelaing.arep;

/**
 *
 * @author maritzamonsalvebautista
 */
public class RestService {
    
    public String responseGET(String query, String method){
        String name = query.split("=")[1];
        String response = "HTTP/1.1. 200 OK\r\n"
                + "Content-Type: text/json\r\n"
                + "\r\n"
                + "{\"name\":\""+name+"\", \"message\":Hiciste una petición GET}";

        return response;
        
    }
    public String responsePOST(String query, String method){
        String name = query.split("=")[1];
        String response = "HTTP/1.1. 201 OK\r\n"
                + "Content-Type: text/json\r\n"
                + "\r\n"
                + "{\"name\":\""+name+"\", \"message\":Hiciste una petición POST}";

        return response;
        
    }
    
}
