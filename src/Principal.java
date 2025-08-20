import model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {

        //Array para adicionar as pessoas da tabela.
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario(
            "Mária",
                LocalDate.of(2000, 10, 18),
                new BigDecimal("2009.44"),
                "Operador"
        ));

        funcionarios.add(new Funcionario(
                "João",
                LocalDate.of(1990, 5, 12),
                new BigDecimal("2284.38"),
                "Operador"
        ));

        funcionarios.add(new Funcionario(
                "Caio",
                LocalDate.of(1961, 5, 2),
                new BigDecimal("9836.14"),
                "Coordenador"
        ));

        funcionarios.add(new Funcionario(
                "Miguel",
                LocalDate.of(1988, 10, 14),
                new BigDecimal("19119.88"),
                "Diretor"
        ));

        funcionarios.add(new Funcionario(
                "Alice",
                LocalDate.of(1995, 1, 5),
                new BigDecimal("2234.68"),
                "Recepcionista"
        ));

        funcionarios.add(new Funcionario(
                "Heitor",
                LocalDate.of(1999, 11, 19),
                new BigDecimal("1582.72"),
                "Operador"
        ));

        funcionarios.add(new Funcionario(
                "Arthur",
                LocalDate.of(1993, 3, 31),
                new BigDecimal("4071.84"),
                "Cordenador"
        ));

        funcionarios.add(new Funcionario(
                "Laura",
                LocalDate.of(1994, 7, 8),
                new BigDecimal("3017.45"),
                "Gerente"
        ));

        funcionarios.add(new Funcionario(
                "Heloísa",
                LocalDate.of(2003, 5, 24),
                new BigDecimal("1606.85"),
                "Eletricista"
        ));

        funcionarios.add(new Funcionario(
                "Helena",
                LocalDate.of(1996, 9, 2),
                new BigDecimal("2799.93"),
                "Gerente"
        ));

        //Remove funcionário.
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        //Exibe lista com todos os funcionarios menos o que foi removido.
        System.out.println("\n---- Lista de Funcionários ----\n");

        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }

        //Exibe lista com os novos salários.
        System.out.println("\n---- Novos Salários com Aumento de 10% ----\n");
        for (Funcionario f : funcionarios) {
            f.setSalario(f.getSalario().multiply(new BigDecimal("1.10")));
            System.out.println(f);
        }

        //Agrupa a lista de fucionários.
        Map<String, List<Funcionario>> agruparPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        //Imprime a lista com todos os funcionários agrupados por funções.
        System.out.println("\n---- Funcionários Agrupados Por Função ----\n");
        for (Map.Entry<String, List<Funcionario>> entry : agruparPorFuncao.entrySet()) {
            System.out.println(entry.getKey());        // Imprime a funcao
            for (Funcionario f : entry.getValue()) {
                System.out.println("  " + f.getNome()); // Imprime o funcionario
            }
        }

        //Não consegui imprimir apenas o nome e a data de nascimento, está impriminto todas as informações, mas está filtrado pelo mês.
        List<Funcionario> aniversariantes = funcionarios.stream()
            .filter(f -> {
                int mes = f.getDataNascimento().getMonthValue();
                return mes == 10 || mes == 12;
            })
            .toList();
        aniversariantes.forEach(System.out::println);
    }
}
