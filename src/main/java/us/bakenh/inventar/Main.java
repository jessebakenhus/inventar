package us.bakenh.inventar;

import us.bakenh.inventar.domain.model.ConfigModel;

public class Main {

    public static void main(String[] args) {

        ConfigModel configModel = Config.loadFromFile();

        new MainApp().start(configModel);
    }
}