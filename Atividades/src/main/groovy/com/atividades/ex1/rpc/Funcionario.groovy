package com.atividades.ex1.rpc

class Funcionario {
    String nome
    String cargo
    double salario

    def calculaSalario(String cargo, double salario){
        if(cargo.equals("Operador")){
            return salario*1.2
        }
        else{
            return salario*1.18
        }
    }
}
