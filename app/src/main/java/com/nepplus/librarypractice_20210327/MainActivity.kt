package com.nepplus.librarypractice_20210327

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gun0912.tedpermission.PermissionListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        callBtn.setOnClickListener {
//            버튼이 눌리면 - 권한이 있는지 확인 - OK일때 바로 전화 연결
//            권한이 없으면 => 연결불가 안내 토스트


//            권한 상태에 따른 행동 방침 변수 저장.

            val pl = object : PermissionListener {
                override fun onPermissionGranted() {

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

                }

            }

//            그 방침을 가지고 => 실제로 권한 확인.

            val myUri = Uri.parse("tel:010-5555-7777")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)

        }


        profilePictureImg.setOnClickListener {

            //사진 크게보는 화면 이동

            val myIntent = Intent(this, ViewProfilePictureActivity::class.java)

            startActivity(myIntent)

        }
    }
}