package homework20_hibernate.java.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "points")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Points {

    @Id
    @GeneratedValue
    @Column(name = "point_id", nullable = false, unique = true)
    private int id;

    @Column(name = "point", nullable = false)
    private byte point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student studentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subjectId;

    public Points(byte point, Student studentId, Subject subjectId) {
        this.point = point;
        this.studentId = studentId;
        this.subjectId = subjectId;
    }
}
