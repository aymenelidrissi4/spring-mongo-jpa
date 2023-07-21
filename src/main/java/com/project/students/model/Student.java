package com.project.students.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

/*@Entity
@Table(name = "students")*/
@Document(collection = "students_")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @MongoId
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
