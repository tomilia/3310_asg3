package com.example.tommylee.cuhilltown;

import android.app.Activity;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.tommylee.cuhilltown.dummy.DummyContent;

/**
 * A fragment representing a single Clip detail screen.
 * This fragment is either contained in a {@link ClipListActivity}
 * in two-pane mode (on tablets) or a {@link ClipDetailActivity}
 * on handsets.
 */
public class ClipDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    VideoView videox;
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ClipDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }
    private Uri getMedia(String mediaName)
    {
        if (URLUtil.isValidUrl(mediaName)) {
            return  Uri.parse(mediaName);
            // media name is an external URLreturn Uri.parse(mediaName);
        }
        else {
            return Uri.parse("android.resource://" + getActivity().getPackageName() + "/raw/" + mediaName);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.clip_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            Uri uri=getMedia(mItem.details);
            MediaController controller = new MediaController(getContext());

            videox=((VideoView) rootView.findViewById(R.id.videox));
            controller.setMediaPlayer(videox);
            videox.setMediaController(controller);
            videox.setVideoURI(uri);
            videox.start();
        }

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releasePlayer();
    }

    private void releasePlayer() {videox.stopPlayback();}
}
