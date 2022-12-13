package sorting;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno implements Comparable<Aluno> {

    private String nome;
    private Integer matricula;

    public Aluno(String nome, Integer matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "\n"+"Nome: "+getNome()+", Matricula: "+getMatricula();
    }

    @Override
    public int compareTo(Aluno aluno) {
        int ordenacaoNome = getNome().compareTo(aluno.getNome());
        if(ordenacaoNome != 0) return ordenacaoNome;
        return getMatricula().compareTo(aluno.getMatricula());
    }
}
