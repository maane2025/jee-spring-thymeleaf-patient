package ma.maaneaimane.jee_spring_thymeleaf_patient_app.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom ne doit pas être vide")
    private String nom;

    @NotNull(message = "La date de naissance est obligatoire")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;

    private boolean malade;

    @Min(value = 0, message = "Le score doit être positif")
    private int score;
}
