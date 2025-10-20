public class BarcoNombresCompletos {
    private String matricula;
    private String marca;
    private int anio;
    private String tipo; // "Velero", "Yate" o "Lancha"

    public BarcoNombresCompletos() {
        this.matricula = "DEFAULT-001";
        this.marca = "MarcaDefecto";
        this.anio = 2000;
        this.tipo = "Lancha";
    }

    public BarcoNombresCompletos(String matricula, String marca, int anio, String tipo) {
        this.matricula = matricula;
        this.marca = marca;
        this.anio = anio;
        this.tipo = tipo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public int getAnio() {
        return anio;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "BarcoNombresCompletos{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", anio=" + anio +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
