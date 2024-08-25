package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Ex01Criacao {
    public static void main(String[] args) {

        // Criar Streams a partir de Coleções
        List<String> lista = Arrays.asList("a", "b", "c");
        Stream<String> stream = lista.stream();

        //  Criar Streams a partir de Arrays
        String[] array = {"a", "b", "c"};
        Stream<String> streamFromArray = Stream.of(array);

        // Criar Streams a partir de valores estáticos
        Stream<Integer> streamFromStaticValues = Stream.iterate(0, n -> n + 1);

        // Criar Streams a partir de arquivos
        try {
            //Stream<String> lines = Files.lines(Paths.get("file.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}