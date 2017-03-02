package org.luger.app.domain

import org.hibernate.validator.constraints.NotEmpty
import java.io.Serializable
import javax.persistence.*

/**
 * Created by gerardo8.
 */
@Entity
@Table(schema = "spring_angular")
class Authority(

        @NotEmpty(message = "Authority is required.")
        @Column(unique = true, nullable = false, columnDefinition = "TEXT")
        var authority: String = "",

        @ManyToMany(mappedBy = "authorities")
        var users: Set<User> = setOf(),

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null

) : Serializable {
    companion object {
        private val serialVersionUID = 2738859149330833739L
    }
}
