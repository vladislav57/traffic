import java.io.*;
import java.net.Socket;

public class Traffic {
    public static void main(String[] args) throws IOException, InterruptedException {

        try(Socket socket = new Socket("google.com", 80);) {

            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            pw.println("GET http://www.google.com/ HTTP/1.1");
            pw.println("Host: google.com");
            pw.println("Accept: */*");
            pw.println("Cache-control: no-cache");
            pw.println("");
            pw.flush();

            //Thread.sleep(5);

            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }

        }
    }
}
