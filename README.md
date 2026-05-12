# Jogo da Velha — TDE: Packages

Trabalho de Avaliação da disciplina de **Programação Orientada a Objetos** — PUCPR, 2026.

O objetivo do TDE foi refatorar um projeto de Jogo da Velha já existente, organizando as classes em **pacotes (packages)** do Java.

---

## Sobre o projeto

É um Jogo da Velha para dois jogadores rodando no terminal. Os jogadores se alternam digitando a linha e a coluna onde querem jogar, e o jogo segue até alguém vencer ou empatar.

O jogo é uma sequência de partidas (máx. 5). O primeiro jogador a abrir 2 vitórias de vantagem vence a disputa geral. Se chegar a 5 partidas sem isso, ganha quem tiver mais vitórias.

---

## Estrutura de pacotes

```
src/
├── enumerados/
│   ├── Marcas.java          # Enum: LIVRE, CRUZ, BOLA
│   └── ResultadoJogada.java # Enum: VITORIA, EMPATE, ABERTO
├── jogo/
│   ├── JogoDaVelha.java     # Classe principal (main)
│   ├── Jogador.java         # Lê a jogada do teclado
│   └── Partida.java         # Controla o loop de uma partida
└── tabuleiro/
    ├── Tabuleiro.java       # Lógica do tabuleiro 3x3
    └── Casa.java            # Representa uma célula jogada
```

---

## Como compilar e rodar

**Compilar** (a partir da pasta `src/`):

```bash
cd src
javac enumerados/*.java tabuleiro/*.java jogo/*.java
```

**Executar**:

```bash
java jogo.JogoDaVelha
```

---

## Como jogar

O tabuleiro usa índices de 0 a 2 para linhas e colunas:

```
     [0]  [1]  [2]
[0]   _    _    _
[1]   _    _    _
[2]   _    _    _
```

Na sua vez, você digita o número da linha e depois da coluna. Por exemplo, `1` e `1` marca o centro do tabuleiro.

Um jogador joga com **X (CRUZ)** e o outro com **O (BOLA)**. Quem começa é sorteado aleatoriamente na primeira partida, e depois os jogadores se alternam.

---

## Tecnologias

- Java (sem dependências externas)
- Compilado com `javac`
