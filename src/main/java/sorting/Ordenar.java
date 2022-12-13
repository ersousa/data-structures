package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ordenar {

    public static void main(String[] args) {
        List<String> lista = new ArrayList<>(List.of("Leticia", "Samila", "Michele", "Camila"));
        lista.sort((a, b) -> a.compareTo(b));
        System.out.println(lista);
        lista.sort((a, b) -> b.compareTo(a));
        System.out.println(lista);

        List<Aluno> alunos = new ArrayList<>(List.of(
                new Aluno("Pedro", 4),
                new Aluno("Pedro", 1),
                new Aluno("Michele", 2),
                new Aluno("Ana", 3))
        );

        alunos.sort((a, b) -> a.compareTo(b));
        System.out.println(alunos);
        Comparator<Aluno> alunoComparator = Comparator.comparing(Aluno::getNome)
                .thenComparing(Aluno::getMatricula);

        alunos.sort(alunoComparator);
        System.out.println(alunos);

    }
}
