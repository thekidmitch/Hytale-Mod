package com.mitch.aicompanion;

import com.hypixel.hytale.server.core.asset.AssetModule;
import com.hypixel.hytale.assetstore.AssetPack;
import com.hypixel.hytale.codec.ExtraInfo;
import com.hypixel.hytale.codec.util.RawJsonReader;
import com.hypixel.hytale.common.plugin.PluginManifest;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class AssetPackLoader {

    private static final String PACK_ID = "mitch:AICompanionData";

    private AssetPackLoader() {
    }

    public static void register(JavaPlugin plugin) {
        String appData = System.getenv("APPDATA");

        if (appData == null || appData.isBlank()) {
            plugin.getLogger().atWarning().log(
                    "AICompanion: APPDATA environment variable not found."
            );
            return;
        }

        Path packPath = Paths.get(
                appData, "Hytale", "UserData", "Mods", "AICompanionData"
        ).toAbsolutePath().normalize();

        Path manifestPath = packPath.resolve("manifest.json");

        plugin.getLogger().atInfo().log(
                "AICompanion: Checking asset pack at " + packPath
        );

        if (!Files.isDirectory(packPath) || !Files.isRegularFile(manifestPath)) {
            plugin.getLogger().atWarning().log(
                    "AICompanion: Asset pack folder or manifest not found: " + packPath
            );
            return;
        }

        AssetModule assetModule = AssetModule.get();

        if (assetModule == null) {
            plugin.getLogger().atWarning().log(
                    "AICompanion: AssetModule is not available yet."
            );
            return;
        }

        if (assetModule.getAssetPack(PACK_ID) != null) {
            plugin.getLogger().atInfo().log(
                    "AICompanion: Asset pack is already registered."
            );
            return;
        }

        try (RawJsonReader reader = RawJsonReader.fromPath(
                manifestPath,
                RawJsonReader.READ_BUFFER.get()
        )) {
            PluginManifest manifest =
                    PluginManifest.CODEC.decodeJson(reader, new ExtraInfo());

            boolean registered = assetModule.registerPack(
                    PACK_ID,
                    packPath,
                    manifest,
                    AssetPack.PackSource.RUNTIME
            );

            plugin.getLogger().atInfo().log(
                    "AICompanion: Asset pack registration result: " + registered
            );

        } catch (IOException exception) {
            plugin.getLogger().atSevere().log(
                    "AICompanion: Could not register asset pack: " + exception
            );
        }
    }
}