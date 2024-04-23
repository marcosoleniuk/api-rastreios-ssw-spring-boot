package com.moleniuk.apirastreiossw.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TABLE_SSW_INFO")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DatasSSWInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SSW_CODE")
    private String sswCode;

    @Column(name = "SSW_DATE")
    private String sswDate;

    @Column(name = "SSW_HOUR")
    private String sswHour;

    @Column(name = "SSW_STATUS")
    private String sswStatus;

    @Column(name = "SSW_LOCAL")
    private String sswLocal;

    @Column(name = "SSW_OBS")
    private String sswObs;

}
