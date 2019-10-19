import org.testng.Assert;
import org.testng.annotations.*;

public class KlasaTestowa {

    String imie ="Michal";

    @BeforeClass
    public void setUp(){
        imie="Jan";
    }

    @AfterMethod
    public void tearDown(){
        Assert.assertEquals(imie, "Jan1");
    }


    @Test
    public void PierwszyTest() {
        System.out.println("To jest mój pierwszy test");
        Assert.assertEquals(1, 1);
    }

    @Test
    public void czyImieToJan() {
        Assert.assertEquals("Michal", imie);
    }
}

