package modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {
    private String nombre;
    private String ciudad;
    private List<Jugador> jugadores;
    private EstadisticasEquipo estadisticasEquipo;
}

