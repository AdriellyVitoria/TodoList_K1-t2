export class ListaController {
    constructor() {
        this.listaTarefas = JSON.parse(localStorage.getItem('listaTarefas'))?.listaTarefas
        if (!this.listaTarefas) {
            localStorage.setItem('listaTarefas', JSON.stringify({listaTarefas: []}))
            this.listaTarefas = JSON.parse(localStorage.getItem('listaTarefas'))?.listaTarefas
        }
    }

    listaTabelada() {
        let tabela = '';

        this.listaTarefas.map(tarefa => {
            tabela += `<tr>
                <td>${tarefa.nome}</td>
                <td>${tarefa.descricao}</td>
                <td>${tarefa.categoria}</td>
                <td class="prioridade__${tarefa.prioridade}">${tarefa.prioridade}</td>
                <td>${tarefa.status}</td>
                <td>${tarefa.dataTermino}</td>
                <td class="opcoes" id="${tarefa.id}">
                    <img src="img/ferramenta-lapis.png" alt="Editar" class="botao__editar__tarefa">
                    <img src="img/lixeira-de-reciclagem.png" alt="Editar" class="botao__excluir__tarefa">
                </td>
            </tr>`
        })
        return tabela
    }

    criarEstruturaDaTabela() {
        return `<table id="tabela">
        </table>`
    }

    criarCabecalho() {
        return `
        <tr>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Categoria</th>
            <th>Prioridade</th>
            <th>Status</th>
            <th>Data término</th>
            <th>opções</th>
        </tr>`
    }

    listaVazia() {
        return `<p>A lista está vázia</p>`
    }

    criarTarefa(tarefa) {
        this.listaTarefas.push(tarefa)
        this.listaTarefas.sort((a, b) => {
            if (a.prioridade < b.prioridade)
                return -1
            if (a.prioridade > b.prioridade)
                return 1
            return 0
        })
        this.salvarMudancas()
    }

    buscarPorId(id) {
        for (let i = 0; i < this.listaTarefas.length; i++) {
            if (this.listaTarefas[i].id === id) {
                return this.listaTarefas[i]
            }
        }
    }

    editarTarefa(novaTarefa) {
        this.excluirTarefa(novaTarefa.id)
        console.log('foi')
        this.criarTarefa(novaTarefa)
        console.log('foi')
    }

    excluirTarefa(id) {
        const tarefa = this.buscarPorId(id)
        const index = this.listaTarefas.indexOf(tarefa)
        this.listaTarefas.splice(index, 1)
        this.salvarMudancas()
    }

    salvarMudancas() {
        localStorage.setItem('listaTarefas', JSON.stringify({listaTarefas : this.listaTarefas}))
        this.listaTarefas = JSON.parse(localStorage.getItem('listaTarefas')).listaTarefas
    }
}
