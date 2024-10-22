data class BarbeiroEntity(
    var id:  Long,
    val nome: String,
    val email: String,
    val telefone: String,
    val descricao: String,
    val foto: String,
    val semana: SemanaEntity
)