public class Partida {
    private Tabuleiro tabuleiro;
    private Jogador jogador_A;
    private Jogador jogador_B;

    public Partida(Tabuleiro tabuleiro, Jogador jogador_A, Jogador jogador_B)
    {
        tabuleiro.limpar();
        tabuleiro.visualizar();
        this.tabuleiro = tabuleiro;
        this.jogador_A = jogador_A;
        this.jogador_B = jogador_B;
    }

    public Jogador executar()
    {
        Jogador vencedor = null;

        boolean resultado_em_aberto = true;
        do {
            Casa casa_marcada = jogador_A.jogar();
            ResultadoJogada resultado = tabuleiro.verificar_jogada(casa_marcada);
            switch (resultado)
            {
                case VITORIA:
                    resultado_em_aberto = false;
                    vencedor = jogador_A;
                    anunciar_vitoria(jogador_A);
                    break;
                case EMPATE:
                    resultado_em_aberto = false;
                    anunciar_empate();
                    break;
                case ABERTO:
                    casa_marcada = jogador_B.jogar();
                    resultado = tabuleiro.verificar_jogada(casa_marcada);
                    switch (resultado)
                    {
                        case VITORIA:
                            resultado_em_aberto = false;
                            vencedor = jogador_B;
                            anunciar_vitoria(jogador_B);
                            break;
                        case EMPATE:
                            resultado_em_aberto = false;
                            anunciar_empate();
                            break;
                    }
            }
        } while (resultado_em_aberto);

        return vencedor;
    }

    private void anunciar_vitoria(Jogador jogador)
    {
        System.out.print("\n==> Fim da partida!");
        System.out.println(" Vitória do jogador " + jogador.marca());
    }

    private void anunciar_empate()
    {
        System.out.println("\n==> A partida terminou empatada!");
    }
}
