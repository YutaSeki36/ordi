package app.ysek.note.ordi.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "accounts")
@Data
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) // これをつけて解決
    private Integer id;

    @Column(nullable=false, unique = true)
    private String email;

    @Column(nullable=false, length=20)
    private String password;

    @Column(nullable=false, updatable=false)
    private Date created_at;

    @Column(nullable=false)
    private Date updated_at;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /* (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
     */
    @Override
    public String getUsername() {
        return this.email;
    }

    /* (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /* (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
