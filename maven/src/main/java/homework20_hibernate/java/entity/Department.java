package homework20_hibernate.java.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "department")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Department {

    @Id
    @GeneratedValue
    @Column(name = "department_id", nullable = false, unique = true)
    private int id;

    @Column(name = "department_name", nullable = false, length = 100)
    private String department;

    @Column(name = "head", length = 100)
    private String departmentHead;

    public Department(String department, String departmentHead) {
        this.department = department;
        this.departmentHead = departmentHead;
    }
}
