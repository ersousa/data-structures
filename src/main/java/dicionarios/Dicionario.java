package dicionarios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Dicionario {
    public static void main(String[] args) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("nome", "Bruno");
//        map.put("idade", 21);
//
//        Set<Map.Entry<String, Object>> entries = map.entrySet();
//        for (Map.Entry entry : entries) {
//            System.out.println("Chave: "+entry.getKey()+", Valor: "+entry.getValue());
//        }
//        System.out.println(entries);
//        System.out.println();

        //pegar quaisquer informações do usuario e ao final imprimir entidade inteira (chave e valor)

        Map<String, String> mapaValores = new HashMap<>();
        getScanner(mapaValores);
    }

    private static boolean verificarContinuar(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Deseja armazenar mais alguma informação? S = Sim / N = Não ");
        String continuar = scanner.next();
        System.out.println();
        return "S".equalsIgnoreCase(continuar);
    }

    private static void getScanner(Map<String, String> mapaValores) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a informação que deseja registrar: ");
        String chave = scanner.next();
        System.out.print("Digite o valor da informação: ");
        String valor = scanner.next();
        System.out.println();
        mapaValores.put(chave, valor);

        if(verificarContinuar()){
            getScanner(mapaValores);
        } else {
            Set<Map.Entry<String, String>> entries = mapaValores.entrySet();
            System.out.println("Informações registradas: ");
            for (Map.Entry entry : entries) {
                System.out.println("Chave: "+entry.getKey()+", Valor: "+entry.getValue());
            }
        }
    }

}
