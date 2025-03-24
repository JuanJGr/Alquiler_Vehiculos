public class Auto extends Vehiculo{

   protected int puertas;


    public Auto(String marca, String modelo, int ano, double precioPorDia, int puertas) {
        super(marca, modelo, ano, precioPorDia);
        this.puertas = puertas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    @Override
    public String toString() {
        return super.toString() + ", Puertas: " + puertas;
    }
}
