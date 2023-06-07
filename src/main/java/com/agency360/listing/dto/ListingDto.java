package com.agency360.listing.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListingDto {

    private Integer       id;
    @NotNull(message ="Veuillez renseigner le propriétaire de l'annonce.")
    private Integer       dealerId;

    @NotEmpty(message ="Veuillez renseigner la marque du véhicule.")
    private String       vehicule;
    @NotNull(message ="Veuillez renseigner le montant du véhicule.")
    private Long          price;
    private LocalDateTime createdAt;
    private String        state;
}
