package ma.emsi.demospringangulaire.dtos;

import jakarta.persistence.*;
import lombok.*;
import ma.emsi.demospringangulaire.entities.PaymentStatus;
import ma.emsi.demospringangulaire.entities.PaymentType;
import ma.emsi.demospringangulaire.entities.Student;

import java.time.LocalDate;


@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder

public class PaymentDTO {
    private Long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;









}
