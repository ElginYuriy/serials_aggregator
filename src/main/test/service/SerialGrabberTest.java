package service;

import org.junit.Test;
import ru.elgin.SerialsAggregator.Aggregator.Aggregator;
import ru.elgin.SerialsAggregator.Aggregator.TORAMPSerialsGrabberImpl;
import ru.elgin.SerialsAggregator.Entity.Serial;
import ru.elgin.SerialsAggregator.Services.SerialServiceImpl;

import java.util.List;

public class SerialGrabberTest {
    @Test
    public void testGetPages() {
        List<Serial> serials;
        Aggregator aggregator = new Aggregator(new TORAMPSerialsGrabberImpl(), new SerialServiceImpl());
        serials = aggregator.getSerials();

       // serials = aggregator.saveSerialsToDataBase(serials);

        for(Serial serial : serials) {
            System.out.println(serial.toString());
        }

    }
}
