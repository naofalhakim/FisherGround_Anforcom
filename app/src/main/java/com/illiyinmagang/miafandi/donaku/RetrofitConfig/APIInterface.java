package com.illiyinmagang.miafandi.donaku.RetrofitConfig;

import com.illiyinmagang.miafandi.donaku.model.TempModel.TempDagangan;
import com.illiyinmagang.miafandi.donaku.model.TempModel.TempPermintaan;
import com.illiyinmagang.miafandi.donaku.model.TempModel.TempUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface APIInterface {
    @FormUrlEncoded
    @POST("login.php")
    Call<TempUser> getUsers(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("insert_mypermintaan.php")
    Call<TempPermintaan> addPermintaan(
            @Field("email") String email,
            @Field("password") String password,
            @Field("nama_pembeli") String nama_pembeli,
            @Field("alamat") String alamat,
            @Field("telp") String telp,
            @Field("nama_ikan") String nama_ikan,
            @Field("berat") String berat,
            @Field("jasa_pengiriman") String jasa_pengiriman,
            @Field("tanggal_kirim") String tanggal_kirim
    );

    @GET("show_dagangan.php/?email={email}")
    Call<TempDagangan>getDagangan(
            @Path("email") String email
    );

    @GET("show_permintaan.php")
    Call<TempPermintaan>getPermintaan();

}

