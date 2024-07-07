package the.lent.size;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.attribute.AttributeModifier;



public class SizeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Player target = null;



            String playerName = args[0];
            target = Bukkit.getServer().getPlayerExact(playerName);

            player.sendMessage(ChatColor.RED + "needs more args");

            double size;
            try {
                size = Double.parseDouble(args[1]);
            } catch (NumberFormatException e) {
                player.sendMessage("Invalid size! Must be a number!");
                return true;
            }

            if (target == null) {
                player.sendMessage(ChatColor.RED + "This player is not online!");

            } else {
                player.sendMessage(ChatColor.GREEN + "Successfully sized player");
                target.sendMessage(ChatColor.GREEN + "You have been sized!");
                target.getAttribute(Attribute.GENERIC_SCALE).setBaseValue(size);
            }
        }



        return true;
    }
}
