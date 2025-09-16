# 🏭 Projeto Teste Prático - Programação em Java

Este projeto foi desenvolvido como parte de um **teste prático de programação**, utilizando **Java 21**.  
O objetivo é trabalhar com conceitos de **POO (Programação Orientada a Objetos)** e **coleções em Java**, simulando a gestão de funcionários em uma indústria.

---

## 📌 Funcionalidades Implementadas
- Classe **Pessoa** com atributos básicos (nome e data de nascimento).
- Classe **Funcionario** estendendo Pessoa, com atributos adicionais (salário e função).
- Inserção de funcionários em uma lista.
- Remoção de funcionário específico.
- Impressão de dados formatados:
  - Datas no formato `dd/MM/yyyy`
  - Salários no formato brasileiro (milhar com ponto, decimal com vírgula).
- Aplicação de **aumento salarial (10%)**.
- Agrupamento de funcionários por função em um `Map`.
- Filtro por aniversariantes dos meses **10 (outubro)** e **12 (dezembro)**.
- Identificação do funcionário com maior idade.
- Ordenação alfabética da lista de funcionários.
- Cálculo do **total dos salários**.
- Cálculo de **quantos salários mínimos** cada funcionário recebe (considerando R$1212,00).

---

## 🛠️ Tecnologias Utilizadas
- **JDK 21**
- **Paradigma de Programação Orientada a Objetos**
- **API de Datas (LocalDate, Period, DateTimeFormatter)**
- **Streams e Lambda Expressions**
- **BigDecimal** para cálculos monetários

---

## ▶️ Como Executar
1. Clone este repositório:
   ```bash
   git clone https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git

Abra o projeto em sua IDE (Eclipse, IntelliJ ou VS Code)
Compile e execute a classe Principal.

📌 Observações

O projeto foi desenvolvido em Java puro, sem frameworks adicionais.
