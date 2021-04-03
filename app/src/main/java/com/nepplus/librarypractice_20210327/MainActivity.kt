package com.nepplus.librarypractice_20210327

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener

import com.gun0912.tedpermission.TedPermission
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
//                    권한이 허용되어 있는 경우. -> 여기 { } 안에 내용을 실행을 해 준다.
//                    실제 전화를 걸자
//            그 방침을 가지고 => 실제로 권한 확인.

                    val myUri = Uri.parse("tel:010-5555-7777")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)


                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(this@MainActivity, "권한이 거부되어 전화 연결이 불가능 합니다.", Toast.LENGTH_SHORT).show()

                }

            }

         TedPermission.with(this)
                 .setPermissionListener(pl)
                 .setDeniedMessage("[설정] - [권한] 에서 전화 권한을 허용해주세요")
                 .setPermissions(Manifest.permission.CALL_PHONE)
                 .check()
        }

        profilePictureImg.setOnClickListener {

            //사진 크게보는 화면 이동

            val myIntent = Intent(this, ViewProfilePictureActivity::class.java)

            startActivity(myIntent)

        }
    }
}