import java.util.Scanner;

public class Main{
    public static float calculeFator(float[][] matriz, int linhaAlvo, int linhaPivo, int coluna) {
        if(matriz[linhaPivo][coluna] == 0){
            System.out.println("ERRO: pivô = 0");
            return 0; // ou trate via pivotação
        }
        return matriz[linhaAlvo][coluna] / matriz[linhaPivo][coluna];
    }
    public static void zeraLinha(float[][] matriz, float fator, int linhaAlvo, int linhaPivo) {
        for (int j = 0; j < matriz[0].length; j++) {
            matriz[linhaAlvo][j] = matriz[linhaAlvo][j] - fator * matriz[linhaPivo][j];
        }
    }

    public static void main(String[] argvs){
        Scanner sc = new Scanner(System.in);
        int linhas = 3;
        int colunas = 4;
        float[][] matriz = new float[linhas][colunas];
        //preenchendo a matriz
        for(int i=0;i<linhas;i++){
            for(int j=0;j<colunas;j++){
                System.out.print("Insira o elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextFloat();
            }
        }
        //Matriz começa em 0, logo,L1=0, L2=1, L3=2
        //zerando m[1][0]
       float f21 = calculeFator(matriz, 1, 0, 0);
       zeraLinha(matriz, f21, 1, 0);

        //zera m[2][0]
        float f31 = calculeFator(matriz, 2, 0, 0);
        zeraLinha(matriz, f31, 2, 0);

        //zera m[2][1]
        float f32 = calculeFator(matriz, 2, 1, 1);
        zeraLinha(matriz, f32, 2, 1);

        
        //calcula as variáveis
        float z=matriz[2][3]/matriz[2][2];
        float y=(matriz[1][3] - matriz[1][2] * z) / matriz[1][1];
        float x=(matriz[0][3] - matriz[0][2] * z - matriz[0][1] * y) / matriz[0][0];

        System.out.printf("Solução do sistema:\n");
        System.out.printf("x1 = %.4f\n", x);
        System.out.printf("x2 = %.4f\n", y);
        System.out.printf("x3 = %.4f\n", z);

        sc.close();

        for(int i=0;i<linhas;i++){
            for(int j=0;j<colunas;j++){
                System.out.print("[" + i + "][" + j + "]: ");
            }
        }
    }
}