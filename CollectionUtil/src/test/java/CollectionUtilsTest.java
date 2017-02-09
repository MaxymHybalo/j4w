
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CollectionUtilsTest {


    @Test(dataProvider = "dataProvider")
    public void filterTest(List<Integer> data, List<Integer> expected){
        List<Integer> list = CollectionUtils.filter(data,e->e%2==0);
        Assert.assertEquals(list,expected);
    }


    @Test(dataProvider = "dataProvider")
    public void anyMatchTest(List<Integer> data, List<Integer> expected){
        boolean test = CollectionUtils.anyMatch(data,e->e%2==0);
        Assert.assertTrue(test);
    }

    @Test(dataProvider = "dataProvider")
    public void allMatchTest(List<Integer> data, List<Integer> expected){
        boolean test = CollectionUtils.allMatch(data,e->e<100);
        Assert.assertTrue(test);
    }

    @Test(dataProvider = "dataProvider")
    public void noneMatchTest(List<Integer> data, List<Integer> expected){
        boolean test = CollectionUtils.noneMatch(data,e->e>20);
        Assert.assertTrue(test);
    }


    @Test(dataProvider = "mapDataProvider")
    public void mapTest(List<Integer> data, List<Integer> expected){
        List<Integer> test = CollectionUtils.map(data,e->e+1);
        Assert.assertEquals(test,expected);
    }

    @Test(dataProvider = "dataProvider")
    public void maxTest(List<Integer> data, List<Integer> expected){
        Optional<Integer> test = CollectionUtils.max(data,(x, y)->Integer.compare(x,y));
        Assert.assertEquals(test.get(),new Integer(10));
    }

    @Test(dataProvider = "dataProvider")
    public void minTest(List<Integer> data, List<Integer> expected){
        Optional<Integer> test = CollectionUtils.min(data,(x, y)->Integer.compare(x,y));
        Assert.assertEquals(test.get(),new Integer(1));
    }
    @Test(dataProvider = "distinctProvider")
    public void distinctTest(List<Integer> data, List<Integer> expected){
        List<Integer> test = CollectionUtils.distinct(data);
        Assert.assertEquals(test,expected);
    }
    @Test(dataProvider = "dataProvider")
    public void reduceTest(List<Integer> data, List<Integer> expected){
        Optional<Integer> test = CollectionUtils.reduce(data,
                (x,y)->x+y);
        int presented = test.get();
        Assert.assertEquals(presented,55);
    }
    @Test(dataProvider = "dataProvider")
    public void seedReduceTest(List<Integer> data, List<Integer> expected){
        Integer test = CollectionUtils.reduce(0,data,(x,y)->x+y);
        Assert.assertEquals(test,new Integer(55));
    }
    @Test(dataProvider = "dataProvider")
    public void partitionByTest(List<Integer> data, List<Integer> expected){
        Map<Boolean,List<Integer>> test = CollectionUtils.partitionBy(data,e-> e%2==0);
        Assert.assertEquals(test.get(true),expected);
    }

    @DataProvider
    public Object [][] dataProvider(){
        return new Object[][]{
                {
                        Arrays.asList(1,2,3,4,5,6,7,8,9,10),
                        Arrays.asList(2,4,6,8,10)
                }
        };

    }

    @DataProvider
    public Object [][] mapDataProvider(){
        return new Object[][]{
                {
                        Arrays.asList(1,2,3,4,5,6,7,8,9,10),
                        Arrays.asList(2,3,4,5,6,7,8,9,10,11)
                }
        };

    }
    @DataProvider
    public Object [][] distinctProvider(){
        return new Object[][]{
                {
                        Arrays.asList(1,1,3,4,5,6,7,8,10,10),
                        Arrays.asList(1,3,4,5,6,7,8,10)
                }
        };

    }

}
