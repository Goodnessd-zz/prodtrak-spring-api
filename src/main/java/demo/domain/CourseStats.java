package demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CourseStats {

    private final String grade;
    private final Integer remainingDays;
    private final Integer hoursSpent;
}
