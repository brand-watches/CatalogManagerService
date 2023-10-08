package by.brandwatch.catalogmanagerservice.repository.setting.bodyType;

import by.brandwatch.catalogmanagerservice.util.model.entity.IdentifiedEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "body_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BodyTypeEntity extends IdentifiedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
