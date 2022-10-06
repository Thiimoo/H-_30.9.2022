package net.htlgrieskirchen.pos3.streams;

import java.util.stream.IntStream;

public class Quad {
    final int result = IntStream.of(1,2,3,4,5,6,7,8,9,10).filter( m-> m>0||m<10).map(m->m*m).reduce(0, (a, b) -> a + b);

    public int getResult() {
        return result;
    }
}
