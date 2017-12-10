package ru.elgin.SerialsAggregator.Services;

import ru.elgin.SerialsAggregator.Entity.Serial;

import java.util.List;

public interface SerialService {
    Serial getByName(String serialName);
    Serial addSerial(Serial serial);
    List<Serial> getAll();
    List<Serial> findSerialByName(String searchStr);
    List<Serial> saveAllToDataBase(List<Serial> serials);
}
