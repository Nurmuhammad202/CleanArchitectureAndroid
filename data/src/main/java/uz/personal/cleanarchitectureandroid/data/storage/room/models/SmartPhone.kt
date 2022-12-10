package uz.personal.cleanarchitectureandroid.data.storage.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "smart_phone")
class SmartPhone(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    @ColumnInfo(name = "product_name")
    var productName: String,
    @ColumnInfo(name = "product_price")
    var productPrice: Double,
) {
    constructor() : this(0L, "", 0.0)
}