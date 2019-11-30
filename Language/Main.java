import antlr.*;
import java.io.*;

public class Main {
	private Device myDevice;
	public Main(Device d)
	{
		myDevice = d;
	}
        public static void main(String[] args) throws Exception {
                L lexer = new L(new DataInputStream(System.in));
                P parser = new P(lexer);
                int parser.startRule(myDevice);
                //System.out.println(x);
        }
}