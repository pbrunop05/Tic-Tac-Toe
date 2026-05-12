public class JogoDaVelha {
    private static final int MAX_PARTIDAS = 5;
    private static final int DIFERENCA_VITORIA = 2;
    private static int empates = 0;
    private static Tabuleiro tabuleiro = new Tabuleiro();
    private static Jogador jogador_cruz = new Jogador(Marcas.CRUZ, tabuleiro);
    private static Jogador jogador_bola = new Jogador(Marcas.BOLA, tabuleiro);
    private static Jogador jogador_A = null;
    private static Jogador jogador_B = null;

    public static void main(String[] args) {
        exibir_instrucoes_gerais();
        escolher_jogadores_primeira_partida();

        int contador = 0;
        do {
            contador++;
            System.out.println("\n============== Partida número " + contador + "==============");
            Partida partida = new Partida(tabuleiro, jogador_A, jogador_B);
            Jogador vencedor = partida.executar();
            if (vencedor == jogador_A)
                jogador_A.contar_vitoria();
            else if (vencedor == jogador_B)
                jogador_B.contar_vitoria();
            else
                empates++;
            Jogador aux = jogador_A;
            jogador_A = jogador_B;
            jogador_B = aux;
        } while (contador < MAX_PARTIDAS && Math.abs(jogador_A.vitorias() - jogador_B.vitorias()) < DIFERENCA_VITORIA);

        exibir_resultado_geral();
    }

    private static void exibir_instrucoes_gerais()
    {
        System.out.println("JOGO DA VELHA");
        System.out.println("O jogo é composto por uma sequência de partidas entre dois jogadores.");
        System.out.println("Um jogador é denominado BOLA, enquanto o outro é denominado CRUZ.");
        System.out.println("O jogo termina quando um dos jogadores alcançar " + DIFERENCA_VITORIA + " vitória(s) a mais que o outro," +
                " ou, se o número de partidas chegar a " + MAX_PARTIDAS + ".");
        System.out.println("O jogador que inicia a primeira partida é escolhido de modo aleatório.");
        System.out.println("Para as partidas subsequentes, os jogadore1s se alternam para dar o início.");
        System.out.println("==================================================================");
    }

    private static void escolher_jogadores_primeira_partida()
    {
        if (Math.random() < 0.5)
        {
            jogador_A = jogador_cruz;
            jogador_B = jogador_bola;
        }
        else
        {
            jogador_A = jogador_bola;
            jogador_B = jogador_cruz;
        }
    }
    private static void exibir_resultado_geral()
    {
        System.out.println("\n==================================================================");
        System.out.println("Fim do Jogo!");
        System.out.println("Vitórias do jogador " + jogador_cruz.marca() + ": " + jogador_cruz.vitorias());
        System.out.println("Vitórias do jogador " + jogador_bola.marca() + ": " + jogador_bola.vitorias());
        System.out.println("Empates " + empates);

        if (jogador_cruz.vitorias() > jogador_bola.vitorias())
            System.out.println("Portanto, vitória geral do jogador " + jogador_cruz.marca());
        else if (jogador_bola.vitorias() > jogador_cruz.vitorias())
            System.out.println("Portanto, vitória geral do jogador " + jogador_bola.marca());
        else
            System.out.println("Portanto, empate geral entre os jogadores");

        System.out.println("=========1=========================================================");
    }
}
