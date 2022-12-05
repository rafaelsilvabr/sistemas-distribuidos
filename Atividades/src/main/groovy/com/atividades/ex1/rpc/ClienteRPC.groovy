package com.atividades.ex1.rpc

import org.apache.xmlrpc.client.XmlRpcClient
import org.apache.xmlrpc.client.XmlRpcClientConfig
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl

import javax.swing.JComboBox
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.JPanel
import javax.swing.JTextField
import java.awt.GridLayout

class ClienteRPC {
    //Definir a URL do Servidor
    private final String URL_SERVIDOR = "http://localhost:8080"
    private XmlRpcClient cliente

    public ClienteRPC(){
        try{
            //Configura o cliente para que ele possa se conectar ao servidor
            XmlRpcClientConfigImpl configuracaoCliente = new XmlRpcClientConfigImpl()
            configuracaoCliente.setServerURL(new URL(URL_SERVIDOR))

            //Seta a configuração no cliente
            cliente = new XmlRpcClient()
            cliente.setConfig(configuracaoCliente)
        }catch(e)
        {
            System.err.println("JAVA CLIENT: ${e}")
        }
    }

    def calculaSalario(String cargo, Double salario)throws Exception{
        Object[] parametros = new Object[]{new String(cargo), new Double(salario)}
        Double resultado = (Double) cliente.execute("Func.calculaSalario", parametros)
        return resultado
    }

    static void main(String[] args) throws Exception{
        ClienteRPC x = new ClienteRPC()

        def funcionario = display()

        JOptionPane.showMessageDialog(null, "Funcionario: ${funcionario.nome}\nNovo salário:${x.calculaSalario(funcionario.cargo,funcionario.salario)}")
    }

    static def display(){
        String[] items = ["Operador", "Programador"];
        JComboBox<String> combo = new JComboBox<>(items);
        JTextField field1 = new JTextField("Digite seu nome");
        JTextField field2 = new JTextField("Digite o seu salario");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(combo);
        panel.add(new JLabel("Nome:"));
        panel.add(field1);
        panel.add(new JLabel("Salario:"));
        panel.add(field2);
        int result = JOptionPane.showConfirmDialog(null, panel, "Test",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return [cargo: combo.getSelectedItem().toString(), nome: field1.getText(), salario: Double.parseDouble(field2.getText())]
        } else {
            System.out.println("Cancelled");
        }
    }

}
