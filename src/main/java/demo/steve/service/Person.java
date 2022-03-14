package demo.steve.service;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class Person {
    private String firstName;
    private String lastName;
    private String title;
    private String city;
    private String state;
    private String country;
}
