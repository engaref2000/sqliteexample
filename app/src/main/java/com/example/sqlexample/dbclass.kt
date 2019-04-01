package com.example.sqlexample

import android.content.ContentValues
import android.content.Context
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast


var dbname="SEIDB"


class db(var context: Context?):SQLiteOpenHelper(context, dbname, null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        val sqlst= "CREATE TABLE Material ( "+
                               "ID NUMERIC,EMSNO TEXT,NAME TEXT,MAXt NUMERIC,"+
                                "MAINT INTEGER ,MAXH INTEGER, MAINH INTEGER ,BARCODE TEXT"+
                                           ")"
        db?.execSQL( sqlst)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

fun InsertData(material:Material){
    var db=this.writableDatabase
    var cv= ContentValues()
    cv.put("ID",material.id)
    cv.put("EMSNO",material.emsNo)
    cv.put("NAME",material.name)
    cv.put("MAXt",material.Maxt)
    cv.put("MAINT",material.mainT)
    cv.put("MAXH",material.maxH)
    cv.put("MAINH",material.mainH)
    cv.put("BARCODE",material.barcode)
    var result =db.insert("Material" , null , cv)
    if (result==-1.toLong()){
       Toast.makeText(context , "some this Error ",Toast.LENGTH_SHORT).show()
    }else{
        Toast.makeText(context , "one Row insert ",Toast.LENGTH_SHORT).show()
    } 


}
}

class Material(var id :Int , var emsNo:String , var name :String , var  Maxt:Float  ,
               var mainT:Float , var maxH:Float , var mainH:Float , var barcode:String){

}