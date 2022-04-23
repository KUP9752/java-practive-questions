package UnreliableBufferedReader5d30;

import com.sun.nio.sctp.PeerAddressChangeNotification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Random;

public class UnreliableBufferedReader extends BufferedReader {

    private double probabilityOfError;
    private Random random = new Random();
    public static int errorCounter = 0;
    public static int correctReads = 0;



    public UnreliableBufferedReader(Reader in, int sz, double probOfError) {
        super(in, sz);
        setProbabilityOfError(probOfError);
    }

    public UnreliableBufferedReader(Reader in, double probOfError) {
        super(in);
        setProbabilityOfError(probOfError);
    }

    public void setProbabilityOfError(double probabilityOfError) {
        if (probabilityOfError >= 0) {
            if (probabilityOfError <= 1) {
                this.probabilityOfError = probabilityOfError;
            } else {
                this.probabilityOfError = 1;
            }
        } else {
            this.probabilityOfError = 0;
        }
    }

    @Override
    public String readLine() throws IOException {
//        String line = super.readLine();
        double prob = random.nextDouble();
        if (prob < probabilityOfError) {
            errorCounter++;
            throw new IOException("Error occurred on input stream");
        }
        correctReads++;
        return super.readLine();

    }

    public static void main(String[] args) {
        UnreliableBufferedReader ubr = new  UnreliableBufferedReader(new InputStreamReader(System.in),  .5);
        String line;
        while (correctReads < 5) {
            System.out.println("Attempting to read from Unreliable Reader...");
            try {
                line = ubr.readLine();
                System.out.println("Successful!");
                System.out.println(line);
            } catch (IOException e) {
                System.out.println("Failed!");
            }
        }
        System.out.println("Total calls to readline: " + (correctReads + errorCounter));

    }
}
