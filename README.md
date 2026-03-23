![](assets/origami-banner.png)

**IMPORTANT:** Do not use this in production. This is an experimental project and may contain bugs, security vulnerabilities, and other issues. Use at your own risk.

**Goals:**
- Learn more about Minecraft's internals
- Provide a platform experiment with new features

**Planned features:**
- API layer
- Plugin system
- Event bus
- Command API

## Support

If you have questions, suggestions, or want to contribute, please join our [Discord server](https://discord.gg/Vfe83KK7cm).

## Build from source

1. Clone the repository: `git clone https://github.com/OrigamiMC/Origami.git`
2. Run `./gradlew setupStratap` to set up the development environment
3. Run `./gradlew applyFilePatches` to apply necessary patches
4. Run `./gradlew origami-server:shadowJar` to build the project
5. The built server JAR will be located at `origami-server/build/libs/origami-server-<version>.jar`
