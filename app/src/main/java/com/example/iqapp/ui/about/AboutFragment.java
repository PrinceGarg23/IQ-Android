package com.example.iqapp.ui.about;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iqapp.R;
import com.example.iqapp.databinding.AboutFragmentBinding;

public class AboutFragment extends Fragment {

    private AboutViewModel aboutViewModel;
    private AboutFragmentBinding binding;

    private ConstraintLayout contact,linkedin,facebook,instagram,twitter,youtube,board;

    private static final String EMAIL = "contact.iquestvit@gmail.com";
    private static final String FACEBOOK = "https://www.facebook.com/InnovatorsQuest/";
    private static final String TWITTER = "https://twitter.com/innovatorsvit/";
    private static final String INSTAGRAM = "https://www.instagram.com/iquest.vit/";
    private static final String LINKEDIN = "https://www.linkedin.com/company/innovatorsquest/";
    private static final String YOUTUBE = "https://www.youtube.com/channel/UC07_a96S__f53ySk_5H7jCA";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutViewModel =
                new ViewModelProvider(this).get(AboutViewModel.class);

        binding = AboutFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        contact = getView().findViewById(R.id.contactus);
        linkedin = getView().findViewById(R.id.linkedinSettings);
        facebook = getView().findViewById(R.id.facebookSettings);
        instagram = getView().findViewById(R.id.instagramSettings);
        twitter = getView().findViewById(R.id.twitterSettings);
        youtube = getView().findViewById(R.id.youtubeSettings);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_SUBJECT,"");
                intent.putExtra(Intent.EXTRA_TEXT,"");
                startActivity(intent);
            }
        });

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(LINKEDIN);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                v.getContext().startActivity(intent);
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(FACEBOOK);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                v.getContext().startActivity(intent);
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(TWITTER);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                v.getContext().startActivity(intent);
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(INSTAGRAM);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                v.getContext().startActivity(intent);
            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(YOUTUBE);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

}