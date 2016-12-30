package org.nevack.android.dvach2.ui;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Callback;

import org.nevack.android.dvach2.R;
import org.nevack.android.dvach2.Utils;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ImageFragment extends Fragment {

    private ImageView imageView;
    private PhotoViewAttacher attacher;
    private String imageUrl;

    private static final String IMAGE_URL_ARG = "imageurl";

    public static ImageFragment newInstance(String imageUrl) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putString(IMAGE_URL_ARG, imageUrl);
        fragment.setArguments(args);
        return fragment;
    }

    public ImageFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageUrl = getArguments().getString(IMAGE_URL_ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = (ImageView) view.findViewById(R.id.imageview);
        attacher = new PhotoViewAttacher(imageView);
    }

    @Override
    public void onStart() {
        Utils.getPicasso(getContext()).load(Uri.parse(imageUrl)).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                attacher.update();
            }

            @Override public void onError() {}
        });
        super.onStart();
    }
}
