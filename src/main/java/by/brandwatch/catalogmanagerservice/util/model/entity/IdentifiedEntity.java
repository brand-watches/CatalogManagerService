package by.brandwatch.catalogmanagerservice.util.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IdentifiedEntity{

    private Long id;

    private String name;
}
