package learn.java.command;

public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void startCommand() {
        this.command.execute();
    }

    public void undo() {
        this.command.undo();
    }
}
