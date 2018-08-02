package demo.domain.Log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Log {
    @Id
    private Integer id;
    private final String name;
    private final LocalDateTime timestamp;
    private String description;
    private LogType type;
    private Integer duration;

}
