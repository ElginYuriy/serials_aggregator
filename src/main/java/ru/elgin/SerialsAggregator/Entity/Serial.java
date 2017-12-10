package ru.elgin.SerialsAggregator.Entity;

import javax.persistence.*;

/**
*
* Класс для отображения сущности "Сериал"
*
* @author elgin
* @version 1.0
* */
@Entity
@Table(name = "serials")
public class Serial {
    @Id
    @Column(name = "serial_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;
    @Column(name = "name")
    private String  name;            // Название сериала
    @Column(name = "origin_name")
    private String  originName;      // Оригинальное название
    @Column(name = "prod_years")
    private String  productionYears; // Годы выпуска
    @Column(name = "genre")
    private String  genre;           // Жанр
    @Column(name = "seasons")
    private Integer numberSeasons;   // Количество сезонов

    public Serial() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginName() {
        return this.originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getProductionYears() {
        return this.productionYears;
    }

    public void setProductionYears(String productionYears) {
        this.productionYears = productionYears;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getNumberSeasons() {
        return this.numberSeasons;
    }

    public void setNumberSeasons(Integer numberSeasons) {
        this.numberSeasons = numberSeasons;
    }

    @Override
    public String toString() {
        return "Serial{" +
                "name='" + name + '\'' +
                ", originName='" + originName + '\'' +
                ", productionYears='" + productionYears + '\'' +
                ", genre='" + genre + '\'' +
                ", numberSeasons=" + numberSeasons +
                '}';
    }
}
