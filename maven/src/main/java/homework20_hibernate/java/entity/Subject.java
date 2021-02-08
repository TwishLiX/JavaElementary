package homework20_hibernate.java.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "subject")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Subject {

    @Id
    @GeneratedValue
    @Column(name = "subject_id", nullable = false, unique = true)
    private int id;

    @Column(name = "subject_name", nullable = false, length = 45)
    private String subject;

    @Column(name = "semester")
    private byte semester;

    @Column(name = "year")
    private short year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id", nullable = false)
    private Lecturer lecturerId;

    public Subject(String subject, byte semester, short year, Lecturer lecturerId) {
        this.subject = subject;
        this.semester = semester;
        this.year = year;
        this.lecturerId = lecturerId;
    }
}
