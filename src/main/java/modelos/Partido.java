package modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Integer golesLocal;
    private Integer golesVisitante;
    private LocalDate fecha;
}
