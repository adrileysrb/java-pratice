package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex02OperacoesIntermediarias {

    public record Pessoa(String nome, Integer idade, String genero) {
    }

    public record Aluno(String nome, Double nota) {
    }

    public record Escola(String nome, List<Aluno> alunos) {
    }

    public static void main(String[] args) {
        exemplo01();
        exemplo02();
        exemplo03();
        exemplo04();
    }

    // Filtrar os nomes que começam com a letra A da lista de nomes: Alice, Bob,
    // André, Ana, Carlos.
    public static void exemplo01() {
        List<String> nomes = Arrays.asList("Alice", "Bob", "André", "Ana", "Carlos");
        List<String> nomesFiltrados = nomes.stream().filter(p -> p.startsWith("A")).collect(Collectors.toList());
        nomes.stream().forEach(System.out::println);
        System.out.println("------- // -------");
        nomesFiltrados.stream().forEach(System.out::println);
    }

    // Filtrar números pares do seguinte lista de inteiros: 0, 1, 2, 3, 4 e 5
    public static void exemplo02() {
        List<Integer> numeros = Stream.iterate(0, n -> n + 1).limit(6).collect(Collectors.toList());
        numeros.stream().forEach(System.out::println);
        System.out.println("------- // -------");
        List<Integer> numerosPares = numeros.stream().filter(n -> n % 2 == 0 && n != 0).collect(Collectors.toList());
        numerosPares.stream().forEach(System.out::println);
    }

    // Filtrar e agrupar objetos.
    public static void exemplo03() {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 30, "Feminino"),
                new Pessoa("Bob", 20, "Masculino"),
                new Pessoa("André", 25, "Masculino"),
                new Pessoa("Ana", 35, "Feminino"),
                new Pessoa("Carlos", 22, "Masculino"));

        Map<String, List<Pessoa>> pessoasFiltradas = pessoas.stream().filter(p -> p.idade > 22)
                .collect(Collectors.groupingBy(p -> p.genero));
        System.out.println(pessoasFiltradas);
    }

    // Filtragem com Operações em Objetos Aninhados
    public static void exemplo04() {
        List<Escola> escolas = Arrays.asList(
                new Escola("Escola A", Arrays.asList(new Aluno("Alice", 8.5), new Aluno("Bob", 6.5))),
                new Escola("Escola B", Arrays.asList(new Aluno("Carlos", 7.5), new Aluno("Diana", 9.0))),
                new Escola("Escola C", Arrays.asList(new Aluno("Eva", 5.0), new Aluno("Frank", 4.0))));

        List<Escola> escolasFiltradas = escolas.stream()
                .filter(escola -> escola.alunos.stream().anyMatch(aluno -> aluno.nota > 5))
                .collect(Collectors.toList());
        System.out.println(escolasFiltradas);
    }

}
