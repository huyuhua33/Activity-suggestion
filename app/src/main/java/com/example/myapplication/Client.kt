package com.example.myapplication

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket
import java.util.*;
import kotlin.concurrent.thread

class Client {
    fun main(discrit:String,type: String): String {
        val host = "ec2-3-22-229-250.us-east-2.compute.amazonaws.com"
        val port = 8001
        val discrit = discrit

        val clientMessage = type
        try {
            val socket = Socket(host, port)
            var writer = PrintWriter(socket.getOutputStream())
            writer.write(discrit)
            writer.flush()
            Thread.sleep(500)
            writer.write(clientMessage)
            writer.flush()
            val reader = BufferedReader(InputStreamReader(socket.getInputStream()))
            var column: MutableList<String> = mutableListOf()
            var result_data: MutableList<List<String>> = mutableListOf()
            System.out.println("coneecting")
            val numberdata = reader.readLine().toString()
            System.out.println("endOfData")
            return numberdata

        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("Tag", "Socket連線有問題 !")
            Log.i("Tag", "IOException :$e")
            return ""
        }
    }


}
/*

        client.sendall(clientMessage.encode())
        print("以傳送")
        column=[]
        result_data=[]
        number_data = str(client.recv(1024), encoding='utf-8')
        print(number_data)
        for i in range(0,19):
        column.append(str(client.recv(1024), encoding='utf-8'))
        print(column)
        for i in range(0, int(number_data)):
        tmp=[]
        for j in range(0, 19):
        tmp.append(str(client.recv(1024), encoding='utf-8'))
        result_data.append(tmp)
        print(result_data)

        client.close()

*/


