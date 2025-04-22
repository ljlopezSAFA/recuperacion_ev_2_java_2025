package modelos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Liga {
    private String nombre;
    private String pais;
    private Integer division;
    private List<Equipo> equipos;
    private List<Partido> partidos;
    private Map<Equipo, Integer> puntosEquipo;
    private Map<Integer, Equipo> clasificacion;
}
