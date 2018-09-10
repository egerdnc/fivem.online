package server

import server.structs.PlayerSrc
import shared.exports
import shared.r.MAX_PLAYERS
import shared.r.MODULE_FOLDER_NAME
import shared.struct.Command
import shared.struct.HttpRequestType
import shared.struct.Ped

object Server

fun Server.performHttpRequest(url: String, type: HttpRequestType = HttpRequestType.GET, data: String = "", headers: Any = object {}, callback: (Int, String, dynamic) -> Unit) {

	exports[MODULE_FOLDER_NAME].performHttpRequest(url, callback, type.name, data, headers)
}

/**
 * thisScriptCheck - can be destroyed if it belongs to the calling script.
 */
private external fun CreateVehicle(modelHash: String, x: Float, y: Float, z: Float, heading: Float, isNetwork: Boolean, thisScriptCheck: Boolean)

//fun Server.createVehicle(modelHash: String, x: Float, y: Float, z: Float, heading: Float, isNetwork: Boolean, thisScriptCheck: Boolean){
//	CreateVehicle(modelHash, x, y, z, heading, isNetwork, thisScriptCheck)
//}

/**
 * Ped: The ped to warp.
 * vehicle: The vehicle to warp the ped into.
 * Seat_Index: [-1 is driver seat, -2 first free passenger seat]
 * Moreinfo of Seat Index
 * DriverSeat = -1
 * Passenger = 0
 * Left Rear = 1
 * RightRear = 2
 */
private external fun SetPedIntoVehicle(ped: Float, vehicle: Float, seatIndex: Float)

/**
 * colorPrimary &amp; colorSecondary are the paint index for the vehicle.
 * For a list of valid paint indexes, view: pastebin.com/pwHci0xK
 * -------------------------------------------------------------------------
 * Use this to get the Float of color indices: pastebin.com/RQEeqTSM
 * Note: minimum color index is 0, maximum color index is (numColorIndices - 1)
 */
private external fun SetVehicleColours(vehicle: Float, colorPrimary: Float, colorSecondary: Float)

private external fun DeleteFunctionReference(referenceIdentity: String)

private external fun DropPlayer(playerSrc: String, reason: String)

fun Server.dropPlayer(playerSrc: String, reason: String) {
	DropPlayer(playerSrc, reason)
}

private external fun DuplicateFunctionReference(referenceIdentity: String): String

private external fun EnableEnhancedHostSupport(enabled: Boolean)

private external fun ExecuteCommand(commandString: String)

private external fun FlagServerAsPrivate(_private: Boolean)

private external fun GetConvar(varName: String, _default: String): String

fun Server.getConvar(varName: String, _default: String): String {
	return GetConvar(varName, _default)
}

private external fun GetConvarInt(varName: String, _default: Int): Int

fun Server.getConvar(varName: String, _default: Int): Int {
	return GetConvarInt(varName, _default)
}

/**
 * Returns the name of the currently executing resource.
 * @return The name of the resource.
 */
private external fun GetCurrentResourceName(): String

private external fun GetEntityCoords(entity: Float): Array<Float>

/**
 * Gets the current game timer in milliseconds.
 * @return The game time.
 */
private external fun GetGameTimer(): Float

/**
 * This native converts the passed String to a hash.
 */
private external fun GetHashKey(model: String): Float

private external fun GetHostId(): String

private external fun GetInstanceId(): Float

private external fun GetInvokingResource(): String

private external fun GetNumPlayerIdentifiers(playerSrc: String): Float

private external fun GetNumPlayerIndices(): Int

fun Server.getNumPlayersOnline(): Int {
	return GetNumPlayerIndices()
}

/**
 * Gets the amount of metadata values with the specified key existing in the specified resource's manifest.
 * See also: [Resource manifest](https://wiki.fivem.net/wiki/Resource_manifest)
 * @param resourceName The resource name.
 * @param metadataKey The key to look up in the resource manifest.
 */
private external fun GetNumResourceMetadata(resourceName: String, metadataKey: String): Float

private external fun GetNumResources(): Float

/**
 * @param index Int 1..MAX_PLAYERS
 */

private external fun GetPlayerEndpoint(playerSrc: Int): String?

fun Server.getPlayerEndpoint(playerSrc: PlayerSrc): String? {
	return if (playerSrc.value > 0) {
		GetPlayerEndpoint(playerSrc.value)
	} else {
		null
	}
}

fun Server.getPlayersIds(): IntArray {
	val playersList: MutableCollection<Int> = mutableListOf()

	for (i in 1..MAX_PLAYERS) {
		GetPlayerEndpoint(i)?.let {
			playersList.add(i)
		}
	}

	return playersList.toIntArray()
}

private external fun GetPlayerFromIndex(index: Int): Int?

fun Server.getPlayerFromIndex(index: Int): PlayerSrc? {
	return GetPlayerFromIndex(index)?.let {
		PlayerSrc(it)
	}
}

private external fun GetPlayerGuid(playerSrc: Int): Double?

fun Server.getPlayerGuid(playerSrc: PlayerSrc): Double? {
	return if (playerSrc.value > 0) {
		GetPlayerGuid(playerSrc.value)
	} else {
		null
	}
}

private external fun GetPlayerIdentifier(playerSrc: String, identifier: Float): String

private external fun GetPlayerLastMsg(playerSrc: Int): Int

fun Server.getPlayerLastMsg(playerSrc: PlayerSrc): Int? {
	return if (playerSrc.value > 0 && playerSrc.value != Int.MAX_VALUE) {
		GetPlayerLastMsg(playerSrc.value)
	} else {
		null
	}
}

private external fun GetPlayerName(playerSrc: Int): String?

fun Server.getPlayerName(playerSrc: PlayerSrc): String? {
	return if (playerSrc.value > 0) {
		GetPlayerName(playerSrc.value)
	} else {
		null
	}
}

private external fun GetPlayerPed(playerSrc: Int): Int

fun Server.getPlayerPed(playerSrc: PlayerSrc): Ped? {
	if (playerSrc.value > 0) {
		val ped = GetPlayerPed(playerSrc.value)

		if (ped > 0) {
			return Ped(
					ped
			)
		}
	}

	return null
}

private external fun GetPlayerPing(playerSrc: Int): Int

fun Server.getPlayerPing(playerSrc: PlayerSrc): Int {
	return if (playerSrc.value > 0) {
		GetPlayerPing(playerSrc.value)
	} else {
		0
	}
}

/**
 * Returns all commands that are registered in the command system.
 * The data returned adheres to the following layout:
 * ```
 * [
 * {
 * "name": "cmdlist"
 * },
 * {
 * "name": "command1"
 * }
 * ]
 * ```
 * @return An obj containing registered commands.
 */
private external fun GetRegisteredCommands(): Array<Command>

fun Server.getRegisteredCommands(): Array<Command> {
	return GetRegisteredCommands()
}

private external fun RegisterCommand(commandName: String, handler: () -> Unit, restricted: Boolean)

private external fun GetResourceByFindIndex(findIndex: Float): String

/**
 * Gets the metadata value at a specified key/index from a resource's manifest.
 * See also: [Resource manifest](https://wiki.fivem.net/wiki/Resource_manifest)
 * @param resourceName The resource name.
 * @param metadataKey The key in the resource manifest.
 * @param index The value index, in a range from [0..GET_NUM_RESOURCE_METDATA-1].
 */
private external fun GetResourceMetadata(resourceName: String, metadataKey: String, index: Float): String

/**
 * Returns the physical on-disk path of the specified resource.
 * @param resourceName The name of the resource.
 * @return The resource directory name, possibly without trailing slash.
 */
private external fun GetResourcePath(resourceName: String): String

/**
 * Returns the current state of the specified resource.
 * @param resourceName The name of the resource.
 * @return The resource state. One of `"missing", "started", "starting", "stopped", "stopping", "uninitialized" or "unknown"`.
 */
private external fun GetResourceState(resourceName: String): String

private external fun InvokeFunctionReference(referenceIdentity: String, argsSerialized: String, argsLength: Float, retvalLength: Float): String

private external fun IsAceAllowed(obj: String): Float

/**
 * Gets whether or not this is the CitizenFX server.
 * @return A  Boolean value.
 */
private external fun IsDuplicityVersion(): Float

private external fun IsPlayerAceAllowed(playerSrc: String, obj: String): Float

/**
 * Reads the contents of a text file in a specified resource.
 * If executed on the client, this file has to be included in `files` in the resource manifest.
 * Example: `local data = LoadResourceFile("devtools", "data.json")`
 * @param resourceName The resource name.
 * @param fileName The file in the resource.
 * @return The file contents
 */
private external fun LoadResourceFile(resourceName: String, fileName: String): String

fun Server.loadResourceFile(resourceName: String, fileName: String): String? {
	return LoadResourceFile(resourceName, fileName)
}

fun Server.loadFile(fileName: String): String? {
	return LoadResourceFile(MODULE_FOLDER_NAME, fileName)
}

private external fun PerformHttpRequestInternal(requestData: String, requestDataLength: Int): Double

/**
 * Registers a build task factory for resources.
 * The fun should return an obj (msgpack map) with the following fields:
 * ```
 * {
 * // returns whether the specific resource should be built
 * shouldBuild = func(resourceName: String): bool,
 *
 * // asynchronously start building the specific resource.
 * // call cb when completed
 * build = func(resourceName: String, cb: func(success: bool, status: String): void): void
 * }
 * ```
 * @param factoryId The identifier for the build task.
 * @param factoryFn The factory function.
 */
private external fun RegisterResourceBuildTaskFactory(factoryId: String, factoryFn: () -> Unit)

/**
 * Writes the specified data to a file in the specified resource.
 * Using a length of `-1` will automatically detect the length assuming the data is a C String.
 * @param resourceName The name of the resource.
 * @param fileName The name of the file.
 * @param data The data to write to the file.
 * @param dataLength The length of the written data.
 * @return A value indicating if the write succeeded.
 */
private external fun SaveResourceFile(resourceName: String, fileName: String, data: String, dataLength: Int): Int

fun Server.saveResourceFile(resourceName: String, fileName: String, data: String): Boolean {
	return SaveResourceFile(resourceName, fileName, data, data.length) == 1
}

fun Server.saveFile(fileName: String, data: String): Boolean {
	return SaveResourceFile(MODULE_FOLDER_NAME, fileName, data, data.length) == 1
}

private external fun SetConvar(varName: String, value: String)

/**
 * p7 is always 1 in the scripts. Set to 1, an area around the destination coords for the moved entity is cleared from other entities.
 * Often ends with 1, 0, 0, 1); in the scripts. It works.
 * Axis - Invert Axis Flags
 */
private external fun SetEntityCoords(entity: Float, xPos: Float, yPos: Float, zPos: Float, xAxis: Boolean, yAxis: Boolean, zAxis: Boolean, clearArea: Boolean)

private external fun SetGameType(gametypeName: String)

private external fun SetHttpHandler(handler: () -> Unit)

private external fun SetMapName(mapName: String)

/**
 * Call SET_PLAYER_WANTED_LEVEL_NOW for immediate effect
 * wantedLevel is an integer value representing 0 to 5 stars even though the game supports the 6th wanted level but no police will appear since no definitions are present for it in the game files
 * disableNoMission-  Disables When Off Mission- appears to always be false
 */
private external fun SetPlayerWantedLevel(player: Float, wantedLevel: Int, disableNoMission: Boolean)

private external fun StartResource(resourceName: String): Float

private external fun StopResource(resourceName: String): Float

private external fun TempBanPlayer(playerSrc: String, reason: String)

/**
 * The backing fun for TriggerClientEvent.
 */
private external fun TriggerClientEventInternal(eventName: String, eventTarget: String, eventPayload: String, payloadLength: Float)

/**
 * The backing fun for TriggerEvent.
 */
private external fun TriggerEventInternal(eventName: String, eventPayload: String, payloadLength: Float)

private external fun GetPasswordHash(password: String): String

fun Server.getPasswordHash(password: String): String {
	return GetPasswordHash(password)
}

private external fun VerifyPasswordHash(password: String, hash: String): Int

fun Server.verifyPasswordHash(password: String, hash: String): Boolean {
	return VerifyPasswordHash(password, hash) == 1
}

/**
 * Cancels the currently executing event. See https://wiki.fivem.net/wiki/CancelEvent
 */

private external fun CancelEvent()

fun Server.cancelEvent() {
	CancelEvent()
}

/**
 * Returns whether or not the currently executing event was canceled. See https://wiki.fivem.net/wiki/WasEventCanceled
 * @return A  Boolean.
 */
private external fun WasEventCanceled(): Boolean

