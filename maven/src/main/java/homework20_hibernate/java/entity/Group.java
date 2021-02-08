package homework20_hibernate.java.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "group")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "group_id", nullable = false, unique = true)
    private int id;

    @Column(name = "group", nullable = false, length = 10)
    private String group;

    @OneToMany(mappedBy = "groupId", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Student> students;

    public Group(String group) {
        this.group = group;
        students = new ArrayList<>();
    }
}
