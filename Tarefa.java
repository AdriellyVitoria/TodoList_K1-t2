public class Tarefa {
    private String nome;
    private String descricao;
    private String data;
    private int prioridade;
    private String categoria;
    private String status;
    private int id;
    private static int proximoId = 1;

    public Tarefa(String nome, String descricao, String data, int prioridade, String categoria, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
        id = proximoId;
        proximoId++;
    }

    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getData() {
        return data;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getStatus() {
        return status;
    }
    public int getId() {
        return id;
    }
}
