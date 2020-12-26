package by.it.academy.contentproviderexample

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.net.Uri
import by.it.academy.contentproviderexample.database.DBUserInfo
import by.it.academy.contentproviderexample.database.UserInfo

class DataContentProvider : ContentProvider() {

    private var database: DBUserInfo? = null

    override fun onCreate(): Boolean {
        context?.run {
            database = DBUserInfo.getDatabase(this)
        }
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ) = when (uriMatcher.match(uri)) {
        URI_CODE_CONTACT -> database?.getUserInfoDao()?.getAllInfo()
        URI_CODE_CONTACT_BASE -> selectionArgs?.run {
            database?.getUserInfoDao()?.getInfo(selectionArgs[0].toLong())
        }
        else -> null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val matchResult = uriMatcher.match(uri)
        if (matchResult == URI_CODE_CONTACT && values != null) {
            val userInfo = UserInfo(
                name = values.getAsString("NAME") ?: "",
                age = values.getAsInteger("AGE") ?: 0,
                address = values.getAsString("ADDRESS") ?: ""
            )

            val newId = database?.getUserInfoDao()?.insert(userInfo) ?: -1
            return Uri.withAppendedPath(uri, newId.toString())
        }
        return null
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?, // age = ?
        selectionArgs: Array<out String>?
    ): Int {
        val matchResult = uriMatcher.match(uri)
        if (matchResult == URI_CODE_CONTACT && values != null) {
            val userInfo = UserInfo(
                name = values.getAsString("NAME") ?: "",
                age = values.getAsInteger("AGE") ?: 0,
                address = values.getAsString("ADDRESS") ?: ""
            )

            return database?.getUserInfoDao()?.update(userInfo) ?: -1
        }
        return 0
    }

    override fun delete(
        uri: Uri,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }

    override fun getType(uri: Uri) =
        when (uriMatcher.match(uri)) {
            URI_CODE_CONTACT -> "object/*"
            URI_CODE_CONTACT_BASE -> "object/*"
            else -> null
        }

    // file://application/database/contact
    // content://authority/path
    // https://github.com/DenisAndroidCource

    companion object {

        private const val AUTHORITY = "by.it.academy.contentproviderexample"
        private const val URI_CODE_CONTACT = 1
        private const val URI_CODE_CONTACT_BASE = 2

        private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
            // content://by.it.academy.contentproviderexample/database/contact
            addURI(AUTHORITY, "database/contact", URI_CODE_CONTACT)
            addURI(AUTHORITY, "database/contact/base_info", URI_CODE_CONTACT_BASE)
        }
    }
}