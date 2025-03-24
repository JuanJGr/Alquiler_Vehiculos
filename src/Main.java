import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int op;
        boolean estado = true;

        List<Vehiculo> lstVehiculos = new ArrayList<>();
        List<Cliente> lstClientes = new ArrayList<>();
        List<Alquiler> lstAlquileres = new ArrayList<>();

        do {
            System.out.println("""
                    1. Registrar Vehículo
                    2. Registrar Cliente
                    3. Realizar Alquiler
                    4. Devolver Vehículo
                    5. Mostrar Vehículos Disponibles
                    6. Salir
                    """);
            op = teclado.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.println("Ingrese tipo de vehículo (1- Auto, 2- Camioneta):");
                    int tipo = teclado.nextInt();

                    System.out.println("Ingrese marca:");
                    String marca = teclado.next();
                    System.out.println("Ingrese modelo:");
                    String modelo = teclado.next();
                    System.out.println("Ingrese año:");
                    int año = teclado.nextInt();
                    System.out.println("Ingrese precio por día:");
                    double precioPorDia = teclado.nextDouble();

                    if (tipo == 1) {
                        System.out.println("Ingrese número de puertas:");
                        int puertas = teclado.nextInt();
                        lstVehiculos.add(new Auto(marca, modelo, año, precioPorDia, puertas));
                    } else if (tipo == 2) {
                        System.out.println("Ingrese capacidad de carga en kg:");
                        double carga = teclado.nextDouble();
                        lstVehiculos.add(new Camioneta(marca, modelo, año, precioPorDia, carga));
                    }
                    System.out.println("Vehículo registrado.");
                }
                case 2 -> {
                    System.out.println("Ingrese nombre del cliente:");
                    String nombre = teclado.next();
                    System.out.println("Ingrese cédula del cliente:");
                    String cedula = teclado.next();
                    System.out.println("Ingrese número de licencia de conducir:");
                    String licencia = teclado.next();

                    lstClientes.add(new Cliente(nombre, cedula, licencia));
                    System.out.println("Cliente registrado.");
                }
                case 3 -> {
                    System.out.println("Ingrese cédula del cliente:");
                    String cedula = teclado.next();

                    Cliente cliente = null;
                    for (Cliente c : lstClientes) {
                        if (c.getCedula().equals(cedula)) {
                            cliente = c;
                            break;
                        }
                    }

                    if (cliente == null) {
                        System.out.println("Cliente no encontrado.");
                        break;
                    }

                    System.out.println("Ingrese el tipo de vehículo que desea alquilar (1- Auto, 2- Camioneta):");
                    int tipoVehiculo = teclado.nextInt();
                    List<Vehiculo> vehiculosDisponibles = new ArrayList<>();

                    if (tipoVehiculo == 1) {
                        for (Vehiculo v : lstVehiculos) {
                            if (v.esDisponible() && v instanceof Auto) {
                                vehiculosDisponibles.add(v);
                            }
                        }
                    } else if (tipoVehiculo == 2) {
                        for (Vehiculo v : lstVehiculos) {
                            if (v.esDisponible() && v instanceof Camioneta) {
                                vehiculosDisponibles.add(v);
                            }
                        }
                    } else {
                        System.out.println("Opción no válida, por favor ingrese 1 para Auto o 2 para Camioneta.");
                        return;
                    }

                    if (!vehiculosDisponibles.isEmpty()) {
                        System.out.println("Vehículos disponibles:");
                        for (int i = 0; i < vehiculosDisponibles.size(); i++) {
                            System.out.println((i + 1) + ". " + vehiculosDisponibles.get(i));
                        }

                        System.out.println("Ingrese el número del vehículo que desea alquilar:");
                        int seleccion = teclado.nextInt();

                        if (seleccion >= 1 && seleccion <= vehiculosDisponibles.size()) {
                            Vehiculo vehiculoSeleccionado = vehiculosDisponibles.get(seleccion - 1);
                            System.out.println("Ha seleccionado: " + vehiculoSeleccionado);

                            System.out.println("Ingrese la cantidad de días de alquiler:");
                            int dias = teclado.nextInt();

                            double costoTotal = vehiculoSeleccionado.getPrecioPorDia() * dias;

                            if (dias > 7) {
                                costoTotal *= 0.9;
                            }

                            Alquiler alquiler = new Alquiler(cliente, vehiculoSeleccionado, dias, costoTotal);
                            lstAlquileres.add(alquiler);
                            vehiculoSeleccionado.cambiarDisponibilidad();
                            System.out.println("Alquiler realizado. Costo total: " + costoTotal);
                        } else {
                            System.out.println("Selección inválida.");
                        }
                    } else {
                        System.out.println("No hay vehículos disponibles de este tipo.");
                    }
                }
                case 4 -> {
                    System.out.println("Ingrese la cédula del cliente que devuelve el vehículo:");
                    String cedula = teclado.next();

                    List<Alquiler> alquileresCliente = new ArrayList<>();

                    for (Alquiler a : lstAlquileres) {
                        if (a.getCliente().getCedula().equals(cedula) && !a.getVehiculo().esDisponible()) {
                            alquileresCliente.add(a);
                        }
                    }

                    if (alquileresCliente.isEmpty()) {
                        System.out.println("No se encontró alquiler activo para este cliente.");
                        break;
                    }

                    if (alquileresCliente.size() > 1) {
                        System.out.println("Usted tiene los siguientes vehículos alquilados:");

                        for (int i = 0; i < alquileresCliente.size(); i++) {
                            System.out.println((i + 1) + ". " + alquileresCliente.get(i).getVehiculo());
                        }

                        System.out.println("Seleccione el número del vehículo que desea devolver:");
                        int seleccion = teclado.nextInt();

                        if (seleccion >= 1 && seleccion <= alquileresCliente.size()) {
                            Alquiler alquilerSeleccionado = alquileresCliente.get(seleccion - 1);
                            alquilerSeleccionado.getVehiculo().cambiarDisponibilidad();
                            lstAlquileres.remove(alquilerSeleccionado);
                            System.out.println("Vehículo devuelto exitosamente.");
                        } else {
                            System.out.println("Selección inválida.");
                        }
                    } else {
                        Alquiler alquiler = alquileresCliente.get(0);
                        alquiler.getVehiculo().cambiarDisponibilidad();
                        lstAlquileres.remove(alquiler);
                        System.out.println("Vehículo devuelto exitosamente.");
                    }
                }

                case 5 -> {
                    System.out.println("Vehículos disponibles:");
                    boolean hayVehiculosDisponibles = false;

                    for (Vehiculo v : lstVehiculos) {
                        if (v.esDisponible()) {
                            System.out.println(v);
                            hayVehiculosDisponibles = true;
                        }
                    }

                    if (!hayVehiculosDisponibles) {
                        System.out.println("No hay vehículos disponibles.");
                    }
                }
                case 6 -> {
                    System.out.println("Saliendo...");
                    estado = false;
                }
                default -> System.out.println("Opción no válida.");
            }
        } while (estado);

    }
}
