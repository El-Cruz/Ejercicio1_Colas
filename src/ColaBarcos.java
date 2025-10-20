import java.util.LinkedList;
import java.util.Queue;

public class ColaBarcos {
    private Queue<BarcoNombresCompletos> colaBarcos;

    public ColaBarcos() {
        this.colaBarcos = new LinkedList<>();
    }

    public void add(BarcoNombresCompletos b){
        colaBarcos.add(b);
        System.out.println("Elemento agregado");
    }

    public BarcoNombresCompletos remove(){
        if(colaBarcos.isEmpty()){
            System.out.println("La cola esta vacia.");
            return null;
        }
        return colaBarcos.remove(); // o miCola.poll()
    }

    public BarcoNombresCompletos peek(){
        if(colaBarcos.isEmpty()){
            System.out.println("La cola esta vacia.");
            return null;
        }
        return colaBarcos.peek();
    }

    public void R1_inicializar(){
        colaBarcos.add(new BarcoNombresCompletos());
        colaBarcos.add(new BarcoNombresCompletos("ABC-123", "Yamaha", 2010, "Yate"));
        colaBarcos.add(new BarcoNombresCompletos("DEF-456", "Bayliner", 1995, "Lancha"));
        colaBarcos.add(new BarcoNombresCompletos("GHI-789", "Beneteau", 2020, "Velero"));
        colaBarcos.add(new BarcoNombresCompletos("JKL-012", "Yamaha", 2022, "Yate"));
    }

    public String R2_calcularCostos(){
        if (colaBarcos.isEmpty()){
            return "La cola esta vacia";
        }
        int anioActual = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        String reporte = "--- Reporte de Costos de Amarre ---\n";

        // 1. Obtener el tamaño UNA VEZ antes del bucle
        int tamanioCola = colaBarcos.size();

        // 2. Usar un bucle 'for i'
        for (int i = 0; i < tamanioCola; i++) {

            // 3. Sacar el barco del frente
            BarcoNombresCompletos b = colaBarcos.remove();

            // BUG CORREGIDO: Mover estas variables DENTRO del bucle
            double costoAmarre = 0;
            int antiguedad = 0;
            String errorMsg = "";

            // 4. Procesar el barco
            if (b.getAnio() >= 1950 && b.getAnio() <= anioActual) {
                antiguedad = anioActual - b.getAnio();

                // NO se hace remove(b) aquí
                switch (b.getTipo()) {
                    case "Velero":
                        costoAmarre = antiguedad * 200;
                        break;
                    case "Yate":
                        costoAmarre = antiguedad * 300;
                        break;
                    case "Lancha":
                        costoAmarre = antiguedad * 100;
                        break;
                    default:
                        errorMsg = "Tipo desconocido";
                }
            } else {
                errorMsg = "Año fuera de rango";
            }

            reporte += String.format("Matrícula: %s, Tipo: %s, Antigüedad: %d, Costo: $%.2f %s\n",
                    b.getMatricula(), b.getTipo(), antiguedad, costoAmarre, errorMsg);

            // 5. Volver a encolar el barco al final
            colaBarcos.add(b);
        }
        return reporte;
    }
    public ColaBarcos R3_copiarPorMarca(String marca){
        ColaBarcos nuevaCola = new ColaBarcos();

        for(BarcoNombresCompletos b : colaBarcos){
            if (b.getMarca().equalsIgnoreCase(marca)){
                nuevaCola.add(b);
            }
        }
        return nuevaCola;
    }


    @Override
    public String toString() {
        String texto = "Lista de barcos: \n";
        for (BarcoNombresCompletos b : colaBarcos){
            texto += b.toString() + "\n";
        }
        return texto;
    }
}
