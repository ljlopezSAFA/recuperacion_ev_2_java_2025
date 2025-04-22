import enumerados.Posicion;
import modelos.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilidades.UtilidadesLiga;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UtilidadesLigaTest {

    private Equipo equipo;
    private Jugador delantero, portero, defensa;
    private Liga liga;
    private List<Partido> partidos;

    private static Double calificacion = 0.0;



    @BeforeEach
    public void setUp() {
        delantero = new Jugador("Leo", LocalDate.of(2000, 1, 1), Posicion.Delantero, null,
                new EstadisticasJugador(10, 5, 1, 0, 300, 50, 0));

        portero = new Jugador("Iker", LocalDate.of(1995, 5, 10), Posicion.Portero, null,
                new EstadisticasJugador(0, 0, 0, 0, 100, 20, 30));

        defensa = new Jugador("Puyol", LocalDate.of(1990, 3, 3), Posicion.Defensa, null,
                new EstadisticasJugador(1, 2, 0, 1, 200, 40, 0));

        equipo = new Equipo("FC SAFA", "Safa City", new ArrayList<>(), null);
        equipo.getJugadores().addAll(List.of(delantero, portero, defensa));
        delantero.setEquipo(equipo);
        portero.setEquipo(equipo);
        defensa.setEquipo(equipo);

        // Creamos partidos
        Partido p1 = new Partido(equipo, new Equipo("Rival1", "R1", new ArrayList<>(), null), 2, 1, LocalDate.now());
        Partido p2 = new Partido(new Equipo("Rival2", "R2", new ArrayList<>(), null), equipo, 1, 1, LocalDate.now());
        Partido p3 = new Partido(equipo, new Equipo("Rival3", "R3", new ArrayList<>(), null), 0, 3, LocalDate.now());

        partidos = List.of(p1, p2, p3);

        liga = new Liga("Liga SAFA", "Safa", 1, List.of(equipo), partidos, new HashMap<>(), new HashMap<>());
    }

    @Test
    public void testGetNumJugadoresPosicion() {
        int n = UtilidadesLiga.ejercicio1(equipo, Posicion.Delantero);
        assertEquals(1, n);
        calificacion += 0.5;
    }

    @Test
    public void testGetNumPartidosDisputadosEquipo() {
        int num = UtilidadesLiga.ejercicio2(liga, equipo);
        assertEquals(3, num);
        calificacion += 1;
    }

    @Test
    public void testGetNumeroJugadoresPorEquipo() {
        Map<Equipo, Integer> mapa = new UtilidadesLiga().ejercicio3(List.of(equipo));
        assertEquals(3, mapa.get(equipo));
        calificacion += 0.5;
    }

    @Test
    public void testGetPichichi() {
        Jugador pichichi = new UtilidadesLiga().ejercicio4(equipo);
        assertEquals("Leo", pichichi.getNombre());
        calificacion += 0.5;
    }

    @Test
    public void testGetPromesa() {
        Jugador joven = new UtilidadesLiga().ejercicio5(equipo);
        assertEquals("Leo", joven.getNombre());
        calificacion += 1;
    }

    @Test
    public void testGetEstrellaDelEquipo() {
        Jugador estrella = new UtilidadesLiga().ejercicio6(equipo);
        assertEquals("Leo", estrella.getNombre());
        calificacion += 1.5;
    }


    @Test
    public void testGetEstadisticasEquipo() {
        EstadisticasEquipo est = new UtilidadesLiga().ejercicio7(equipo, partidos);

        try {
            assertEquals(3, est.getNumTotalPartidos());
            calificacion += 0.25;
        } catch (AssertionError e) {
            System.out.println("Fallo en getNumTotalPartidos: " + e.getMessage());
        }

        try {
            assertEquals(1, est.getPartidosGanados());
            calificacion += 0.5;
        } catch (AssertionError e) {
            System.out.println("Fallo en getPartidosGanados: " + e.getMessage());
        }

        try {
            assertEquals(1, est.getPartidosEmpatados());
            calificacion += 0.5;
        } catch (AssertionError e) {
            System.out.println("Fallo en getPartidosEmpatados: " + e.getMessage());
        }

        try {
            assertEquals(1, est.getPartidosPerdidos());
            calificacion += 0.5;
        } catch (AssertionError e) {
            System.out.println("Fallo en getPartidosPerdidos: " + e.getMessage());
        }

        try {
            assertEquals(3, est.getGolesMarcados());
            calificacion += 0.75;
        } catch (AssertionError e) {
            System.out.println("Fallo en getGolesMarcados: " + e.getMessage());
        }

        try {
            assertEquals(5, est.getGolesRecibidos());
            calificacion += 0.75;
        } catch (AssertionError e) {
            System.out.println("Fallo en getGolesRecibidos: " + e.getMessage());
        }

        try {
            assertEquals(-2, est.getDiferenciaGoles());
            calificacion += 0.5;
        } catch (AssertionError e) {
            System.out.println("Fallo en getDiferenciaGoles: " + e.getMessage());
        }

        try {
            assertEquals(4, est.getPuntosTotales());
            calificacion += 1.25;
        } catch (AssertionError e) {
            System.out.println("Fallo en getPuntosTotales: " + e.getMessage());
        }

        System.out.println("Calificación total acumulada: " + calificacion);
    }


    @Test
    //SI ESTE TEST SE EJECUTA SOLO LA CALIFICACIÓN APARECERÁ CON VALOR NULL
    //SOLO FUNCIONA CUANDO SE EJECUTA LA CLASE TEST COMPLETA
    public void obtenerMiCalificacionActual() {
        System.out.println("Calificación Actual: " + calificacion);
    }

}

