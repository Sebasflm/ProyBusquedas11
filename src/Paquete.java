public class Paquete {
    private int codigo;
    private String origen;
    private String destino;
    private String remitente;
    private float peso;

    public Paquete(int codigo, String origen, String destino, String remitente, float peso) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.remitente = remitente;
        this.peso = peso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Paquete " +
                "codigo: " + codigo +
                ", origen: " + origen  +
                ", destino: " + destino  +
                ", remitente: " + remitente +
                ", peso: " + peso + "\n";
    }
}
