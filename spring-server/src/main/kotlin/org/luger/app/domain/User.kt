package org.luger.app.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotEmpty
import java.io.Serializable
import javax.persistence.*

/**
 * Created by gerardo8.
 */
@Entity
@Table(schema = "spring_angular")
class User(

        @NotEmpty(message = "First name is required.")
        @Column(nullable = false, columnDefinition = "TEXT")
        var firstName: String = "",

        @NotEmpty(message = "Last name is required.")
        @Column(nullable = false, columnDefinition = "TEXT")
        var lastName: String = "",

        @NotEmpty(message = "Username is required.")
        @Column(unique = true, nullable = false, columnDefinition = "TEXT")
        var username: String = "",

        @Email(message = "Please provide a valid email address.")
        @NotEmpty(message = "Email is required.")
        @Column(unique = true, nullable = false, columnDefinition = "TEXT")
        var email: String = "",

        @NotEmpty(message = "Password is required.")
        @Column(nullable = false, columnDefinition = "TEXT")
        @JsonIgnore
        var password: String = "",

        @ManyToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinTable(
                schema = "spring_angular",
                name = "user_authority",
                joinColumns = arrayOf(JoinColumn(name = "user_id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "authority_id"))
        )
        @JsonIgnore
        var authorities: Set<Authority> = setOf(),

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonIgnore
        var id: Long? = null

) : Serializable {
    companion object {
        private val serialVersionUID = 2738859149330833739L
    }
}
