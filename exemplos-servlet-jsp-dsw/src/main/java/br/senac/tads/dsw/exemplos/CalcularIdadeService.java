/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package br.senac.tads.dsw.exemplos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CalcularIdadeService {

    public long calcular(String data) {
        long idade = -1;
        if (data != null) {
            idade = ChronoUnit.YEARS.between(LocalDate.parse(data), LocalDate.now());
        }
        return idade;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Digite a data de nascimento no formato yyyy-MM-dd (ex: 1990-10-25):");
            String dataStr = in.nextLine();

            CalcularIdadeService calcIdade = new CalcularIdadeService();
            long idade = calcIdade.calcular(dataStr);

            System.out.println("Sua idade é " + idade + " anos");
        }
    }

}
