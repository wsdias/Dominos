# Dominós - Projeto e Otimização de Algoritmos - 2019/2

Implementação em Java para, dado um conjunto de peças de dominó (numeradas de 0 a 10), verificar se há uma forma de conectar as mesmas ponta a ponta, de modo que seja formada uma cadeia. A verificação é feita por meio de um algoritmo *backtracking*, sendo a sequência exibida ao final da execução (caso exista).

- Exemplo:

    - Entrada:<br/>
    &nbsp;&nbsp;  3     &nbsp;&nbsp;&nbsp;&nbsp;  # Número de peças\
    &nbsp;&nbsp;  3 4   &nbsp;                    # Primeira peça\
    &nbsp;&nbsp;  2 1   &nbsp;                    # Segunda peça\
    &nbsp;&nbsp;  1 3   &nbsp;                    # Terceira peça

    - Saída:<br/>
    &nbsp;&nbsp;    4 3 3 1 1 2

## Requisitos

JDK e JRE (testado com Oracle Java 11)

## Execução

- Compilação:

    javac Dominos.java

- Execução:

    java Dominos

## Licença

[MIT](https://choosealicense.com/licenses/mit/)
