package demo.domain.Log;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class Log {
    private final Integer id;
    private final String name;
    private final LocalDateTime timestamp;
    private String description;
    private LogType type;
    private Integer duration;

}
