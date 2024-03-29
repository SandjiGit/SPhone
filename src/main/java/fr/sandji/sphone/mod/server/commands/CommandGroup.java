
/*
 * SPhone - Tous droits réservés. (by 0hSandji)
 */

package fr.sandji.sphone.mod.server.commands;

import de.maxhenkel.voicechat.api.Group;
import fr.sandji.sphone.api.voicechat.SPhoneAddon;
import fr.sandji.sphone.mod.common.items.ItemPhone;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class CommandGroup extends CommandBase {
    @Override
    public String getName() {
        return "group";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/group <group> <test>";
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args[0].equals("create")) {
            if (!args[1].isEmpty()) {
                //SPhoneAddon.createGroup(args[1], false, Group.Type.OPEN);
                sender.sendMessage(new TextComponentString("Vous avez crée le Group : " + args[1]));
            }
        }
        if (args[0].equals("add")) {
            if (!args[1].isEmpty()) {
                if (!args[2].isEmpty()) {
                    EntityPlayer player = sender.getServer().getPlayerList().getPlayerByUsername(args[2]);
                    //SPhoneAddon.addToGroup(args[1], player);
                    sender.sendMessage(new TextComponentString("Vous avez ajouté le joueur : " + args[2] + " au Group : " + args[1] + " ."));
                }
            }
        }
        if (args[0].equals("remove")) {
            if (!args[1].isEmpty()) {
                EntityPlayer player = sender.getServer().getPlayerList().getPlayerByUsername(args[1]);
                //SPhoneAddon.removeFromActualGroup(player);
                sender.sendMessage(new TextComponentString("Vous avez retirer le joueur : " + args[1] + " de son Group Actuel"));
            }
        }
    }

}
