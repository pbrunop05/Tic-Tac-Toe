import java.util.Scanner;
public class Jogador {
    private Marcas marca;
    private int vitorias;
    private Tabuleiro tabuleiro;
    private Scanner teclado = new Scanner(System.in);

    public Jogador(Marcas marca, Tabuleiro tabuleiro)
    {
        this.marca = marca;
        vitorias = 0;
        this.tabuleiro = tabuleiro;
    }

    public Casa jogar()
    {
        int linha;
        int coluna;
        boolean sucesso = false;
        do {
            System.out.print("\nJogador " + marca);
            System.out.print(", digite o número de uma linha: ");
            linha = teclado.nextInt();
            System.out.print("Agora, digite o número de uma coluna: ");
            coluna = teclado.nextInt();
            sucesso = tabuleiro.marcar(linha, coluna, marca);
            if (sucesso)
                tabuleiro.visualizar();
            else
                System.out.println("ERRO: Jogada inválida! Tente novamente.");
        } while (!sucesso);
        return new Casa(linha, coluna, marca);
    }

    public Marcas marca() { return marca; }

    public void contar_vitoria() { vitorias++; }
    public int vitorias() { return vitorias; }
}
