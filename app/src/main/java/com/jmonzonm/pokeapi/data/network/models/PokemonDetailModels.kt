package com.jmonzonm.pokeapi.data.network.models

import com.google.gson.annotations.SerializedName

data class PokemonDetailModels(
    @SerializedName("abilities")
    val abilities: List<Ability>? = listOf(),
    @SerializedName("base_experience")
    val baseExperience: Int? = 0,
    @SerializedName("forms")
    val forms: List<Form>? = listOf(),
    @SerializedName("game_indices")
    val gameIndices: List<GameIndice>? = listOf(),
    @SerializedName("height")
    val height: Int? = 0,
    @SerializedName("held_items")
    val heldItems: List<Any>? = listOf(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("is_default")
    val isDefault: Boolean? = false,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String? = "",
    @SerializedName("moves")
    val moves: List<Move>? = listOf(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("order")
    val order: Int? = 0,
    @SerializedName("past_types")
    val pastTypes: List<Any>? = listOf(),
    @SerializedName("species")
    val species: Species? = Species(),
    @SerializedName("sprites")
    val sprites: Sprites? = Sprites(),
    @SerializedName("stats")
    val stats: List<Stat>? = listOf(),
    @SerializedName("types")
    val types: List<Type>? = listOf(),
    @SerializedName("weight")
    val weight: Int? = 0
)

data class Yellow(
    @SerializedName("back_default")
    val backDefault: String? = null,
    @SerializedName("back_gray")
    val backGray: String? = null,
    @SerializedName("back_transparent")
    val backTransparent: String? = null,
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_gray")
    val frontGray: String? = null,
    @SerializedName("front_transparent")
    val frontTransparent: String? = null
)

data class XY(
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_female")
    val frontFemale: Any? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    val frontShinyFemale: Any? = null
)

data class Versions(
    @SerializedName("generation-i")
    val generationI: GenerationI? = GenerationI(),
    @SerializedName("generation-ii")
    val generationIi: GenerationIi? = GenerationIi(),
    @SerializedName("generation-iii")
    val generationIii: GenerationIii? = GenerationIii(),
    @SerializedName("generation-iv")
    val generationIv: GenerationIv? = GenerationIv(),
    @SerializedName("generation-v")
    val generationV: GenerationV? = GenerationV(),
    @SerializedName("generation-vi")
    val generationVi: GenerationVi? = GenerationVi(),
    @SerializedName("generation-vii")
    val generationVii: GenerationVii? = GenerationVii(),
    @SerializedName("generation-viii")
    val generationViii: GenerationViii? = GenerationViii()
)

data class VersionGroupDetail(
    @SerializedName("level_learned_at")
    val levelLearnedAt: Int? = null,
    @SerializedName("move_learn_method")
    val moveLearnMethod: MoveLearnMethod? = null,
    @SerializedName("version_group")
    val versionGroup: VersionGroup? = null
)

data class VersionGroup(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)

data class Version(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)

data class UltraSunUltraMoon(
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_female")
    val frontFemale: Any? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    val frontShinyFemale: Any? = null
)

data class TypeX(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)

data class Type(
    @SerializedName("slot")
    val slot: Int? = 0,
    @SerializedName("type")
    val type: TypeX? = TypeX()
)

data class StatX(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)

data class Stat(
    @SerializedName("base_stat")
    val baseStat: Int? = 0,
    @SerializedName("effort")
    val effort: Int? = 0,
    @SerializedName("stat")
    val stat: StatX? = StatX()
)

data class Sprites(
    @SerializedName("back_default")
    val backDefault: String? = "",
    @SerializedName("back_female")
    val backFemale: Any? = Any(),
    @SerializedName("back_shiny")
    val backShiny: String? = "",
    @SerializedName("back_shiny_female")
    val backShinyFemale: Any? = Any(),
    @SerializedName("front_default")
    val frontDefault: String? = "",
    @SerializedName("front_female")
    val frontFemale: Any? = Any(),
    @SerializedName("front_shiny")
    val frontShiny: String? = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: Any? = Any(),
    @SerializedName("other")
    val other: Other? = Other(),
    @SerializedName("versions")
    val versions: Versions? = Versions()
)

data class Species(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)

data class Silver(
    @SerializedName("back_default")
    val backDefault: String? = null,
    @SerializedName("back_shiny")
    val backShiny: String? = null,
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null,
    @SerializedName("front_transparent")
    val frontTransparent: String? = null
)

data class RubySapphire(
    @SerializedName("back_default")
    val backDefault: String? = null,
    @SerializedName("back_shiny")
    val backShiny: String? = null,
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null
)

data class RedBlue(
    @SerializedName("back_default")
    val backDefault: String? = null,
    @SerializedName("back_gray")
    val backGray: String? = null,
    @SerializedName("back_transparent")
    val backTransparent: String? = null,
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_gray")
    val frontGray: String? = null,
    @SerializedName("front_transparent")
    val frontTransparent: String? = null
)

data class Icons(
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_female")
    val frontFemale: Any? = null
)

data class Home(
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_female")
    val frontFemale: Any? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    val frontShinyFemale: Any? = null
)

data class Gold(
    @SerializedName("back_default")
    val backDefault: String? = null,
    @SerializedName("back_shiny")
    val backShiny: String? = null,
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null,
    @SerializedName("front_transparent")
    val frontTransparent: String? = null
)

data class GenerationViii(
    @SerializedName("icons")
    val icons: Icons? = Icons()
)

data class GenerationVii(
    @SerializedName("icons")
    val icons: Icons? = null,
    @SerializedName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoon? = null
)


data class GenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    val omegarubyAlphasapphire: OmegarubyAlphasapphire? = null,
    @SerializedName("x-y")
    val xY: XY? = null
)

data class GenerationV(
    @SerializedName("black-white")
    val blackWhite: BlackWhite? = null
)

data class GenerationIii(
    @SerializedName("emerald")
    val emerald: Emerald? = null,
    @SerializedName("firered-leafgreen")
    val fireredLeafgreen: FireredLeafgreen? = null,
    @SerializedName("ruby-sapphire")
    val rubySapphire: RubySapphire? = null
)

data class GenerationIv(
    @SerializedName("diamond-pearl")
    val diamondPearl: DiamondPearl? = null,
    @SerializedName("heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilver? = null,
    @SerializedName("platinum")
    val platinum: Platinum? = null
)

data class GenerationIi(
    @SerializedName("crystal")
    val crystal: Crystal? = null,
    @SerializedName("gold")
    val gold: Gold? = null,
    @SerializedName("silver")
    val silver: Silver? = null
)

data class GenerationI(
    @SerializedName("red-blue")
    val redBlue: RedBlue? = null,
    @SerializedName("yellow")
    val yellow: Yellow? = null
)

data class GameIndice(
    @SerializedName("game_index")
    val gameIndex: Int? = null,
    @SerializedName("version")
    val version: Version? = null
)

data class Form(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)

data class Emerald(
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null
)

data class DiamondPearl(
    @SerializedName("back_default")
    val backDefault: String? = null,
    @SerializedName("back_female")
    val backFemale: Any? = null,
    @SerializedName("back_shiny")
    val backShiny: String? = null,
    @SerializedName("back_shiny_female")
    val backShinyFemale: Any? = null,
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_female")
    val frontFemale: Any? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    val frontShinyFemale: Any? = null
)

data class Crystal(
    @SerializedName("back_default")
    val backDefault: String? = null,
    @SerializedName("back_shiny")
    val backShiny: String? = null,
    @SerializedName("back_shiny_transparent")
    val backShinyTransparent: String? = null,
    @SerializedName("back_transparent")
    val backTransparent: String? = null,
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null,
    @SerializedName("front_shiny_transparent")
    val frontShinyTransparent: String? = null,
    @SerializedName("front_transparent")
    val frontTransparent: String? = null
)

data class BlackWhite(
    @SerializedName("animated")
    val animated: Animated? = null,
    @SerializedName("back_default")
    val backDefault: String? = null,
    @SerializedName("back_female")
    val backFemale: Any? = null,
    @SerializedName("back_shiny")
    val backShiny: String? = null,
    @SerializedName("back_shiny_female")
    val backShinyFemale: Any? = null,
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_female")
    val frontFemale: Any? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    val frontShinyFemale: Any? = null
)

data class Animated(
    @SerializedName("back_default")
    val backDefault: String? = null,
    @SerializedName("back_female")
    val backFemale: Any? = null,
    @SerializedName("back_shiny")
    val backShiny: String? = null,
    @SerializedName("back_shiny_female")
    val backShinyFemale: Any? = null,
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_female")
    val frontFemale: Any? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    val frontShinyFemale: Any? = null
)

data class AbilityX(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)

data class Ability(
    @SerializedName("ability")
    val ability: AbilityX? = AbilityX(),
    @SerializedName("is_hidden")
    val isHidden: Boolean? = false,
    @SerializedName("slot")
    val slot: Int? = 0
)

data class DreamWorld(
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_female")
    val frontFemale: Any? = null
)

data class FireredLeafgreen(
    @SerializedName("back_default")
    val backDefault: String? = null,
    @SerializedName("back_shiny")
    val backShiny: String? = null,
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null
)

data class HeartgoldSoulsilver(
    @SerializedName("back_default")
    val backDefault: String? = null,
    @SerializedName("back_female")
    val backFemale: Any? = null,
    @SerializedName("back_shiny")
    val backShiny: String? = null,
    @SerializedName("back_shiny_female")
    val backShinyFemale: Any? = null,
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_female")
    val frontFemale: Any? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    val frontShinyFemale: Any? = null
)

data class Move(
    @SerializedName("move")
    val move: MoveX? = MoveX(),
    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>? = listOf()
)

data class MoveLearnMethod(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)


data class MoveX(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)

data class OfficialArtwork(
    @SerializedName("front_default")
    val frontDefault: String? = null
)

data class OmegarubyAlphasapphire(
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_female")
    val frontFemale: Any? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    val frontShinyFemale: Any? = null
)

data class Other(
    @SerializedName("dream_world")
    val dreamWorld: DreamWorld? = null,
    @SerializedName("home")
    val home: Home? = null,
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork? = null
)

data class Platinum(
    @SerializedName("back_default")
    val backDefault: String? = null,
    @SerializedName("back_female")
    val backFemale: Any? = null,
    @SerializedName("back_shiny")
    val backShiny: String? = null,
    @SerializedName("back_shiny_female")
    val backShinyFemale: Any? = null,
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_female")
    val frontFemale: Any? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    val frontShinyFemale: Any? = null
)