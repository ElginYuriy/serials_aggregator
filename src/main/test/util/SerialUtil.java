package util;

import ru.elgin.SerialsAggregator.Entity.Serial;

public class SerialUtil {
    public static Serial createSerial() {
        Serial serial = new Serial();
        serial.setName("Тест название сериала");
        serial.setOriginName("Test serial name");
        serial.setGenre("test");
        serial.setNumberSeasons(1);
        serial.setProductionYears("2016 - 2017");
        return serial;
    };
}
