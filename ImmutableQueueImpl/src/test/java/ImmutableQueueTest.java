import com.paybaymax.immutable.queue.ImmutableQueue;
import com.paybaymax.immutable.queue.Queue;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by Ram on 24-Dec-19.
 */
public class ImmutableQueueTest {

    @Test
    public void isNullNew(){
        Queue<Integer> immutableQueue = ImmutableQueue.getEmptyQueue();
        Assert.assertTrue(immutableQueue.isEmpty());
    }
    @Test
    public void enQueueHeadTest(){

        Queue<Integer> immutableQueue = ImmutableQueue.getEmptyQueue();
        Assert.assertTrue(immutableQueue.isEmpty());
        immutableQueue = immutableQueue.enQueue(11);
        Assert.assertTrue(!immutableQueue.isEmpty());
        immutableQueue = immutableQueue.enQueue(22);
        immutableQueue =  immutableQueue.enQueue(33);
        Assert.assertTrue(immutableQueue.head().equals(11));

    }

    @Test
    public void deQueueCustomObjectTest(){
        Queue<Pay> immutableQueue = ImmutableQueue.getEmptyQueue();
        Assert.assertTrue(immutableQueue.isEmpty());
        Pay pay1 = new Pay("A",new BigDecimal(123));
        Pay pay2 = new Pay("B",new BigDecimal(456));
        Pay pay3 = new Pay("C",new BigDecimal(789));
        Pay pay4 = new Pay("D",new BigDecimal(789));
        Pay pay5 = new Pay("E",new BigDecimal(104));
        immutableQueue = immutableQueue.enQueue(pay1);
        immutableQueue = immutableQueue.enQueue(pay2);
        immutableQueue = immutableQueue.enQueue(pay3);
        immutableQueue = immutableQueue.enQueue(pay4);
        immutableQueue = immutableQueue.enQueue(pay5);
       System.out.println(immutableQueue.head() );
        immutableQueue = immutableQueue.deQueue();
       System.out.println(immutableQueue.head() );
        immutableQueue = immutableQueue.deQueue();
       System.out.println(immutableQueue.head() );
        immutableQueue = immutableQueue.deQueue();
       System.out.println(immutableQueue.head() );
        immutableQueue = immutableQueue.deQueue();
        System.out.println(immutableQueue.head() );
        immutableQueue = immutableQueue.deQueue();
        Assert.assertTrue(immutableQueue.isEmpty());

    }

}
