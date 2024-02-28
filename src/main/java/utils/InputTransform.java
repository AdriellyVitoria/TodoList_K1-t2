package utils;

public class InputTransform {
    public String statusToString(int statusTarefa){
        String status = null;
        switch (statusTarefa){
            case 0:
                status = "Em andamento";
                break;
            case 1:
                status = "A fazer";
                break;
            case 2:
                status = "Concluido";
                break;
        }
        return status;
    }

    public String categoriToString(int categoriaTarefa){
        String categoria = null;
        switch (categoriaTarefa){
            case 0:
                categoria = "Casa";
                break;
            case 1:
                categoria = "Trabalho";
                break;
            case 2:
                categoria = "Estudos";
                break;
        }
        return categoria;
    }
}
