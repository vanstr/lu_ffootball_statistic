package com;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.model.Game;
import com.model.PlayingTeam;
import com.xsd.KomandaType;
import com.xsd.ObjectFactory;
import com.xsd.SpeleType;

import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;

/**
 * Created by ivan on 06.01.2015..
 */
public class Main {

  public static void main(String[] args) throws Exception{

    testConnection();

    SpeleType object = getParsedObject("resources/data/futbols20.xml");

    saveDataToDb(object);

  }

  private static void saveDataToDb(SpeleType object) {
    Game game = new Game();
    game.setPlace(object.getVieta());
    game.setSpectatorsAmount(Integer.parseInt(object.getSkatitaji()));
    game.setPlayingTeamOne(generatePlayingTeam(object.getKomanda().get(0)));
    game.setPlayingTeamTwo(generatePlayingTeam(object.getKomanda().get(1)));
    Ebean.save(game);
  }

  private static PlayingTeam generatePlayingTeam(KomandaType komandaType) {
    return null;
  }

  private static  SpeleType getParsedObject(String fileName) throws JAXBException, FileNotFoundException {

    JAXBContext jx = JAXBContext.newInstance(ObjectFactory.class);

    Unmarshaller unmarshaller = jx.createUnmarshaller();
    StreamSource xml = new StreamSource(fileName);

    JAXBElement<SpeleType> some = unmarshaller.unmarshal(xml, SpeleType.class);
    SpeleType speleType = some.getValue();

    /*Marshaller marshaller = jx.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "src/com/xsd/exampl.xsd");
    marshaller.marshal(some, System.out);*/

    return speleType;
  }

  private static void testConnection() {
    String sql = "select count(*) as count from dual";
    SqlRow row = Ebean.createSqlQuery(sql).findUnique();
    Integer i = row.getInteger("count");

    System.out.println("Got " + i + "  - DataSource good.");
    System.out.println("Test connection done");

  }
}
