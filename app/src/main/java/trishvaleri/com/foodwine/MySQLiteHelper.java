//refer to MainActivity for project details.
//Contributors specific for this page: developer.android.com, stackoverflow.com,
// techotopia.com, sqlite.org

package trishvaleri.com.foodwine;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * MySQLiteHelper.java used to set up database.
 * @author Trish Valeri
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "foodpairing.db"; // name of the database
    private static final int DATABASE_VERSION = 8;              // version of the database

    //tables
    private static final String TABLE_FOOD = "food";
    private static final String TABLE_WINE_CAT = "wine_cat";
    private static final String TABLE_FW_COMP = "fw_comp";
    private static final String TABLE_WINE = "wine";
    private static final String TABLE_CUSTOM = "custom";

    //TABLE_FOOD columns
    static final String FOOD_ID = "_id";
    private static final String FOOD_NAME = "food_name";

    //TABLE_WINE_CAT columns
    private static final String WINE_CAT_ID = "wine_cat_id";
    private static final String WINE_CAT_NAME = "wine_cat_name";

    //TABLE_FW_COMP columns
    private static final String FW_COMP_PK1 = "fw_comp_pk1";
    private static final String FW_COMP_PK2 = "fw_comp_pk2";

    //TABLE_WINE columns
    private static final String WINE_ID = "wine_id";
    private static final String WINE_NAME = "wine_name";
    private static final String WINE_WINE_CAT_ID = "wine_list_id";

    //TABLE_CUSTOM columns (never created due to time constraint.)
    private static final String CUSTOM_ID = "custom_id";
    private static final String CUSTOM_FOOD = "custom_food";
    private static final String CUSTOM_WINE = "custom_wine";

    //TABLE_FOOD enter row data
    private static String foodRows = "INSERT INTO " + TABLE_FOOD + "(" + FOOD_NAME + ")"
            + " VALUES('Vegetables'), ('Roasted Vegetables'), ('Soft Cheese'), ('Hard Cheese'),"
            + " ('Starches'), ('Fish'), ('Rich Fish'), ('White Meat'), ('Red Meat'),"
            + " ('Cured Meat'), ('Sweets');";

//    //TABLE_WINE_CAT enter row data
//    private static String wineCatRows = "INSERT INTO " + TABLE_WINE_CAT
//            + "(" + WINE_CAT_NAME + ", " + WINE_CAT_FOOD_ID + ")"
//            + " VALUES('Dry Wine', (SELECT " + FOOD_ID + " from " + TABLE_FOOD
//            + " WHERE " + FOOD_NAME + "='Vegetable'));";

    //TABLE_FW_COMP enter row data
    private static String fwRowAdd = "INSERT INTO " + TABLE_FW_COMP
            + "(" + FW_COMP_PK1 + ", " + FW_COMP_PK2 + ")"
            + " VALUES((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Vegetables'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Dry White'))," //end record 1
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Vegetables'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Sparkling'))," //end record 2 (all vegetable entries)
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Roasted Vegetables'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Dry White'))," //end record 3
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Roasted Vegetables'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Light Red'))," //end record 4
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Roasted Vegetables'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Medium Red'))," //end record 5 (all roasted veggie)
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Soft Cheese'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Sweet White'))," //end record 6
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Soft Cheese'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Rich White'))," //end record 7
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Soft Cheese'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Sparkling'))," //end record 8
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Soft Cheese'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Dessert'))," //end record 9 (all soft cheese done)
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Hard Cheese'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Sweet White'))," //end record 10
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Hard Cheese'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Sparkling'))," //end record 11
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Hard Cheese'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Medium Red'))," //end record 12
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Hard Cheese'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Bold Red'))," //end record 13 (all hard cheese done)
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Starches'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Dry White'))," //end record 14
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Starches'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Rich White'))," //end record 15
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Starches'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Sparkling'))," //end record 16
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Starches'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Light Red'))," //end record 17
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Starches'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Medium Red'))," //end record 18
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Starches'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Bold Red'))," //end record 19
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Starches'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Dessert'))," //end record 20 (all starches done)
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Fish'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Dry White'))," //end record 21
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Fish'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Rich White'))," //end record 22
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Fish'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Sparkling'))," //end record 23 (all fish done)
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Rich Fish'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Light Red'))," //end record 24
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Rich Fish'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Rich White'))," //end record 25 (all rich fish done)
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='White Meat'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Rich White'))," //end record 26
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='White Meat'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Light Red'))," //end record 27
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='White Meat'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Medium Red'))," //end record 28 (all white meat done)
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Red Meat'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Medium Red'))," //end record 29
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Red Meat'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Bold Red'))," //end record 30 (all red meat done)
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Cured Meat'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Sweet White'))," //end record 31
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Cured Meat'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Light Red'))," //end record 32
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Cured Meat'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Medium Red'))," //end record 33
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Cured Meat'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Bold Red'))," //end record 34
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Cured Meat'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Dessert'))," //end record 35 (all cured meat done)
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Sweets'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Sweet White'))," //end record 36
            + " ((SELECT " + FOOD_ID + " from " + TABLE_FOOD
            + " WHERE " + FOOD_NAME + "='Sweets'),"
            + " (SELECT " + WINE_CAT_ID + " from " + TABLE_WINE_CAT
            + " WHERE " + WINE_CAT_NAME + "='Dessert'));"; //end record 37 (all sweets done)

    //TABLE_WINE_CAT enter row data
    private static String wineCatRows = "INSERT INTO " + TABLE_WINE_CAT + "(" + WINE_CAT_NAME + ")"
            + " VALUES('Dry White'), ('Sweet White'), ('Rich White'), ('Sparkling'),"
            + " ('Light Red'), ('Medium Red'), ('Bold Red'), ('Dessert');";

    //TABLE_FOOD enter row data
    private static String wineRows = "INSERT INTO " + TABLE_WINE + "(" + WINE_NAME + ")"
            + " VALUES('White Table Wine'), ('Roasted Vegetables'), ('Soft Cheese'), ('Hard Cheese'),"
            + " ('Starches'), ('Fish'), ('Rich Fish'), ('White Meat'), ('Red Meat'),"
            + " ('Cured Meat'), ('Sweets');";

    // TABLE_FOOD creation sql statement
    private static final String FOOD_CREATE = "create table "
            + TABLE_FOOD + "("
            + FOOD_ID + " integer primary key autoincrement, "
            + FOOD_NAME + " text not null);";

    // TABLE_CUSTOM creation sql statement
    private static final String CUSTOM_CREATE = "create table "
            + TABLE_CUSTOM + "("
            + CUSTOM_ID + " integer primary key autoincrement, "
            + CUSTOM_FOOD + " text not null, "
            + CUSTOM_WINE + " text not null);";

    // TABLE_WINE_CAT creation sql statement
    private static final String WINE_CAT_CREATE = "create table "
            + TABLE_WINE_CAT + "("
            + WINE_CAT_ID + " integer primary key autoincrement, "
            + WINE_CAT_NAME + " text not null);";

    // TABLE_FW_COMP creation sql statement
    private static final String FW_COMP_CREATE = "create table "
            + TABLE_FW_COMP + "("
            + FW_COMP_PK1 + " integer not null, "
            + FW_COMP_PK2 + " integer not null, "
            + "primary key (" + FW_COMP_PK1 + ", " + FW_COMP_PK2 + "), "
            + "foreign key ( " + FW_COMP_PK1 + ") references " + TABLE_FOOD + "(" + FOOD_ID + "), "
            + "foreign key ( " + FW_COMP_PK2 + ") references " + TABLE_WINE_CAT + "(" + WINE_CAT_ID + "));";

    // TABLE_WINE creation sql statement
    private static final String WINE_CREATE = "create table "
            + TABLE_WINE + "("
            + WINE_ID + " integer primary key autoincrement, "
            + WINE_NAME + " text not null, "
            + WINE_WINE_CAT_ID + " integer, "
            + "foreign key ( " + WINE_WINE_CAT_ID + ") references " + TABLE_WINE_CAT + "(" + WINE_CAT_ID + "));";


//    //Query to get wine categories from selected food.
//    protected static String queryWineFromFood = "select " + WINE_CAT_NAME + " from " + TABLE_WINE_CAT
//            + " join " + TABLE_FW_COMP + " on " + WINE_CAT_ID + " = " + FW_COMP_PK2
//            + " join " + TABLE_FOOD + " on " + FW_COMP_PK1 + " = " + FOOD_ID
//            + " where " + FOOD_ID + " = " ;

//    public static void queryWineFromFood(SQLiteDatabase db, int value) {
//        db.execSQL(queryWineFromFood + this.value);
//    }
//    public static String queryWineFromFood(SQLiteOpenHelper db) {
//        return queryWineFromFood;
//    }

    /**
     * MySQLiteHelper constructor
     * @param context Context
     */
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * onCreate, the database sql creates tables and rows
     * @param db SQLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(FOOD_CREATE);
        db.execSQL(WINE_CAT_CREATE);
        db.execSQL(FW_COMP_CREATE);
        db.execSQL(WINE_CREATE);
        db.execSQL(CUSTOM_CREATE);
        db.execSQL(foodRows);
        db.execSQL(wineCatRows);
        db.execSQL(fwRowAdd);
    }

    /**
     * onUpgrade, if the database version is changed the tables will be dropped, also executes
     * onCreate when done with deletion.
     * @param db SQLiteDatabase
     * @param oldVersion int
     * @param newVersion int
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WINE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FW_COMP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WINE_CAT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD);
        onCreate(db);
    }

}
