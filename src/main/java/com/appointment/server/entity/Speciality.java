package com.appointment.server.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "specialities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Speciality {
    @Id
    private ObjectId id;
    @NotNull(message = "name is required in Speciality !!!")
    @NotBlank(message = "name is required in Speciality !!!")
    @Indexed(unique = true)
    private String name;
    @NotNull(message = "description is required in Speciality !!!")
    @NotBlank(message = "description is required in Speciality !!!")
    private String description;
    private String image;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public @NotNull(message = "name is required in Speciality !!!") @NotBlank(message = "name is required in Speciality !!!") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "name is required in Speciality !!!") @NotBlank(message = "name is required in Speciality !!!") String name) {
        this.name = name;
    }

    public @NotNull(message = "description is required in Speciality !!!") @NotBlank(message = "description is required in Speciality !!!") String getDescription() {
        return description;
    }

    public void setDescription(@NotNull(message = "description is required in Speciality !!!") @NotBlank(message = "description is required in Speciality !!!") String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}