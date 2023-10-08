package by.brandwatch.catalogmanagerservice.repository.setting.color;

import by.brandwatch.catalogmanagerservice.util.model.entity.IdentifiedEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "color")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ColorEntity extends IdentifiedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String firstColor;

    @Column()
    private String secondColor;
}
