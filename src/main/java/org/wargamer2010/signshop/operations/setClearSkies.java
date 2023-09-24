package org.wargamer2010.signshop.operations;

import org.bukkit.World;
import org.wargamer2010.signshop.SignShop;
import org.wargamer2010.signshop.player.SignShopPlayer;

public class setClearSkies implements SignShopOperation {
    @Override
    public Boolean setupOperation(SignShopArguments ssArgs) {
        return true;
    }

    @Override
    public Boolean checkRequirements(SignShopArguments ssArgs, Boolean activeCheck) {
        World world = ssArgs.getPlayer().get().getPlayer().getWorld();
        if(!world.hasStorm() && !world.isThundering()) {
            ssArgs.sendFailedRequirementsMessage("already_clear_skies");
            return false;
        }
        return true;
    }

    @Override
    public Boolean runOperation(SignShopArguments ssArgs) {
        World world = ssArgs.getPlayer().get().getPlayer().getWorld();
        world.setStorm(false);
        world.setThundering(false);

        SignShopPlayer.broadcastMsg(world, SignShop.getInstance().getSignShopConfig().getError("made_clear_skies", ssArgs.getMessageParts()));
        return true;
    }
}
