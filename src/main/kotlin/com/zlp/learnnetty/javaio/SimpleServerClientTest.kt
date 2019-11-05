package com.zlp.learnnetty.javaio

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

fun main() {

    val serverSocket = ServerSocket(8080)

    val clientSocket = serverSocket.accept()

    val inStream = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
    val outStream = PrintWriter(clientSocket.getOutputStream(), true)

    var request = inStream.readLine()
    while (request != null) {
        if ("Done".equals(request)) {
            break
        }
        // do some complex process request
        val response = "Machine -> $request"
        outStream.println(response)

        request = inStream.readLine()
    }
}

