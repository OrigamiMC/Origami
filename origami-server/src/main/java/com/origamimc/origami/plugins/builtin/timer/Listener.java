package com.origamimc.origami.plugins.builtin.timer;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.notifications.NotificationService;
import net.minecraft.server.players.IpBanListEntry;
import net.minecraft.server.players.NameAndId;
import net.minecraft.server.players.ServerOpListEntry;
import net.minecraft.server.players.UserBanListEntry;
import net.minecraft.world.level.gamerules.GameRule;
import org.jspecify.annotations.NonNull;

public class Listener implements NotificationService {

    @Override
    public void playerJoined(@NonNull ServerPlayer player) {
        player.getOrigamiPlayer().sendMessage("Welcome to the server!");
    }

    @Override
    public void playerLeft(@NonNull ServerPlayer player) {

    }

    @Override
    public void serverStarted() {

    }

    @Override
    public void serverShuttingDown() {

    }

    @Override
    public void serverSaveStarted() {

    }

    @Override
    public void serverSaveCompleted() {

    }

    @Override
    public void serverActivityOccured() {

    }

    @Override
    public void worldUpgradeStarted() {

    }

    @Override
    public void worldUpgradeProgress(float progressPercentage) {

    }

    @Override
    public void worldUpgradeFinished() {

    }

    @Override
    public void worldUpgradeFailed(String reason) {

    }

    @Override
    public void playerOped(@NonNull ServerOpListEntry operator) {

    }

    @Override
    public void playerDeoped(@NonNull ServerOpListEntry operator) {

    }

    @Override
    public void playerAddedToAllowlist(@NonNull NameAndId player) {

    }

    @Override
    public void playerRemovedFromAllowlist(@NonNull NameAndId player) {

    }

    @Override
    public void ipBanned(@NonNull IpBanListEntry ban) {

    }

    @Override
    public void ipUnbanned(@NonNull String ip) {

    }

    @Override
    public void playerBanned(@NonNull UserBanListEntry ban) {

    }

    @Override
    public void playerUnbanned(@NonNull NameAndId player) {

    }

    @Override
    public <T> void onGameRuleChanged(@NonNull GameRule<T> gameRule, @NonNull T value) {

    }

    @Override
    public void statusHeartbeat() {

    }
}
