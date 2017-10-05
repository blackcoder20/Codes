import java.io.*;
import java.util.*;
import java.math.*;
class h3 {
public static void main(String[] args) {
	InputReader s=new InputReader(System.in);
	int n=s.nextInt();
	int m=s.nextInt();
    int k=s.nextInt();
    long ans=1L*n*m;
    HashMap<Integer,ArrayList<Interval>> h=new HashMap<Integer,ArrayList<Interval>>();
    while(k-->0){
        int r=s.nextInt();
        int c1=s.nextInt();
        int c2=s.nextInt();
        if(!h.containsKey(r)){
            ArrayList<Interval> a=new ArrayList<Interval>();
            Interval in=new Interval(c1,c2);
            a.add(in);
            h.put(r,a);
        }
        else{
            ArrayList<Interval> a=new ArrayList<Interval>();
            a=h.get(r);
            Interval in=new Interval(c1,c2);
            a.add(in);
            h.put(r,a);
        }
}
for (int i:h.keySet()){
    ArrayList<Interval> a=new ArrayList<Interval>();
        a=h.get(i);
        a=merge(a);
        int j=0;
        while(j<a.size()){
            System.out.print(a.get(j).start+" "+a.get(j).end+"   ");
            j++;
        }
        System.out.println();
}
 


    for(int i:h.keySet()){
        ArrayList<Interval> a=new ArrayList<Interval>();
        a=h.get(i);
        a=merge(a);
       // System.out.println("arr is "+ a);
        for (int j=0;j<a.size();j++) {
            //System.out.println("arr is "+ a.get(j).get);
            ans-=(a.get(j).end-a.get(j).start+1);
        }
    }
System.out.println(ans);

	}	
    static class Interval{
        int start;
        int end;
        public Interval(){

        }
        public Interval(int x,int y){
            start=x;
            end=y;
        }
    }

   static public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

    ArrayList<Interval> result = new ArrayList<Interval>();
 
    if(intervals==null||intervals.size()==0)
        return result;
 
    Collections.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2){
            if(i1.start!=i2.start)
                return i1.start-i2.start;
            else
                return i1.end-i2.end;
        }
    });
 
    Interval pre = intervals.get(0);
    for(int i=0; i<intervals.size(); i++){
        Interval curr = intervals.get(i);
        if(curr.start>pre.end){
            result.add(pre);
            pre = curr;
        }else{
            Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
            pre = merged;
        }
    }
    result.add(pre);
 
    return result;
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