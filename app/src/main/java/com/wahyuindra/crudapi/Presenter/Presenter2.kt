package com.wahyuindra.crudapi.Presenter

import com.wahyuindra.crudapi.Activity.UpdateAddActivity
import com.wahyuindra.crudapi.Model.ResultStatus
import com.wahyuindra.crudapi.NetworkConfig
import retrofit2.Call
import retrofit2.Response

class Presenter2 (val crudView: UpdateAddActivity) {

    //Add data
    fun addData(name : String, hp : String, alamat : String, jeniskelamin : String, hobi : String){
        NetworkConfig.getService()
            .addStaff(name, hp, alamat, jeniskelamin, hobi)
            .enqueue(object : retrofit2.Callback<ResultStatus>{
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.errorAdd(t.localizedMessage)
                }
                override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>){
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.successAdd(response.body()?.pesan ?: "")
                    } else {
                        crudView.errorAdd(response.body()?.pesan ?: "")
                    }
                }
            })
    }

    //Update Data
    fun updateData(id: String, name: String, hp: String, alamat: String, jeniskelamin : String, hobi : String){
        NetworkConfig.getService()
            .updateStaff(id, name, hp, alamat, jeniskelamin, hobi)
            .enqueue(object : retrofit2.Callback<ResultStatus>{
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.onErrorUpdate(t.localizedMessage)
                }
                override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>){
                    if (response.isSuccessful && response.body()?.status == 200){
                        crudView.onSuccessUpdate(response.body()?.pesan ?: "")
                    }else{
                        crudView.onErrorUpdate(response.body()?.pesan ?: "")
                    }
                }
            })
    }
}