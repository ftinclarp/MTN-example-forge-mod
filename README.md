# MTN-example-forge-mod

Minimal "Hello World" Forge 1.7.10 mod: a single `@Mod` entry point
(`com.mtn.example.ExampleMod`) with empty preInit/init/postInit,
an empty CommonProxy/ClientProxy pair, and a minimal `mcmod.info`.

This repository is the reference **input** for
[Mod-Transmuder-Next](https://github.com/dev/Mod-Transmuder-Next) —
it is not maintained as an independent mod.

## Build

Standard ForgeGradle 1.2 layout (Groovy `build.gradle`, `forge` plugin):

- `./gradlew build`

Note: ForgeGradle 1.2 requires Gradle 2.x and a Java 8 JDK. The checked-in
wrapper is a modern Gradle (currently 9.3.1) and is *not* compatible with
ForgeGradle 1.2; it is kept only so the wrapper files exist in the repo.
Building this mod is intentionally not set up — this project is a reference
input for the porting tool, not a maintained build.

## License

MIT. See [LICENSE](LICENSE).

Based on GTNewHorizons/ExampleMod1.7.10 (permissive OSS template).
