import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

class testcase
{
    public List<Integer> listExpected;
    public List<Integer> listInput;
    public testcase(List<Integer> li, List<Integer>le)
    {
        this.listExpected = le;
        this.listInput = li;
    }
}

@RunWith(Parameterized.class)
public class PriorityQueueTest {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    private List<Integer> expected;
    private List<Integer> in;

    @Parameters
    public static Collection getTestParameters() {
        List<Integer> li1 = Arrays.asList(5,2,4,1,3);
        List<Integer> le1 = Arrays.asList(1,2,3,4,5);
        testcase t1 = new testcase(li1, le1);
        List<Integer> li2 = Arrays.asList(15,12,14,11,16,13);
        List<Integer> le2 = Arrays.asList(11,12,13,14,15,16);
        testcase t2 = new testcase(li2, le2);
        List<Integer> li3 = Arrays.asList(25,22,24,21,26,23,27);
        List<Integer> le3 = Arrays.asList(21,22,23,24,25,26,27);
        testcase t3 = new testcase(li3, le3);
        List<Integer> li4 = Arrays.asList(35,32,34,31,38,36,33,37);
        List<Integer> le4 = Arrays.asList(31,32,33,34,35,36,37,38);
        testcase t4 = new testcase(li4, le4);
        List<Integer> li5 = Arrays.asList(45,42,44,41,48,46,43,47,40);
        List<Integer> le5 = Arrays.asList(40,41,42,43,44,45,46,47,48);
        testcase t5 = new testcase(li5, le5);
        return Arrays.asList(new testcase[][] {
                {t1}, {t2}, {t3}, {t4}, {t5}
        });

    }

    public PriorityQueueTest(testcase a){
        this.expected = a.listExpected;
        this.in = a.listInput;
        //System.out.println(this.expected);
        //System.out.println(this.in);
    }

    @Test
    public void testpoll() {

        for(Integer j : in)
        {
            //System.out.println(j);
            pq.add(j);
        }
        for(Integer j : expected)
        {
            assertEquals(j, pq.poll());
        }

    }

    @Test(expected = NullPointerException.class)
    public void testadd()
    {
        pq.add(null);
    }

    @Test(expected = NullPointerException.class)
    public void testoffer()
    {
        pq.offer(20);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor()
    {
        PriorityQueue p = new PriorityQueue(-10);
    }



}
