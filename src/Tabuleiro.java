public class Tabuleiro {
    private final int LINHAS = 3;
    private final int COLUNAS = 3;
    private Marcas[][] marcacao = new Marcas[LINHAS][COLUNAS];
    private final int NUMERO_CASAS = LINHAS * COLUNAS;
    private int casas_marcadas;

    public boolean marcar(int x, int y, Marcas marca)
    {
        boolean sucesso = false;
        if (x < LINHAS && y < COLUNAS)
        {
            if (marcacao[x][y] == Marcas.LIVRE)
            {
                marcacao[x][y] = marca;
                casas_marcadas++;
                sucesso = true;
            }
        }
        return sucesso;
    }

    public void visualizar()
    {
        System.out.print("\n    ");
        for (int y = 0; y < COLUNAS; y++) System.out.print(" [" + y + "] ");
        System.out.println();

        for (int x = 0; x < LINHAS; x++)
        {
            System.out.print("[" + x + "] ");
            for (int y = 0; y < COLUNAS; y++)
            {
                System.out.print("  ");
                switch(marcacao[x][y])
                {
                    case LIVRE: System.out.print('_'); break;
                    case CRUZ: System.out.print('X'); break;
                    case BOLA: System.out.print('O');
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public void limpar()
    {
        for (int x = 0; x < LINHAS; x++)
        {
            for (int y = 0; y < COLUNAS; y++)
            {
                marcacao[x][y] = Marcas.LIVRE;
            }
        }
        casas_marcadas = 0;
    }

    public ResultadoJogada verificar_jogada(Casa casa_marcada)
    {
        ResultadoJogada resultado = ResultadoJogada.ABERTO;

        if (    linha_completa(casa_marcada.linha, casa_marcada.marca) ||
                coluna_completa(casa_marcada.coluna, casa_marcada.marca) ||
                diagonal_completa(casa_marcada.marca) )
        {
            resultado = ResultadoJogada.VITORIA;
        }
        else if (casas_marcadas == NUMERO_CASAS)
        {
            resultado = ResultadoJogada.EMPATE;
        }

        return resultado;
    }

    private boolean linha_completa(int linha, Marcas marca)
    {
        boolean completa = true;
        int coluna = 0;
        while (coluna < COLUNAS && completa)
        {
            if (marcacao[linha][coluna] == marca)
                coluna++;
            else
                completa = false;
        }
        return completa;
    }

    private boolean coluna_completa(int coluna, Marcas marca)
    {
        boolean completa = true;
        int linha = 0;
        while (linha < LINHAS && completa)
        {
            if (marcacao[linha][coluna] == marca)
                linha++;
            else
                completa = false;
        }
        return completa;
    }

    private boolean diagonal_completa(Marcas marca)
    {
        boolean completa = true;

        int linha = 0;
        int coluna = 0;
        while (completa & linha < LINHAS && coluna < COLUNAS)
        {
            if (marcacao[linha][coluna] == marca)
            {
                linha++;
                coluna++;
            }
            else
                completa = false;
        }

        if (!completa)
        {
            completa = true;
            linha = LINHAS - 1;
            coluna = 0;
            while (completa & linha >= 0 && coluna < COLUNAS)
            {
                if (marcacao[linha][coluna] == marca)
                {
                    linha--;
                    coluna++;
                }
                else
                    completa = false;
            }
        }
        return completa;
    }
}