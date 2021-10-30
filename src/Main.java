public class Main {
    public static void main(String arg[]) {
        Command command1 = new LightCommand(new Light());
        Command command2 = new PlayMusicCommand(new MusicPlayer());
        Command command3 = new MakeCoffeeCommand(new CoffeeMachine());
        Command command4 = new LightAndMusicCommand(new Light(), new MusicPlayer());
        Command command5 = new PhoneCommand(new Phone(), "Mike");

        Button button = new Button(command5);
        button.pressButton();
    }
}

class Button {
    Command command;

    public Button(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

interface Command {
    public void execute();
}

class LightCommand implements Command {
    Light light;

    public LightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchLight();
    }
}

class PlayMusicCommand implements Command {
    MusicPlayer musicPlayer;

    public PlayMusicCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.playMusic();
    }
}

class MakeCoffeeCommand implements Command {
    CoffeeMachine coffeeMachine;

    public MakeCoffeeCommand(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void execute() {
        coffeeMachine.makeCoffee();
    }
}

class LightAndMusicCommand implements Command {
    Light light;
    MusicPlayer musicPlayer;

    public LightAndMusicCommand(Light light, MusicPlayer musicPlayer) {
        this.light = light;
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        light.switchLight();
        musicPlayer.playMusic();
    }
}

class PhoneCommand implements Command {
    Phone phone;
    String name;

    public PhoneCommand(Phone phone, String name) {
        this.phone = phone;
        this.name = name;
    }

    @Override
    public void execute() {
        phone.call(name);
    }
}

class Light {
    boolean isOn;

    public void switchLight() {
        this.isOn = !this.isOn;
        System.out.println("Light is " + isOn);
    }
}

class MusicPlayer {
    public void playMusic() {
        System.out.println("Play music");
    }
}

class CoffeeMachine {
    public void makeCoffee() {
        System.out.println("Make coffee");
    }
}

class Phone {
    public void call(String name) {
        System.out.println("Call to " + name);
    }
}
