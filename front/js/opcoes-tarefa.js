export function geradorDeId() {
    let idAtual = JSON.parse(localStorage.getItem('idAtual'))?.value
    if (!idAtual) {
        localStorage.setItem('idAtual', JSON.stringify({value:0}))
        idAtual = JSON.parse(localStorage.getItem('idAtual'))?.value
    }
    localStorage.setItem('idAtual', JSON.stringify({value:++idAtual}))
    return `tarefa${idAtual}`
}

export function modelarTarefa(form, id = '') {
    const tarefa = {
        id: id !== '' ? id : geradorDeId(),
        nome: form.nome.value,
        descricao: form.descricao.value,
        categoria: form.categoria.value,
        prioridade: form.prioridade.value,
        status: form.status.value,
        dataTermino: form.data.value
    }

    const todosPrenchidos = Object.values(tarefa).every(valor => valor.length > 0)

    if (todosPrenchidos) return tarefa

    alert('Todos os campos devem ser preenchidos')
}

export function buscarIdNaUrl() {
    const query = location.search
    const params = new URLSearchParams(query)
    const id = params.get('id')

    return id
}


export function preencheFormularioEditar(form, tarefa) {
    form.nome.value = tarefa.nome
    form.descricao.value = tarefa.descricao
    form.categoria.value = tarefa.categoria
    form.prioridade.value = tarefa.prioridade
    form.status.value = tarefa.status
    form.data.value = tarefa.dataTermino
}
