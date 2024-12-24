package us.bakenh.inventar;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import us.bakenh.inventar.domain.model.ConfigModel;

import java.io.InputStream;

public class Config {

    public static ConfigModel loadFromFile() {

        Yaml yaml = new Yaml(new Constructor(ConfigModel.class, new LoaderOptions()));
        InputStream inputStream = Config.class
                .getClassLoader()
                .getResourceAsStream("config.yml");

        return yaml.load(inputStream);
    }
}
