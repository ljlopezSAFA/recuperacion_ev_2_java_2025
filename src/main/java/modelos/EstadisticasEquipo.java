package modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadisticasEquipo {
    private Integer numTotalPartidos;
    private Integer partidosGanados;
    private Integer partidosEmpatados;
    private Integer partidosPerdidos;
    private Integer golesMarcados;
    private Integer golesRecibidos;
    private Integer diferenciaGoles;
    private Integer puntosTotales;
}
