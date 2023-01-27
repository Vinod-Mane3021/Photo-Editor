package com.example.myeditor;

import static com.example.myeditor.MainActivity.imgUri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;
import com.example.myeditor.databinding.ActivityAtivityFinalBinding;

public class ativity_final extends AppCompatActivity {
    ActivityAtivityFinalBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAtivityFinalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // need intent to go in the library
        Intent dsPhotoEditorIntent = new Intent(this, DsPhotoEditorActivity.class);
        // img data in Uri form
        dsPhotoEditorIntent.setData(imgUri);

        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "My Editor");  // My Editor -> folder created for output

//        int[] toolsToHide = {DsPhotoEditorActivity.TOOL_ORIENTATION, DsPhotoEditorActivity.TOOL_CROP};
//        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_TOOLS_TO_HIDE, toolsToHide);

        startActivityForResult(dsPhotoEditorIntent, 200);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 200:
                    Uri outputUri = data.getData();
                    // handle the result uri as you want, such as display it in an imageView;
                    // imageView.setImageURI(outputUri);
                    binding.imgView.setImageURI(outputUri);
                    break;
            }
        }
    }
}