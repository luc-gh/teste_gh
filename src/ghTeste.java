import java.util.Arrays;
import java.util.Scanner;

public class ghTeste {

    private void hello() {
        System.out.println("Hello World");
    }

    private String palavra(String s) {
        String retorno = "A palavra possui " + s.length() + " caracteres.";
        return retorno;
    }

    private int soma(int x, int y) {
        return x + y;
    }

    private Double decimais(Double x, Double y, Double z) {
        return (x + y) * x / z;
    }

    private String findNumbers(int k, int[] vetor, int elementos) {
        StringBuilder x = new StringBuilder();

        for(int i = 0; i < elementos; ++i) {
            for(int j = i + 1; j < elementos; ++j) {
                if (vetor[i] + vetor[j] == k) {
                    x.append("(").append(vetor[i]).append(",").append(vetor[j]).append(")");
                }
            }
        }

        return x.toString();
    }

    public static void main(String[] args) {
        ghTeste funcao = new ghTeste();
        Scanner scanner = new Scanner(System.in);
        funcao.hello();
        System.out.print("Escreva uma palavra: ");
        String word = scanner.next();
        System.out.println(funcao.palavra(word));

        try {
            System.out.print("Digite um valor inteiro: ");
            int v1 = scanner.nextInt();
            System.out.print("Digite outro valor inteiro: ");
            int v2 = scanner.nextInt();
            System.out.println("A soma dos numeros é: " + funcao.soma(v1, v2));
        } catch (Exception var17) {
            System.out.println("Erro. Valor inválido.");
        }

        Double x;
        Double y;
        try {
            System.out.print("Valor 1: ");
            x = scanner.nextDouble();
            System.out.print("Valor 2: ");
            y = scanner.nextDouble();
            System.out.print("Valor 3: ");
            Double c = scanner.nextDouble();
            System.out.println("O resultado da expressao é: " + funcao.decimais(x, y, c));
        } catch (Exception var16) {
            System.out.println("Erro. Valor inválido.");
        }

        boolean ite = true;

        do {
            System.out.print("Numero 1: ");
            x = scanner.nextDouble();
            System.out.print("Numero 2: ");
            y = scanner.nextDouble();
            System.out.print("Digite 0 para sair ou escolha a operação (+ - * /) --> ");
            String str = scanner.next();
            byte var9 = -1;
            switch(str.hashCode()) {
                case 42:
                    if (str.equals("*")) {
                        var9 = 2;
                    }
                    break;
                case 43:
                    if (str.equals("+")) {
                        var9 = 0;
                    }
                case 44:
                case 46:
                default:
                    break;
                case 45:
                    if (str.equals("-")) {
                        var9 = 1;
                    }
                    break;
                case 47:
                    if (str.equals("/")) {
                        var9 = 3;
                    }
                    break;
                case 48:
                    if (str.equals("0")) {
                        var9 = 4;
                    }
            }

            switch(var9) {
                case 0:
                    System.out.println(x + y);
                    break;
                case 1:
                    System.out.println(x - y);
                    break;
                case 2:
                    System.out.println(x * y);
                    break;
                case 3:
                    System.out.println(x / y);
                    break;
                case 4:
                    ite = false;
                    System.out.println("Fim");
                    break;
                default:
                    throw new IllegalStateException("Erro - Valor inexperado: " + str);
            }
        } while(ite);

        System.out.println("Digite 7 numeros inteiros a seguir: ");
        int[] numeros = new int[7];
        int[] multi = new int[7];
        int soma = 0;

        int media;
        for(media = 0; media < 7; ++media) {
            System.out.printf("%s%d%s", "Numero ", media + 1, ": ");
            numeros[media] = scanner.nextInt();
            soma += numeros[media];
            multi[media] = media * numeros[media];
        }

        System.out.println("----------------------");
        media = soma / 7;
        System.out.println("Os elementos do vetor são: " + Arrays.toString(numeros));
        System.out.println("a soma de todos os numeros é " + soma);

        int k;
        for(k = 0; k < 7; ++k) {
            System.out.printf("%s%d%s%d%s%d\n", "multiplicações: ", numeros[k], " x ", k, " = ", multi[k]);
        }

        System.out.println("A media aritmetica é " + media);
        boolean var12 = false;

        try {
            System.out.print("Determine a constante k: ");
            k = scanner.nextInt();
            System.out.print("Insira o numero de elementos do vetor: ");
            int elementos = scanner.nextInt();
            int[] vetor = new int[elementos];
            if (elementos == 1) {
                System.out.println("O vetor possui apenas um elemento!");
            } else if (elementos != 0) {
                for(int i = 0; i < elementos; ++i) {
                    System.out.printf("Valor do %dº elemento: ", i + 1);
                    vetor[i] = scanner.nextInt();
                }

                String frase = funcao.findNumbers(k, vetor, elementos);
                System.out.println("Vetor completo: " + Arrays.toString(vetor));
                if (frase.isEmpty()) {
                    System.out.println("Nenhum par de valores somados resultam na constante k.");
                } else {
                    System.out.println("Os pares somados que resultam na constante k são:");
                    System.out.print(frase);
                }
            } else {
                System.out.println("O vetor não possui elementos!");
            }
        } catch (Exception var18) {
            System.out.println("Erro!");
            System.out.println("O termo digitado não pôde ser interpretado.");
        }

    }
}