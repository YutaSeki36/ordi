package app.ysek.note.ordi.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "accounts")
@Data
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) // これをつけて解決
    private Integer id;

    @Column(nullable=false)
    private String email;

    @Column(nullable=false, length=20)
    private String password;

    @Column(nullable=false, updatable=false)
    private Date created_at;

    @Column(nullable=false)
    private Date updated_at;
}
