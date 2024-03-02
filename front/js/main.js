import { buscarIdNaUrl, modelarTarefa, preencheFormularioEditar } from './opcoes-tarefa.js';
import { ListaController } from './lista-controller.js'

const listaController = new ListaController();
const conteudo = document.querySelector('.conteudo')
const botaoCriarTarefa = document.querySelector('.botao__criar__tarefa')
const idEditar = buscarIdNaUrl()

if (conteudo) {
    if (listaController.listaTarefas.length === 0) {
        conteudo.innerHTML = listaController.listaVazia()
    } else {
        conteudo.innerHTML = listaController.criarEstruturaDaTabela()
        const tabela = document.querySelector(`#tabela`)
        tabela.innerHTML += listaController.criarCabecalho() 
        tabela.innerHTML += listaController.listaTabelada()
    }
}

if (botaoCriarTarefa) {
    botaoCriarTarefa.addEventListener('click', evento => {
        evento.preventDefault()
        const form = document.querySelector('.formulario__criar__tarefa')
        const tarefa = modelarTarefa(form)
        if (tarefa) {
            listaController.criarTarefa(tarefa);
            alert('Tarefa criada com sucesso')
            location.href = 'index.html'
        }
    })
}

const botoesEditarTarefa = document.querySelectorAll('.botao__editar__tarefa')

if (botoesEditarTarefa) {
    botoesEditarTarefa.forEach(botao => {
        botao.addEventListener('click', () => {
            const idTarefa = botao.parentElement.id
            location.href = `editar-tarefa.html?id=${idTarefa}`
        })
    })
}

if (idEditar) {
    const tarefa = listaController.buscarPorId(idEditar)
    const form = document.querySelector('.formulario__editar__tarefa')

    preencheFormularioEditar(form, tarefa)

    const botaoSalvaEdicao = document.querySelector('.botao__salvar__edicao')
    botaoSalvaEdicao.addEventListener('click', evento => {
        evento.preventDefault()
        const formEditado = document.querySelector('.formulario__editar__tarefa')
        const tarefaEditada = modelarTarefa(formEditado, idEditar)
        if(tarefaEditada) {
            listaController.editarTarefa(tarefaEditada)
            alert('Tarefa editada com sucesso')
            location.href = 'index.html'
        }
    })
}

const botoesExcluirTarefa = document.querySelectorAll('.botao__excluir__tarefa')

if (botoesExcluirTarefa) {
    botoesExcluirTarefa.forEach(botao => {
        botao.addEventListener('click', () => {
            const idTarefa = botao.parentElement.id
            listaController.excluirTarefa(idTarefa)
            location.href = 'index.html'
        })
    })
}