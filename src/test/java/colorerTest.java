import org.junit.Test;
import org.junit.Assert;

import java.awt.*;

/**
 * Author: Andrea Cadeddu, cadedduan@gmail.com
 * Date: 3/4/14
 */
public class colorerTest {
    @Test
    public void shrinkColors() throws Exception {
            colorer cz= new colorer();
            Color c = new Color(0,0,0);
            Color d=cz.shrinkColors(c);
            Assert.assertEquals(c,d);
            d=cz.shrinkColors(new Color(0,100,0)); //100%4 is 0.
            Assert.assertEquals(new Color(0,100,0).getGreen(),d.getGreen());
            d=cz.shrinkColors(new Color(0,99,0)); //100%4 is 0.
            Assert.assertEquals(new Color(0,96,0).getGreen(),d.getGreen());

    }
}
