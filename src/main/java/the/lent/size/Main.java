package the.lent.size;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("size").setExecutor(new SizeCommand());
    }
}
