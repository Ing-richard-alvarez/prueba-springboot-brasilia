package com.ralvarez.Task;

import com.ralvarez.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task", uniqueConstraints = {@UniqueConstraint(columnNames = {"code"})})
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String code;
    String title;
    String description;
    @Enumerated(EnumType.STRING)
    Estado estado;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
