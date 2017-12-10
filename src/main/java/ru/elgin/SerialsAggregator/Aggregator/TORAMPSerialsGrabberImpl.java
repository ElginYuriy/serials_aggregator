package ru.elgin.SerialsAggregator.Aggregator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.elgin.SerialsAggregator.Entity.Serial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *  Класс для получения HTML страниц с сайта http://www.toramp.com/schedule и их парсинга
 *
 */
public class TORAMPSerialsGrabberImpl implements SerialsGrabber {

    private static final String URL_FORMAT = "http://www.toramp.com/schedule.php?page=%d";

    public List<Serial> getSerials() {
        List<Serial> serials = new ArrayList<Serial>();
        Document doc;
        int pageNumber = 0;
        try {
            while(true) {
                doc = getDocument(pageNumber++);
                System.out.println(pageNumber); //TEST
                if (doc == null || pageNumber == 100) break;
                Element table = doc.getElementById("schedule-list");
                if (table == null) break;
                //Парсим страницу
                Elements rows = table.getElementsByTag("tr");
                for(int i = 0; i < rows.size(); i++) {
                    Element row = rows.get(i);
                    Serial serial = new Serial();
                    //Название
                    serial.setName(row.getElementsByClass("title").first().text());
                    //Оригинальное название
                    serial.setOriginName(row.getElementsByClass("original-headline").first().text());
                    //Период выпуска
                    serial.setProductionYears(row.getElementsByClass("year").first().text());
                    //Количество сезонов
                    serial.setNumberSeasons(Integer.parseInt(row.getElementsByClass("ser-info")
                                                             .first().getElementsByTag("div").get(1)
                                                             .getElementsByTag("a").first().text()));
                    //Жанр
                    serial.setGenre(row.getElementsByClass("ser-info")
                                       .first().getElementsByTag("div").get(3).text().replace("Жанр: ", ""));

                    serials.add(serial);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serials;
    }

    protected Document getDocument(int page) throws IOException {
        String url = String.format(URL_FORMAT, page);
        Document doc = Jsoup.connect(url).get();

        return doc;
    }
}
