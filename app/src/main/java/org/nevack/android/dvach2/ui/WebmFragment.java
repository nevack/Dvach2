package org.nevack.android.dvach2.ui;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveVideoTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import org.nevack.android.dvach2.R;

public class WebmFragment extends Fragment {
    private SimpleExoPlayerView playerView;
    private SimpleExoPlayer player;

    private String webmUrl;

    private static final String WEBM_URL_ARG = "webmurl";
    private MediaSource videoSource;

    public static WebmFragment newInstance(String webmUrl) {
        WebmFragment fragment = new WebmFragment();
        Bundle args = new Bundle();
        args.putString(WEBM_URL_ARG, webmUrl);
        fragment.setArguments(args);
        return fragment;
    }

    public WebmFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveVideoTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector =
                new DefaultTrackSelector(videoTrackSelectionFactory);
        LoadControl loadControl = new DefaultLoadControl();

        player = ExoPlayerFactory.newSimpleInstance(getContext(), trackSelector, loadControl);
        webmUrl = getArguments().getString(WEBM_URL_ARG);

        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getContext(),
                Util.getUserAgent(getContext(), "Dvach2"));
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        videoSource = new ExtractorMediaSource(Uri.parse(webmUrl),
                dataSourceFactory, extractorsFactory, null, null);
        player.setPlayWhenReady(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_webm, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        playerView = (SimpleExoPlayerView) view.findViewById(R.id.playerview);
        playerView.setPlayer(player);
    }

    @Override
    public void onStart() {
        super.onStart();
        player.prepare(videoSource);
    }

    @Override
    public void onDestroy() {
        player.release();
        super.onDestroy();
    }
}
