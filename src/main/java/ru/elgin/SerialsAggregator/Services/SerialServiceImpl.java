package ru.elgin.SerialsAggregator.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.elgin.SerialsAggregator.Entity.Serial;
import ru.elgin.SerialsAggregator.Repository.SerialRepository;

import java.util.List;

@Service
public class SerialServiceImpl implements SerialService {

    @Autowired
    private SerialRepository serialRepo;

    public Serial getByName(String serialName) {
        return null;
    }

    public Serial addSerial(Serial serial) {
        return serialRepo.save(serial);
    }

    public List<Serial> getAll() {
        return serialRepo.findAll();
    }

    public List<Serial> findSerialByName(String searchStr) {
        return serialRepo.findSerialsByName(searchStr);
    }

    public List<Serial> saveAllToDataBase(List<Serial> serials) {
        return serialRepo.save(serials);
    }
}
