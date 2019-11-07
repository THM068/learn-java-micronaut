package learn.java.command;

public class RemoteControl {

    Command [] onCommands;
    Command [] offCommands;

    public RemoteControl() {
        onCommands = new Command[1];
        offCommands = new Command[1];

        Command noCommand = new NoCommand();
        for(int i=0 ; i < 1; i++) {
            offCommands[i] = noCommand;
            onCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command offCommand, Command onCommand) {
        offCommands[slot] = offCommand;
        onCommands[slot] = onCommand;
    }


}
class NoCommand implements Command {

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}

