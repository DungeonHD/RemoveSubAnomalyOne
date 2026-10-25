# Remove Sub Anomaly 1

Fan mod for [The Broken Script](https://modrinth.com/mod/the-broken-script) (NeoForge 1.21.1). Sub Anomaly 1 no longer shows up in the game.

Requires: [The Broken Script](https://modrinth.com/mod/the-broken-script), Java 21

## How it works
When Sub Anomaly 1 spawns or is loaded from a chunk, it is never allowed into the world, so existing worlds are cleaned up too. As a safety net, the mod also sweeps every 5 seconds in case one slips through.

It is detected via `thebrokenscript:sub_anomaly_1` and the class `SubAnomaly1Entity`.

## Building
Run `gradlew build`, the jar ends up in `build/libs/`. To test with `runClient`, put the jar of [The Broken Script](https://modrinth.com/mod/the-broken-script) and its dependencies into `run/mods`.