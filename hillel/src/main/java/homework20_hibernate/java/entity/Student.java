package homework20_hibernate.java.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "student_id", nullable = false, unique = true)
    private int id;

    @Column(name = "fio", nullable = false, length = 100)
    private String fio;

    @Column(name = "admission_year", nullable = false)
    private Integer admissionYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private Group groupId;

    public Student(String fio, int admissionYear, Group groupId) {
        this.fio = fio;
        this.admissionYear = admissionYear;
        this.groupId = groupId;
    }
}
