package com.atividades.ex1.socket

class Server {
    static void main(String[] args) throws IOException{
        def serverSocket = new ServerSocket(8080)
        println "Port 8080 open"
        println "Awaiting for new connections..."

        def socket = serverSocket.accept()

        println "Client ${socket.getInetAddress().getHostAddress()} connected"

        def entrada = new DataInputStream(socket.getInputStream())

        def nome = entrada.readUTF()

        def cargo = entrada.readUTF()

        def salario = entrada.readDouble()


        if(cargo.equals('Operador')){
            salario = salario*1.2
        }
        else{
            salario = salario*1.18
        }

        def saida = new DataOutputStream(socket.getOutputStream())
        saida.writeUTF("Nome: ${nome}\nSalario reajustado: R\$${salario}")

        entrada.close()
        saida.close()

        socket.close()
        serverSocket.close()
    }
}
