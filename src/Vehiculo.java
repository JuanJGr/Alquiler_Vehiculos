public class Vehiculo {

    protected String marca;
    protected String modelo;
    protected int ano;
    protected double precioPorDia;
    protected boolean disponible = true;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int ano, double precioPorDia) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.precioPorDia = precioPorDia;
    }

    public boolean esDisponible() {
        return disponible;
    }


    public void cambiarDisponibilidad() {
        this.disponible = !this.disponible;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return ano;
    }

    public void setAño(int ano) {
        this.ano = ano;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(double precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", precioPorDia=" + precioPorDia +
                ", disponible=" + disponible +
                '}';
    }
}
