package com.wahyuindra.crudapi.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wahyuindra.crudapi.Model.DataItem
import com.wahyuindra.crudapi.Presenter.Presenter2
import com.wahyuindra.crudapi.R
import com.wahyuindra.crudapi.Presenter.crudView
import kotlinx.android.synthetic.main.activity_update_add.*

@Suppress("SENSELESS_COMPARISON")

class UpdateAddActivity : AppCompatActivity(), crudView {

    private lateinit var presenter: Presenter2
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_add)
        presenter = Presenter2(this)
        val itemDataItem = intent.getSerializableExtra("dataItem")
        if (itemDataItem == null){
            btnAction.text = "Tambah"
            btnAction.setOnClickListener() {
                presenter.addData(
                    etName.text.toString(),
                    etPhone.text.toString(),
                    etAlamat.text.toString(),
                    etKelamin.text.toString(),
                    etHobi.text.toString())
            }
        }else if (itemDataItem != null){
            btnAction.text = "Update"
            val item = itemDataItem as DataItem?
            etName.setText(item?.staffName.toString())
            etPhone.setText(item?.staffHp.toString())
            etAlamat.setText(item?.staffAlamat.toString())
            etKelamin.setText(item?.jeniskelamin.toString())
            etHobi.setText(item?.hobi.toString())
            btnAction.setOnClickListener() {
                presenter.updateData(
                    item?.staffId ?: "",
                    etName.text.toString(),
                    etPhone.text.toString(),
                    etAlamat.text.toString(),
                    etKelamin.text.toString(),
                    etHobi.text.toString())
                finish()
            }
        }
    }
    override fun successAdd(msg: String) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
    override fun errorAdd(msg: String) {}
    override fun onSuccessUpdate(msg: String) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
    override fun onErrorUpdate(msg: String) {}
    override fun onSuccessGet(data: List<DataItem>?) {}
    override fun onFailedGet(msg: String) {}
    override fun onSuccessDelete(msg: String) {}
    override fun onErrorDelete(msg: String) {}
}