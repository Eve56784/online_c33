package templating.sbtemplating.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Min(value = 1, message = "ID should be over 1")
    private int id;
    @NotBlank(message = "First name cant be blank")
    private String firstName;
    @NotBlank(message = "Last name cant be blank")
    private String lastName;
    @Min(value = 1, message = "Course cant be less than 1")
    @Max(value = 5, message = "Course cant be over 5")
    private int course;
    @DecimalMin(value = "0.0", message = "GPA cant be less than 0.0")
    @DecimalMax(value = "4.0", message = "GPA cant be over 4.0")
    private double gpa;
    private boolean isStudentCouncilMember;

}
