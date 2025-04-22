package modelos;

import enumerados.Posicion;
import lombok.*;

import java.time.LocalDate;

@Data
@ToString(exclude = {"equipo"})
@EqualsAndHashCode(exclude = {"equipo"})
@NoArgsConstructor
@AllArgsConstructor
public class Jugador {
    private String nombre;
    private LocalDate fechaNacimiento;
    private Posicion posicion;
    private Equipo equipo;
    private EstadisticasJugador estadisticasJugador;
}