package demo.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Log {
    private final Integer id;
    private final String name;
    private final String timestamp;
    private String description;
    private Logtype type;
    private Integer duration;

}
