package adt.heap;
 
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
 
import java.util.Arrays;
import java.util.Comparator;
 
import org.junit.Before;
import org.junit.Test;
 
public class StudentMinHeapTest {
 
    Heap<Integer> heap;
 
    @Before
    public void setUp() {
        // TODO Instancie seu comparator para fazer sua estrutura funcionar como
        // uma min heap aqui. Use instanciacao anonima da interface
        // Comparator!!!!
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        heap = new HeapImpl<Integer>(comparator);
    }
 
    @Test
    public void testBuild() {
        heap.buildHeap(new Integer[] { 82, 6, 99, 12, 34, 64, 58, 1 });
 
        assertEquals(8, heap.size());
        assertFalse(heap.isEmpty());
 
        verifyHeap(new Integer[] { 1, 6, 58, 12, 34, 64, 99, 82 });
    }
 
    @Test
    public void testInsert() {
        heap.insert(8);
        heap.insert(12);
        heap.insert(-2);
        heap.insert(7);
        heap.insert(8);
        heap.insert(-5);
        heap.insert(14);
        heap.insert(3);
        heap.insert(-10);
        heap.insert(0);
 
        assertEquals(10, heap.size());
        assertFalse(heap.isEmpty());
 
        verifyHeap(new Integer[] { -10, -5, -2, 3, 0, 8, 14, 12, 7, 8 });
    }
 
    @Test
    public void testRemove() {
        heap.insert(22);
        heap.insert(45);
        heap.insert(38);
        heap.insert(17);
        heap.insert(40);
        heap.insert(15);
        heap.insert(26);
        heap.insert(79);
        heap.insert(53);
        heap.insert(30);
 
        assertEquals(new Integer(15), heap.extractRootElement());
        assertEquals(new Integer(17), heap.extractRootElement());
        assertEquals(new Integer(22), heap.extractRootElement());
        assertEquals(new Integer(26), heap.extractRootElement());
        assertEquals(new Integer(30), heap.extractRootElement());
 
        assertEquals(5, heap.size());
        assertFalse(heap.isEmpty());
 
        verifyHeap(new Integer[] { 38, 40, 79, 45, 53 });
    }
 
    @Test
    public void testCustom() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
 
        heap.insert(0);
        heap.insert(10);
        heap.insert(20);
        heap.insert(-1);
        heap.insert(-2);
        heap.insert(Integer.MAX_VALUE);
        heap.insert(Integer.MIN_VALUE);
        heap.insert(1);
        heap.insert(0);
        heap.insert(0);
        heap.insert(12);
        heap.insert(100);
        heap.insert(109);
        heap.insert(101);
 
        assertFalse(heap.isEmpty());
        assertEquals(14, heap.size());
        verifyHeap(new Integer[]{Integer.MIN_VALUE, -1, -2, 0, 0, 100, 20, 10, 1, 0, 12, Integer.MAX_VALUE, 109, 101});
 
        Integer[] array = new Integer[]{Integer.MAX_VALUE, 12, 109, 0, 1, 100, 101, -1, 0, -2, 0, 10, 20, Integer.MIN_VALUE};
        Arrays.sort(array);
 
        assertArrayEquals(array, heap.heapsort(new Integer[]{Integer.MAX_VALUE, 12, 109, 0, 1, 100, 101, -1, 0, -2, 0, 10, 20, Integer.MIN_VALUE}));
        assertTrue(heap.isEmpty());
        verifyHeap(new Integer[]{});
 
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, heap.heapsort(new Integer[]{4, 2, 3, 1}));
        assertTrue(heap.isEmpty());
        verifyHeap(new Integer[]{});
 
        heap.insert(0);
        heap.insert(10);
        heap.insert(20);
        heap.insert(-1);
        heap.insert(-2);
        heap.insert(Integer.MAX_VALUE);
        heap.insert(Integer.MIN_VALUE);
        heap.insert(1);
        heap.insert(0);
        heap.insert(0);
        heap.insert(12);
        heap.insert(100);
        heap.insert(109);
        heap.insert(101);
        heap.insert(null);
        assertEquals(14, heap.size());
        heap.insert(null);
        assertEquals(14, heap.size());
 
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
 
        ((HeapImpl)heap).setComparator(comparator);
 
        assertFalse(heap.isEmpty());
        assertEquals(14, heap.size());
        verifyHeap(new Integer[]{Integer.MAX_VALUE, 12, 109, 0, 1, 100, 101, -1, 0, -2, 0, 10, 20, Integer.MIN_VALUE});
    }
 
    @Test
    public void testSort() {
        assertArrayEquals(new Integer[] { 5, 6, 12, 20, 34, 43, 49, 92 },
                heap.heapsort(new Integer[] { 34, 92, 5, 12, 49, 20, 43, 6 }));
 
        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
 
        assertArrayEquals(new Integer[] {}, heap.toArray());
    }
 
    private void verifyHeap(Integer[] expected) {
        boolean isHeap = true;
 
        Comparable<Integer>[] original = heap.toArray();
 
        Arrays.sort(expected);
        Arrays.sort(original);
 
        if (Arrays.equals(expected, original) == false)
            isHeap = false;
 
        original = heap.toArray();
 
        for (int i = 0; i < original.length; i++) {
            if (2 * i + 1 < original.length && original[i].compareTo((Integer) original[2 * i + 1]) > 0)
                isHeap = false;
            if (2 * i + 2 < original.length && original[i].compareTo((Integer) original[2 * i + 2]) > 0)
                isHeap = false;
        }
 
        assertTrue(isHeap);
    }
 
 
    @Test
    public void testShortestPath(){
 
        int INF = 10233912;
 
        Comparator<Pair> comp = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.compareTo(o1);
            }
        };
 
        Heap<Pair> pq = new HeapImpl<>(comp);
 
        int[][] graph = new int[][]{{0,5,28,0,0,3,0},{0,0,0,7,11,0,0}, {15,0,0,0,0,0,19},{0,0,0,0,0,0,30},
                {9,0,0,0,0,2,0}, {0,0,0,0,0,0,91}, {0,0,0,0,0,7,0}};
        int[] dist = new int[]{INF,INF,INF,INF,INF,INF,INF};
        int numberOfVertices = 7;
 
        int start = 0;
        int end = 6;
        int ans = 42;
 
        pq.insert(new Pair(0,0));
        dist[start] = 0;
 
        while(!pq.isEmpty()){
 
 
            int vertex = pq.rootElement().left;
            int distSoFar = pq.rootElement().right;
            pq.extractRootElement();
 
            for(int i = 0 ; i < numberOfVertices ; i++){
 
                if(graph[vertex][i] == 0) continue;
 
                if(distSoFar + graph[vertex][i] < dist[i]) {
                    dist[i] = distSoFar + graph[vertex][i];
                    pq.insert(new Pair(i, dist[i]));
                }
 
            }
 
        }
 
        assertEquals(ans, dist[end]);
    }
 
    static class Pair implements Comparable<Pair>{
        public int left;
        public int right;
        public Pair(int a, int b){
            left = a;
            right = b;
        }
        @Override
        public boolean equals(Object other){
            if(other instanceof Pair){
                return ((Pair) other).left == this.left && ((Pair) other).right == this.right;
            }
            return false;
        }
 
        @Override
        public int compareTo(Pair other) {
            if (other.left == this.left)
                if (other.right == this.right) return 0;
                else if (this.right > other.right) return 1;
                else return -1;
 
            if (this.left > other.left) return 1;
            else return -1;
        }
    }
 
}