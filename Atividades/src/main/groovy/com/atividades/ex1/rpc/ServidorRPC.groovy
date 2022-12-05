package com.atividades.ex1.rpc


import org.apache.xmlrpc.server.PropertyHandlerMapping
import org.apache.xmlrpc.server.XmlRpcServer
import org.apache.xmlrpc.webserver.WebServer

class ServidorRPC {

    private ServidorRPC(){
        try{
            //Cria servidor na porta 8185
            def ws = new WebServer(8080)
            XmlRpcServer servidor = ws.getXmlRpcServer()

            //Adiciona "Handler" ao PHM
            PropertyHandlerMapping phm = new PropertyHandlerMapping()
            phm.addHandler("Func", Funcionario.class)

            //Define um handler no servidor
            servidor.setHandlerMapping(phm)
            ws.start()
            println "Servidor inicializado com sucesso"
        }
        catch (Exception e)
        {
            System.err.println("JAVASERVER: ${e}")
        }
    }

    static void main(String[] args) {
        new ServidorRPC()
    }

}
