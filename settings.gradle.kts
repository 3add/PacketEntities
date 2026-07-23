rootProject.name = "PacketEntities"

include("platforms")
include("platforms:paper")
include("platforms:velocity")

include("code-generators")

includeBuild("build-src")
