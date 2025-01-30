package org.com.testmatemultiplatform.group.post.model

import kotlin.random.Random
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid


data class GroupPostResponse(
    val id: String,
    var title: String,
    val type: String,
    var content: String,
    val createdAt: String,
    val updatedAt: String,
    val createdBy: String,
    val status: String,
    val answer: String?,
    val groupId: Int,
    val metadata: List<Metadata>
)

data class Metadata(
    val id: Int,
    val option: String,
    val optionText: String,
    var attemptedBy: Int,
    val isChoosed: Boolean
)

fun getPost(): ArrayList<GroupPostResponse> {
    return ArrayList(List(2000) { generateRandomPoll() })
}

@OptIn(ExperimentalUuidApi::class)
fun generateRandomPoll(): GroupPostResponse {
    val uuid = Uuid.random().toString()
    val randomGroupId = Random.nextInt(1, 100)
    val randomTitle = "Poll Title $uuid"
    val randomContent = "This is content for poll $uuid"
    val randomCreatedBy = Random.nextInt(1, 10).toString()
    val randomStatus = listOf("ACTIVE", "CLOSED", "UNKNOWN").random()
    val randomMetadata = generateRandomMetadataList(Random.nextInt(1, 5))
    val pollType = listOf("TEXT", "POLL", "IMAGE").random()
    return GroupPostResponse(
        id = uuid,
        title = randomTitle,
        type = pollType,
        content = randomContent,
        createdAt = generateRandomTimestamp(),
        updatedAt = generateRandomTimestamp(),
        createdBy = randomCreatedBy,
        status = randomStatus,
        answer = if (Random.nextBoolean()) "Answer ${Random.nextInt(1, 10)}" else null,
        groupId = randomGroupId,
        metadata = randomMetadata
    )
}

fun generateRandomMetadataList(size: Int): List<Metadata> {
    return List(size) {
        val randomId = Random.nextInt(1, 1000)
        Metadata(
            id = randomId,
            option = ('A' + it).toString(), // A, B, C, ...
            optionText = "Option ${(it + 1)}",
            attemptedBy = Random.nextInt(1, 100),
            isChoosed = Random.nextBoolean()
        )
    }
}

fun generateRandomTimestamp(): String {
    val year = Random.nextInt(2020, 2025)
    val month = Random.nextInt(1, 13).toString().padStart(2, '0')
    val day = Random.nextInt(1, 29).toString().padStart(2, '0') // Simplified, assumes 28 days max
    val hour = Random.nextInt(0, 24).toString().padStart(2, '0')
    val minute = Random.nextInt(0, 60).toString().padStart(2, '0')
    val second = Random.nextInt(0, 60).toString().padStart(2, '0')
    return "$year-$month-$day$hour:$minute:$second"
}
