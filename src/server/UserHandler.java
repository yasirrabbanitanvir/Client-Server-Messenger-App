package server;

import java.util.Scanner;

public class UserHandler implements Runnable {// oneak gula user hoyar jonno 
    
    private Server server;//server class
    private User user;//user class 

    public UserHandler(Server server, User user) {
        this.server = server;
        this.user = user;
        this.server.broadcastAllUsers();// all user message 
    }

    @Override
    public void run() {
        String message;

        Scanner scanner = new Scanner(this.user.getInputStream());
        while(scanner.hasNextLine()) {// user theke data neyo
            message = scanner.nextLine();

            if(message.charAt(0) == '@') {// private message 
                if(message.contains(" ")) {
                    System.out.println("Private message: " + message);
                    int firstSpace = message.indexOf(" ");
                    //  name gula extruct kora, kake pathailam 
                    String receiver = message.substring(1, firstSpace);
                    String extractMessage = message.substring(firstSpace+1);

                    server.sendMessageToUser(extractMessage, user, receiver);
                }
            }else {
                server.broadcastMessages(message, user);// broadcast 
            }
        }

        server.removeUser(user);// tab kater por take remove kore dilam 
        this.server.broadcastAllUsers();// update connect user 
        scanner.close();
    }
}
