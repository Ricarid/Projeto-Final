import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorProdutos {
    private List<Produto> produtos;
    private final String ARQUIVO = "produtos.txt";

    public GerenciadorProdutos() {
        this.produtos = new ArrayList<>();
        carregarDados();
    }

    public void adicionarProduto(Produto p) {
        produtos.add(p);
        salvarDados();
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto p : produtos) {
            System.out.println(p.toString());
        }
    }

    public void removerProduto(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) {
            System.out.println("Produto removido com sucesso!");
            salvarDados();
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    private void salvarDados() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Produto p : produtos) {
                bw.write(p.paraStringArquivo());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados no arquivo: " + e.getMessage());
        }
    }

    private void carregarDados() {
        File arquivo = new File(ARQUIVO);
        if (!arquivo.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                produtos.add(Produto.deStringArquivo(linha));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao carregar os dados do arquivo.");
        }
    }
}