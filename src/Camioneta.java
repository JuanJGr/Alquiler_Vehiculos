public class Camioneta extends Vehiculo {
   protected double carga;

    public Camioneta(String marca, String modelo, int ano, double precioPorDia, double carga) {
        super(marca, modelo, ano, precioPorDia);
        this.carga = carga;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    @Override
    public String toString() {
        return super.toString() + ", Carga: " + carga + " kg";
    }
}
