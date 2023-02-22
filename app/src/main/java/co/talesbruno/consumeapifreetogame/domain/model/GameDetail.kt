package co.talesbruno.consumeapifreetogame.domain.model

data class GameDetail(
    val description: String,
    val developer: String,
    val freetogame_profile_url: String,
    val game_url: String,
    val genre: String,
    val id: Int,
   // val minimum_system_requirements: MinimumSystemRequirements,
    val platform: String,
    val publisher: String,
    val release_date: String,
   // val screenshots: List<Screenshot>,
    val short_description: String,
    val status: String,
    val thumbnail: String,
    val title: String
)
