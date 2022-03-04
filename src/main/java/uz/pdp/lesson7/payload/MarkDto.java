package uz.pdp.lesson7.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkDto {

    private Integer id;
    private int score;
    private Timestamp markedDate;
    private Integer studentId;
    private Integer subjectId;
    private Integer teacherId;
}
