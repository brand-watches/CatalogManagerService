package by.brandwatch.catalogmanagerservice.repository.product;

import by.brandwatch.catalogmanagerservice.repository.setting.bodyType.BodyTypeEntity;
import by.brandwatch.catalogmanagerservice.repository.setting.brand.BrandEntity;
import by.brandwatch.catalogmanagerservice.repository.setting.category.CategoryEntity;
import by.brandwatch.catalogmanagerservice.repository.setting.color.ColorEntity;
import by.brandwatch.catalogmanagerservice.repository.setting.mechanismType.MechanismTypeEntity;
import by.brandwatch.catalogmanagerservice.util.model.entity.IdentifiedEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity extends IdentifiedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @ElementCollection
    private List<String> images;

    @ManyToOne
    @JoinColumn(
            name = "category_id",
            foreignKey = @ForeignKey(
                    name = "fk_category_id",
                    foreignKeyDefinition = "FOREIGN KEY (category_id) REFERENCES category(id) ON UPDATE CASCADE ON DELETE CASCADE"
            )
    )
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(
            name = "brand_id",
            foreignKey = @ForeignKey(
                    name = "fk_brand_id",
                    foreignKeyDefinition = "FOREIGN KEY (brand_id) REFERENCES brand(id) ON UPDATE CASCADE ON DELETE CASCADE"
            )
    )
    private BrandEntity brand;

    @ManyToOne
    @JoinColumn(
            name = "color_id",
            foreignKey = @ForeignKey(
                    name = "fk_color_id",
                    foreignKeyDefinition = "FOREIGN KEY (color_id) REFERENCES color(id) ON UPDATE CASCADE ON DELETE CASCADE"
            )
    )
    private ColorEntity color;

    @ManyToOne
    @JoinColumn(
            name = "mechanism_type_id",
            foreignKey = @ForeignKey(
                    name = "fk_mechanism_type_id",
                    foreignKeyDefinition = "FOREIGN KEY (mechanism_type_id) REFERENCES mechanism_type(id) ON UPDATE CASCADE ON DELETE CASCADE"
            )
    )
    private MechanismTypeEntity mechanismType;

    @ManyToOne
    @JoinColumn(
            name = "body_type_id",
            foreignKey = @ForeignKey(
                    name = "fk_body_type_id",
                    foreignKeyDefinition = "FOREIGN KEY (body_type_id) REFERENCES body_type(id) ON UPDATE CASCADE ON DELETE CASCADE"
            )
    )
    private BodyTypeEntity bodyType;


}
