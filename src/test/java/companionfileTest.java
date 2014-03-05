import org.junit.Test;
import org.junit.Assert;

/**
 * Author: Andrea Cadeddu, cadedduan@gmail.com
 * Date: 3/4/14
 */
public class companionfileTest {
    @Test
    public void testParse_json() throws Exception {
        String json = "{'entries':[" +
                "{\"format\":{" +
                "\"height\":500," +
                "\"width\":600," +
                "\"fname\":\"test.svg\"}," +
                "\"data\":{" +
                "'smiles': '[OH:1][CH2:2][c:3]1[cH:8][cH:7][n:6][cH:5][cH:4]1'," +
                " 'pairs': [" +
                "{'a': 3, 'color': '000000', 'b': 4}," +
                " {'a': 1, 'color': 'FF0000', 'b': 2}," +
                " {'a': 6, 'color': 'FF0000', 'b': 7}, " +
                "{'a': 8, 'color': 'FF0000', 'b': 7}, " +
                "{'a': 2, 'color': '00FF00', 'b': 3}, " +
                "{'a': 8, 'color': '000000', 'b': 3}, " +
                "{'a': 5, 'color': 'FF0000', 'b': 6}, " +
                "{'a': 4, 'color': '000000', 'b': 5}]" +
                "}" +
                "}," +
                "{\"format\":{" +
                "\"height\":500," +
                "\"width\":600," +
                "\"fname\":\"test.svg\"}," +
                "\"data\":{" +
                "'smiles': '[OH:1][CH2:2][c:3]1[cH:8][cH:7][n:6][cH:5][cH:4]1'," +
                " 'pairs': [" +
                "{'a': 3, 'color': '000000', 'b': 4}," +
                " {'a': 1, 'color': 'FF0000', 'b': 2}," +
                " {'a': 6, 'color': 'FF0000', 'b': 7}, " +
                "{'a': 8, 'color': 'FF0000', 'b': 7}, " +
                "{'a': 2, 'color': '00FF00', 'b': 3}, " +
                "{'a': 8, 'color': '000000', 'b': 3}, " +
                "{'a': 5, 'color': 'FF0000', 'b': 6}, " +
                "{'a': 4, 'color': '000000', 'b': 5}]" +
                "}" +
                "}" +
                "]}";


        Entries entries = new companionfile().parse_json(json);
        Assert.assertEquals(2, entries.getEntries().size());
        for (Entry e : entries.getEntries()){
            Format f = e.getFormat();
            Assert.assertEquals("test.svg",f.getFname());
            Assert.assertEquals(500,f.getHeight());
            Assert.assertEquals(600,f.getWidth());
        }
    }
}
