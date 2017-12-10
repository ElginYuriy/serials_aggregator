package ru.elgin.SerialsAggregator.Aggregator;

import ru.elgin.SerialsAggregator.Entity.Serial;
import ru.elgin.SerialsAggregator.Services.SerialService;

import java.util.List;

public class Aggregator {
    private SerialsGrabber serialsGrabber;
    private SerialService serialService;

    public Aggregator(SerialsGrabber serialsGrabber, SerialService serialService) {
        this.serialsGrabber = serialsGrabber;
        this.serialService = serialService;
    }

    public void setSerialsGrabber(SerialsGrabber serialsGrabber) {
        this.serialsGrabber = serialsGrabber;
    }

    public void setSerialService(SerialService serialService) {
        this.serialService = serialService;
    }

    public List<Serial> getSerials() {
        return serialsGrabber.getSerials();
    }

    public List<Serial> saveSerialsToDataBase(List<Serial> serials) {
        return serialService.saveAllToDataBase(serials);
    }
}
