package models;

public class Tarefa implements Comparable<Tarefa> {
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

        @Override
        public String toString() {
            return "ID: " + id
                    + "\nNome da tarefa: " + nome
                    + "\nDescrição: " + descricao
                    + "\nData de Término: " + data
                    + "\nPrioridade: " + prioridade
                    + "\nCategoria: " + categoria
                    + "\nStatus: " + status
                    + "\n---------------";
        }

        @Override
        public int compareTo(Tarefa o) {
            return Integer.compare(prioridade, o.getPrioridade());
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public void setData(String data) {
            this.data = data;
        }

        public void setPrioridade(int prioridade) {
            this.prioridade = prioridade;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public void setStatus(String status) {
            this.status = status;
        }
}
