public class Cliente {

    protected String nombre;
    protected String cedula;
    protected String licencia;

    public Cliente() {
    }

    public Cliente(String nombre, String cedula, String licencia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.licencia = licencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", licencia='" + licencia + '\'' +
                '}';
    }
}
