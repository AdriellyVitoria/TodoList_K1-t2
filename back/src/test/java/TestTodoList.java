import models.Tarefa;
import org.junit.Assert;
import org.junit.Test;
import services.TarefaService;

import java.util.ArrayList;

public class TestTodoList {
    TarefaService tarefaService;
    Tarefa tarefa;

    public TestTodoList(){
        tarefaService = new TarefaService();
        tarefa = new Tarefa("nome",
                "descricao",
                "data",
                1,
                "estudos",
                "concluido");
    }
    @Test
    void testAddTarefa(){
        //A
        Tarefa tarefas = tarefaService.addTarefa(tarefa);
        //A

        //A
        Assert.assertTrue(tarefa.contains(tarefas));
        Assert.

    }
}
rue(tarefa);