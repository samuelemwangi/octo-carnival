package library.cache;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LRUCacheTest {

    @Test
    public void testLRUCache(){
        LRUCache<Integer, Integer> cache = new LRUCache<>();
        cache.set(1,2);
        cache.set(7,8);
        cache.set(9,9);
        cache.set(10,8);
        cache.set(76, 12);
        cache.set(11, 23);

        Assert.assertEquals(cache.get(7), 8);
        Assert.assertEquals(cache.get(11), 23);
    }
}
