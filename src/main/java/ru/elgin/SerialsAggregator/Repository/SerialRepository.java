package ru.elgin.SerialsAggregator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.elgin.SerialsAggregator.Entity.Serial;

import java.util.List;

public interface SerialRepository extends JpaRepository<Serial, Long> {

    @Query("select s from Serial s where s.name like :searchValue order by s.name")
    List<Serial> findSerialsByName(@Param("searchValue") String searchValue);
}
