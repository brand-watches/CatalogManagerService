package by.brandwatch.catalogmanagerservice.repository.setting.mechanismType;

import by.brandwatch.catalogmanagerservice.util.model.entity.IdentifiedEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "mechanism_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MechanismTypeEntity extends IdentifiedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

}