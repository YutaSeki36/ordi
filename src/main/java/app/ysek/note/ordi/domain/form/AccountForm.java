package app.ysek.note.ordi.domain.form;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountForm implements Serializable {
    private String email;
    private String password;
}
