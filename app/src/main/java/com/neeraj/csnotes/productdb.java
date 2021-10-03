package com.neeraj.csnotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class productdb extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;//Memory lording at class lording time therefore static variable.(DEFINE THE DATABASE VERSION)
    private static final String DATABASE_NAME="product_db";//(DEFINE DATABASE NAME)
    private static final String TABLE="products";//(DEFINE TABLE NAME)

    //DECLARE CLOUMN NAMES
    private static final String PRODUCT_ID="pid";//(DEFINE ID)
    private static final String PRODUCT_NAME="pname";//(DEFINE )
    private static final String DATE="pdate";
    private static final String PRICE="price";

    public productdb(Context context) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TABLE+"("+PRODUCT_ID+" NUMBER,"+PRODUCT_NAME+" TEXT, "+DATE+" NUMERIC,"+PRICE+" REAL);";//DECLARE QUERY TO STRING VARIABLE.
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
    public long insertRecord(product record)//DEFINE A METHOD WITH LONG RETURN TYPE AND PASSING PARAMETER record
    {
        SQLiteDatabase db=getWritableDatabase();//TO WRITE DATA INTO DATABASE
        ContentValues values=new ContentValues();//TO CONTAIN VALUE INTO DATABASE COULMNS.
        values.put(PRODUCT_ID,record.getId());//PUTTING VALUE TO COULMNS
        values.put(PRODUCT_NAME,record.getName());
        values.put(DATE,record.getDate());
        values.put(PRICE,record.getPrice());
        return db.insert(TABLE,null,values);//RETURNING THE PUT VALUES
    }
    public List<product> getAllRecord()
    {
        List<product> prodoctlist=new ArrayList<>();
        String query="Select * from "+TABLE;
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do {
                product obj=new product();
                obj.setId(cursor.getInt(0));
                obj.setName(cursor.getString(1));
                obj.setDate(cursor.getString(2));
                obj.setPrice(cursor.getDouble(3));
                prodoctlist.add(obj);
            }
            while (cursor.moveToNext());
        }
        return prodoctlist;
    }
    public long deleteRecords(int id)
    {
        SQLiteDatabase db=getWritableDatabase();
        return db.delete(TABLE,PRODUCT_ID+"=?",new String[]{String.valueOf(id)});
    }

    public productdb createPdf() throws FileNotFoundException, DocumentException {
        String dir = Environment.getExternalStorageDirectory() + File.separator + "myLogs";
        File folder = new File(dir);
        folder.mkdirs();
        SQLiteDatabase db = getWritableDatabase();
        Cursor c1 = db.rawQuery("SELECT * FROM " + TABLE, null);
        String filename="Product.pdf";
        Document document=new Document();  // create the document
        File root = new File(Environment.getExternalStorageDirectory(), "Notes");
        if (!root.exists()) {
            root.mkdirs();   // create root directory in sdcard
        }
        File gpxfile = new File(root,filename);
        PdfWriter.getInstance(document,new FileOutputStream(gpxfile));
        document.open();
        PdfPTable table = new PdfPTable(3);
        // Code 2
        table.addCell("ID");
        table.addCell("NAME");
        table.addCell("DATE");
        table.addCell("PRICE");
        // now fetch data from database and display it in pdf
        if(c1.moveToFirst())
        {
            while (c1.moveToNext());
            {
                String ID = c1.getString(1);
                String Name = c1.getString(2);
                String Date=c1.getString(3);
                double Price=c1.getDouble(4);
                table.addCell(ID);
                table.addCell(Name);
                table.addCell(Date);
                table.addCell(String.valueOf(Price));
                document.add(table);
                document.addCreationDate();
                document.close();
            }
        }
        return null;
    }
}
