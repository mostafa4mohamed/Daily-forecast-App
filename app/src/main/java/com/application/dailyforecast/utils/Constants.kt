package com.application.dailyforecast.utils

object Constants {

    const val BASE_URL = "https://tasks.develocity.app/api/"

    const val ContractAddress: String = "contractAddress"

    const val IMAGE: String = "image"
    const val NAME: String = "name"
    const val Shortcut: String = "shortcut"
    const val DATA = "data"
    const val SECTION = "section"
    const val BRANCH = "branch"
    const val ADMIN = "admin"
    const val TASK_ID = "task_id"
    const val OTHER_ID = "other_id"
    const val GROUP_ID = "group_id"
    const val OTHER_NAME = "other_name"
    const val USER = "user"
    const val USERS = "users"
    const val PROFILE = "profile"
    const val SEARCH_KEYWORD = "search_keyword"
    const val TASK = "task"
    const val CHAT = "chat"
    const val TYPE = "type"
    const val CHAT_RECEIVER = 1
    const val CHAT_SENDER = 2
    const val MESSAGE_ROOM = "message_room"
    const val PREV_STARTED = "prevStarted"
    const val RECEIVER_TYPE = "receiver_type"
    const val IS_ADDED_TASK = "is_added_task"
    const val Requirement = "requirement"
    const val USER_REQUIREMENT = "user_requirement"
    const val IS_UPDATE_REQUIREMENT = "is_update_requirement"
    const val NEWS = "news"
    const val IS_UPDATE_NEWS = "is_update_news"
    const val IS_UPDATE_COMPLAINT = "is_update_complaint"
    const val COMPLAINT_ID = "complaint_id"
    const val COMPLAINT_TITLE = "complaint_title"
    const val COMPLAINT_MESSAGE = "complaint_message"
    const val COMPLAINT_TYPE = "complaint_type"


    object ApisKeys {
        const val BEARER = "Bearer"
    }

    object ShardKeys {

        const val SHARD_NAME = "Develoctiy Tasks"
        const val USER_TYPE_NAME = "User Type"
        const val DATA = "data"
        const val TOKEN = "token"
        const val DARK_MODE = "mode"
        const val LANGUAGE = "lang"
        const val SPLASH = "splash"
        const val TYPE = "type"

    }

    object Codes {
        const val EXCEPTIONS_CODE = 3421
        const val API_KEY_CODE = 5020
        const val AUTH_CODE = 5000
        const val UNKNOWN_CODE = 560
        const val SUCCESSES_CODE = 200
    }

    enum class ComplaintsStates(val value: String) {
        Responded("responed"), Rejected("rejected"),Waiting("waiting")

    }

    enum class MessagesStates(val value: String) {
        All("all"), UnreadChats("unread"),Archived("archived")
    }
}