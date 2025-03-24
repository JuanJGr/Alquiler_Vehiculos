public class Alquiler {

    protected Cliente cliente;
    protected Vehiculo vehiculo;
    protected int dias;
    protected double costoTotal;

    public Alquiler() {
    }

    public Alquiler(Cliente cliente, Vehiculo vehiculo, int dias, double costoTotal) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.dias = dias;
        this.costoTotal = costoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "cliente=" + cliente +
                ", vehiculo=" + vehiculo +
                ", dias=" + dias +
                ", costoTotal=" + costoTotal +
                '}';
    }
}
