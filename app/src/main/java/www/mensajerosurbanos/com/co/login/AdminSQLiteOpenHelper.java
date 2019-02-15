package www.mensajerosurbanos.com.co.login;


import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    private static final String NOMBRE_BD ="dveloper.bd";
    private static final int VERSION_BD = 1;
    private static final String TABLA_USUARIO = "CREATE TABLE USUARIOS(EMAIL TEXT PRIMARY KEY, PASSWORD TEXT)";

    public AdminSQLiteOpenHelper(Context context){
        super(context, NOMBRE_BD,null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USER" + TABLA_USUARIO);
       sqLiteDatabase.execSQL(TABLA_USUARIO);
    }

    public void agregar(String email, String password){
        SQLiteDatabase BD = this.getWritableDatabase();
        if (BD!=null){
            BD.execSQL("INSERT INTO USUARIOS VALUES ('"+email+"','"+password+"')");
            BD.close();
        }
    }

    public Cursor login(String email, String password) throws SQLException {
        SQLiteDatabase BD = this.getReadableDatabase();
        Cursor cursor = null;
        cursor= this.getReadableDatabase().query("USUARIOS",new String[]{"EMAIL,PASSWORD"}, "email'"+email+"'"+ "and password'"+password+"'",null,null,null,null);
        return cursor;
    }
}