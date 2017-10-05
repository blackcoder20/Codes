import java.io.*;
import java.util.*;
public class cards{
public static void main(String[] args) {
	InputReader s=new InputReader(System.in);
	int n=s.nextInt();
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
    int sum=0;
    ArrayList<Integer> a=new ArrayList<Integer>();
    for (int i=1;i<=n;i++) {
        int x=s.nextInt();
        sum+=x;
        a.add(x);
        h.put(x,i);
    }
    int i=0;
    int count=0;
    sum=sum/(n/2);
    System.out.println(sum);
    while(count<n/2) {
        int y=a.get(i);
        int z=sum-y;
        int a1=h.get(y);
        h.remove(y);
        int a2=h.get(z);
        a.remove(a.indexOf(y));
        a.remove(a.indexOf(z));
        
        h.remove(z);
        System.out.print(a1+" "+a2);
        count++;
        System.out.println();
    }
	


	}	
	static class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;
 
    public InputReader(InputStream stream) {
        this.stream = stream;
    }
 
    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }
 
    public int nextInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public long nextLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public String nextToken() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
 
    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return isWhitespace(c);
    }
 
    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}
}