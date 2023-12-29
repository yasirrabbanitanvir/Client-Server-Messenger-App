package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

public class User {
    private static int numberOfUser = 0;
    private int userId;
    private PrintStream streamOut;
    private InputStream streamIn;
    private String nickName;
    private Socket client;

    public User(Socket client, String name) throws IOException {
        this.streamOut = new PrintStream(client.getOutputStream());
        this.streamIn = client.getInputStream();
        this.client = client;
        this.nickName = name;
        this.userId = numberOfUser;

        numberOfUser += 1;
    }

    public PrintStream getOutStream() {
        return this.streamOut;
    }

    public InputStream getInputStream() {
        return this.streamIn;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String toString() {
        return "<u>" + this.getNickName() + "</u>";
    }

}