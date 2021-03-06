package lk.ijse.dep8.note.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class User implements SuperEntity{
    @Id
    private String id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "fll_name", nullable = false)
    private String fullName;
}
