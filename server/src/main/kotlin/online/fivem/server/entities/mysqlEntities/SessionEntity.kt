package online.fivem.server.entities.mysqlEntities

class SessionEntity(
	val user_id: Int,
	val steam: String,
	val license: String?,
	val ip: String,
	val left_reason: String?
)