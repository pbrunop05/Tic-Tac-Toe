package tabuleiro;

import enumerados.Marcas;

public class Casa {
    int linha;
    int coluna;
    Marcas marca;

    public Casa(int linha, int coluna, Marcas marca)
    {
        this.linha = linha;
        this.coluna = coluna;
        this.marca = marca;
    }
}
