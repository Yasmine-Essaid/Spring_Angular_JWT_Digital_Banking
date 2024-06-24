package ma.emsi.demospringangulaire.repository;

import ma.emsi.demospringangulaire.entities.Payment;
import ma.emsi.demospringangulaire.entities.PaymentStatus;
import ma.emsi.demospringangulaire.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);

}
