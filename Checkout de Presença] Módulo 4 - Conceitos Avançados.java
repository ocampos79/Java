import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ColecoesAvancadas {

    public static void main(String[] args) {
        // Criando conjunto com as 10 primeiras letras do alfabeto (maiúsculas) + null
        Set<Character> letras = new HashSet<>();
        for (char c = 'A'; c <= 'J'; c++) {
            letras.add(c);
        }
        letras.add(null); // adicionando null

        // Criando mapa com índices 0-9 como chave e letras como valor
        Map<Integer, Character> mapa = new HashMap<>();
        int index = 0;
        for (char c = 'A'; c <= 'J'; c++) {
            mapa.put(index, c);
            index++;
        }

        // Exibindo os pares do mapa
        System.out.println("Mapa de índices e letras:");
        for (Map.Entry<Integer, Character> entry : mapa.entrySet()) {
            System.out.println("Chave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }

        System.out.println("\nConjunto de letras:");
        for (Character letra : letras) {
            try {
                // Isso irá lançar NullPointerException ao chamar toString() em null
                System.out.println("Letra: " + letra.toString());
            } catch (NullPointerException e) {
                System.out.println("Exceção capturada: NullPointerException ao acessar elemento null.");
                writeFile("erro.txt");
            }
        }
    }

    public static void writeFile(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("Erro ao percorrer coleção!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
