public class Produto {
    private int id;
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(int id, String nome, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getQuantidade() { return quantidade; }
    public double getPreco() { return preco; }

    @Override
    public String toString() {
        return String.format("ID: %d | Nome: %s | Qtd: %d | Preço: R$ %.2f", id, nome, quantidade, preco);
    }

    public String paraStringArquivo() {
        return id + ";" + nome + ";" + quantidade + ";" + preco;
    }

    public static Produto deStringArquivo(String linha) {
        String[] dados = linha.split(";");
        int id = Integer.parseInt(dados[0]);
        String nome = dados[1];
        int quantidade = Integer.parseInt(dados[2]);
        double preco = Double.parseDouble(dados[3]);
        return new Produto(id, nome, quantidade, preco);
    }
}