import java.util.ArrayList;
import java.util.List;

public class Lista {
    private List<Paquete> listado;
    public Lista(){
        listado=new ArrayList<Paquete>();
        predefinido();
    }

    public List<Paquete> getListado() {
        return listado;
    }

    public void setListado(List<Paquete> listado) {
        this.listado = listado;
    }
    public void predefinido(){
        listado.add(new Paquete(1, "Quito", "Guayaquil", "Ana", 18.9f));
        listado.add(new Paquete(5, "Guayaquil", "Ibarra", "Pepe", 148.9f));
        listado.add(new Paquete(10, "Guayaquil", "Guayaquil", "Carmen", 8.9f));
        listado.add(new Paquete(15, "Quito", "Ibarra", "Juan", 18.79f));
        listado.add(new Paquete(20, "Ibarra", "Guayaquil", "Maria", 1.9f));
        listado.add(new Paquete(25, "Ibarra", "Quito", "Lucia", 17.49f));
    }

    public Paquete buscarCodigo(int codigo) throws Exception{
        int i=0;
        int s=listado.size()-1;
        int c=0;
        while (i<=s){
            c=(i+s)/2;
            Paquete aux=listado.get(c);
            if(codigo==aux.getCodigo()){
                return aux;
            } else if (codigo<aux.getCodigo()) {
                s=c-1;
            }else{
                i=c+1;
            }
        }
        throw new Exception("No existe paquete con el codigo");
    }
    public List<Paquete> paqueteConDestino(String destino){
        ArrayList<Paquete> resultado= new ArrayList<>();
        for (Paquete p: listado){
            if(p.getDestino().equalsIgnoreCase(destino)){
                resultado.add(p);
            }
        }
        return resultado;

    }
}
