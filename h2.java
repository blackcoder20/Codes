import java.io.*;
import java.util.*;
class h2 {
    public static void main(String[] args) {
        InputReader s=new InputReader(System.in);
        int n=s.nextInt();
        char c[]=s.nextToken().toCharArray();
        int a[]=new int[26];
        int ans=0;
        for (int i=0;i<n;i++) {
            a[c[i]-'a']++;
        }
        for (int i=0;i<26;i++) {
            for (int j=i+1;j<26;j++ ) {
                if(a[i]>0 && a[j]>0){
                    ArrayList<Character> tmp=new ArrayList<Character>();
                    char c1=(char)(i+97);
                    char c2=(char)(j+97);
                    for (int k=0;k<n;k++) {
                        if(c[k]==c1 || c[k]==c2){
                            tmp.add(c[k]);
                        }
                    }
                    boolean repeat=false;
                    for (int k=0;k<tmp.size()-1;k++) {
                        if(tmp.get(k)==tmp.get(k+1))
                        {
                            repeat=true;
                            break;
                        }
                    }
                    if(!repeat)
                        ans=Math.max(ans,tmp.size());

                }
            }
        }

System.out.println(ans);

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