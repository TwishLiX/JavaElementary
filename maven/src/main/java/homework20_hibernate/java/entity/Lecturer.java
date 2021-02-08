package homework20_hibernate.java.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "lecturer")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Lecturer {

    @Id
    @GeneratedValue
    @Column(name = "lecturer_id", nullable = false, unique = true)
    private int id;

    @Column(name = "fio", nullable = false, length = 100)
    private String fio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department departmentId;

    public Lecturer(String fio, Department departmentId) {
        this.fio = fio;
        this.departmentId = departmentId;
    }
}
