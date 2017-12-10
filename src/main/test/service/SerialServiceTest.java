package service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.elgin.SerialsAggregator.Aggregator.Aggregator;
import ru.elgin.SerialsAggregator.Aggregator.TORAMPSerialsGrabberImpl;
import ru.elgin.SerialsAggregator.Config.DataConfig;
import ru.elgin.SerialsAggregator.Entity.Serial;
import ru.elgin.SerialsAggregator.Services.SerialService;
import ru.elgin.SerialsAggregator.Services.SerialServiceImpl;
import util.SerialUtil;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Класс для тестирования работы с БД
 *
 *  @author elgin
 *  @version 1.0
 */

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
@WebAppConfiguration
public class SerialServiceTest {
    @Resource
    private EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;
    @Resource
    private SerialService serialService;

    @Before
    public void setUp() throws Exception {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    public void testSaveSerialSingle() throws Exception {
        serialService.addSerial(SerialUtil.createSerial());
    }

    @Test
    public void testSaveSerial() throws Exception {

        List<Serial> serials;
        Aggregator aggregator = new Aggregator(new TORAMPSerialsGrabberImpl(), new SerialServiceImpl());
        serials = aggregator.getSerials();
        serialService.saveAllToDataBase(serials);

    }

    @Test
    public void testFindSerial() throws Exception {
        serialService.findSerialByName("%название%");
    }
}
