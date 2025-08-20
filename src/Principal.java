import model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
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

        //Imprime aniversariantes.
        System.out.println("\n---- Funcionários que Fazem Aniversário nos meses 10 e 12 ----\n");
        funcionarios.stream()
                .filter(f -> {
                    int mes = f.getDataNascimento().getMonthValue();
                    return mes == 10 || mes == 12;
                })
                .forEach(f -> System.out.println(f.getNome() + " - " + f.getDataNascimento()));

        // Imprime o funcionário mais velho.
        System.out.println("\n---- Funcionário mais Velho ----\n");
        Funcionario maisVelho = funcionarios.stream()
                .max(Comparator.comparing(f -> Period.between(f.getDataNascimento(), LocalDate.now()).getYears()))
                .orElse(null);
        if (maisVelho != null) {
            int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
            System.out.println(maisVelho.getNome() + " - " + idade);
        }

        //Imprime na ordem alfabética.
        System.out.println("\n---- Ordem Alfabética ----\n");
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
        funcionarios.forEach(f -> System.out.println(f.getNome()));

        //Imprime o total dos salários.
        System.out.println("\n---- Total dos Salários ----\n");
        BigDecimal total = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("R$ " + total);

        // Imprime a quantidade de salários minimos com base em R$1.212,00.
        System.out.println("\n---- Quantidade de Salários Mínimos ----\n");
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        funcionarios.forEach(f -> {
            BigDecimal quantidadeSalarios = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " - " + quantidadeSalarios + " salários.");
        });
    }
}

          /* Tive uma certa dificuldade com Map e Stream, não lembrava de todas das funções para definir o uso,
          * precisei fazer uma breve revisão em algumas anotações e códigos que já tinha feito para utilizar como exemplo,
          * algumas funções não tinha estudado até agora, tive que aprender a utilizar. */
