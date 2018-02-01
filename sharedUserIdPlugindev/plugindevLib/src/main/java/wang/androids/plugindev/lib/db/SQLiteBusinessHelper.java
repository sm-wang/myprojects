package wang.androids.plugindev.lib.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.concurrent.atomic.AtomicInteger;


public class SQLiteBusinessHelper extends SQLiteOpenHelper {
    private static final String DB_NAME ="BusinessHelper.db";
    public static final int BUSINESS_DB_VERSION = 13;
    private static SQLiteBusinessHelper helper = null;

    private static AtomicInteger usageCounter = new AtomicInteger(0);

    public SQLiteBusinessHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public SQLiteBusinessHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
