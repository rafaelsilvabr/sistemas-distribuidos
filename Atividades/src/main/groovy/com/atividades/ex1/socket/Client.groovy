package com.atividades.ex1.socket

import javax.swing.JComboBox
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.JPanel
import javax.swing.JTextField
import java.awt.GridLayout

class Client {
    static void main(String[] args) throws IOException{
        def socket = new Socket("localhost", 8080)

        def funcionario = display()

        DataOutputStream saida = new DataOutputStream(socket.getOutputStream())
        saida.writeUTF(funcionario.nome)
        saida.writeUTF(funcionario.cargo)
        saida.writeDouble(funcionario.salario)


        DataInputStream entrada = new DataInputStream(socket.getInputStream())
        def newMessage = entrada.readUTF()

        JOptionPane.showMessageDialog(null, newMessage)

        entrada.close()
        saida.close()

        socket.close()
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
