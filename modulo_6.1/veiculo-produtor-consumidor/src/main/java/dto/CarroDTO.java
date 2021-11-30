package dto;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "carro")
public class CarroDTO {
    private LocalDateTime dataLeitura;
    private Double velocidade;
    private Integer rotacao;
    private boolean sensorFrenagem;
}
