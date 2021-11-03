# Dominós - Projeto e Otimização de Algoritmos - 2019/2

Implementação em Java para, dado um conjunto de peças de dominó (numeradas de 0 a 10), verificar se há uma forma de conectar as mesmas ponta a ponta, de modo que seja formada uma cadeia. A verificação é feita por meio de um algoritmo *backtracking*, sendo a sequência exibida ao final da execução (caso exista).

- Exemplo:

    - Entrada:\
    3       # Número de peças\
    3 4     # Primeira peça\
    2 1     # Segunda peça\
    1 3     # Terceira peça

    - Saída:\
    4 3 3 1 1 2

## Requisitos

JDK e JRE (testado com Oracle Java 11)

## Execução

- Compilação:

    javac Dominos.java

- Execução:

    java Dominos

## Licença

[MIT](https://choosealicense.com/licenses/mit/)
