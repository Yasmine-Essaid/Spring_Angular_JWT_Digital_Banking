package ma.emsi.demospringangulaire;

import ma.emsi.demospringangulaire.entities.Payment;
import ma.emsi.demospringangulaire.entities.PaymentStatus;
import ma.emsi.demospringangulaire.entities.PaymentType;
import ma.emsi.demospringangulaire.entities.Student;
import ma.emsi.demospringangulaire.repository.PaymentRepository;
import ma.emsi.demospringangulaire.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class DemoSpringAngulaireApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringAngulaireApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        PaymentRepository paymentRepository){
        return args -> {
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Mohamed").code("112332").programId("SDIA").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Lamya").code("112452").programId("SDIA").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Hafsa").code("56302").programId("GLSID").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Saif").code("86332").programId("BDCC").build());


            PaymentType[] paymentTypes = PaymentType.values();
            Random random = new Random();
            studentRepository.findAll().forEach(st -> {
                for (int i = 0; i <10 ; i++){
                    int index = random.nextInt(paymentTypes.length);
                    Payment payment = Payment.builder()
                            .amount(1000+(int)(Math.random()*20000))
                            .type(paymentTypes[index])
                            .status(PaymentStatus.CREATED)
                            .date(LocalDate.now())
                            .student(st)
                            .build();
                    paymentRepository.save(payment);
                }
            });

        };
    }


}
