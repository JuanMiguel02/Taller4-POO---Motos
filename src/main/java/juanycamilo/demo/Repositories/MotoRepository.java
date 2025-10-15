package juanycamilo.demo.Repositories;


import juanycamilo.demo.Model.Moto;

import java.util.ArrayList;

/**
 * Repositorio centralizado para gestionar los motos
 * Singleton para garantizar una única instancia en toda la aplicación
 */
public class MotoRepository {
    private static MotoRepository instancia;
    private ArrayList<Moto> motos;

    private MotoRepository() {
        motos = new ArrayList<>();
        cargarDatosEjemplo();
    }

    /**
     * Obtiene la instancia única del repositorio
     */
    public static MotoRepository getInstancia() {
        if (instancia == null) {
            instancia = new MotoRepository();
        }
        return instancia;
    }

    /**
     * Carga algunos motos de ejemplo
     */
    private void cargarDatosEjemplo() {
        motos.add(new Moto("ABC12H", "2026", "Boxer"));
        motos.add(new Moto("SEX666", "1999", "C90"));
        motos.add(new Moto("GAY333", "2025", "NMAX"));
    }

    /**
     * Obtiene todos los motos
     */
    public ArrayList<Moto> getMotos() {

        return motos;
    }

    /**
     * Agrega un nuevo producto
     */
    public void agregarMoto(Moto moto) {

        motos.add(moto);

    }

    /**
     * Elimina un producto
     */
    public void eliminarMoto(Moto moto) {

        motos.remove(moto);

    }

    /**
     * Busca un producto por código
     */
    public Moto buscarPorPlaca(String placa) {
        return motos.stream()
                .filter(p -> p.getPlaca().equals(placa))
                .findFirst()
                .orElse(null);
    }

    /**
     * Obtiene la cantidad de motos
     */
    public int getCantidadMotos() {
        return motos.size();
    }
}

