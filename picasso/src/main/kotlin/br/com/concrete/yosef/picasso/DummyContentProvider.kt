package br.com.concrete.yosef.picasso

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.net.Uri


class DummyContentProvider : ContentProvider() {
    companion object {
        lateinit var appContext: Context
    }

    override fun insert(p0: Uri?, p1: ContentValues?): Uri? {
        return null
    }

    override fun query(p0: Uri?, p1: Array<out String>?, p2: String?, p3: Array<out String>?, p4: String?): Cursor? {
        return null
    }

    override fun onCreate(): Boolean {
        appContext = context.applicationContext
        return true
    }

    override fun update(p0: Uri?, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        return 0
    }

    override fun delete(p0: Uri?, p1: String?, p2: Array<out String>?): Int {
        return 0
    }

    override fun getType(p0: Uri?): String? {
        return null
    }

}
