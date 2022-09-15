package com.mayurkakade.moderncodingchamp.recycler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mayurkakade.moderncodingchamp.R;
import com.mayurkakade.moderncodingchamp.api.content.ContentPojo;
import com.mayurkakade.moderncodingchamp.api.content.ContentResponseObject;
import com.mayurkakade.moderncodingchamp.api.subjects.SubjectPojo;
import com.mayurkakade.moderncodingchamp.api.subjects.SubjectResponseObject;
import com.mayurkakade.moderncodingchamp.api.subtitles.SubtitlePojo;
import com.mayurkakade.moderncodingchamp.api.subtitles.SubtitleResponseObject;
import com.mayurkakade.moderncodingchamp.api.titles.TitlesPojo;
import com.mayurkakade.moderncodingchamp.api.titles.TitlesResponseObject;
import com.mayurkakade.moderncodingchamp.ui.main.MainViewModel;
import com.pddstudio.highlightjs.HighlightJsView;
import com.pddstudio.highlightjs.models.Language;
import com.pddstudio.highlightjs.models.Theme;


import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    Type type;
    Context context;
    List<SubjectPojo> subjectsPojoList = new ArrayList<>();
    List<TitlesPojo> titlesPojoList = new ArrayList<>();
    List<SubtitlePojo> subtitlesPojoList = new ArrayList<>();
    List<ContentPojo> contentPojoList = new ArrayList<>();
    MainViewModel mainViewModel;

    public ListAdapter(Type type, Context context, MainViewModel viewModel) {
        this.type = type;
        this.context = context;
        this.mainViewModel = viewModel;
    }

    public void setSubjectsList( SubjectResponseObject subjectsList )
    {
        this.subjectsPojoList.addAll(subjectsList.getSubject);
    }

    public void setTitlesList(@Nullable TitlesResponseObject titlesList) {
        this.titlesPojoList.addAll(titlesList.getGetTitles());
    }


    public void setSubTitleList(@Nullable SubtitleResponseObject subtitleList) {
        this.subtitlesPojoList.addAll(subtitleList.getGetSubtitles());
    }

    public void setContentList(@Nullable ContentResponseObject contentList) {
        this.contentPojoList.addAll(contentList.getGetContent());
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (type) {
            case SUBJECTS:
                return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.single_list_item, parent, false));
            case CONTENT:
                return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.single_content, parent, false));
                default:
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.single_list_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        int[] rainbow = context.getResources().getIntArray(R.array.rainbow);
        int colorCode = rainbow[ position % 12 ];

        switch (type)
        {
            case SUBJECTS:
                holder.tvCard.setText(subjectsPojoList.get(position).title);
                holder.cardView.setCardBackgroundColor( colorCode );
                break;
            case TITLES:
                holder.tvCard.setText(titlesPojoList.get(position).getTitle());
                holder.cardView.setCardBackgroundColor( colorCode );
                break;
            case SUBTITLE:
                holder.tvCard.setText(subtitlesPojoList.get(position).getSubtitleName());
                holder.cardView.setCardBackgroundColor( colorCode );
                break;
            case CONTENT:
                bindContent(holder, position);
                break;
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick(position);
            }
        });
    }

    private void bindContent(ViewHolder holder, int position) {

        if (!contentPojoList.get(position).getContentTitle().equals("") && contentPojoList.get(position).getContentTitle() != null) {
            holder.tv_title.setText(contentPojoList.get(position).getContentTitle());
        }else {
            holder.tv_title.setVisibility(View.GONE);
        }

        if (!contentPojoList.get(position).getContentText().equals("") && contentPojoList.get(position).getContentText() != null) {
            holder.tv_text.setText(contentPojoList.get(position).getContentText());
        }else {
            holder.tv_text.setVisibility(View.GONE);
        }
//        if (!contentPojoList.get(position).getContent_img().equals("") && contentPojoList.get(position).getContent_img() != null) {
//            Picasso.get().load(Config.API.IMAGE_URL+contentPojoList.get(position).getContent_img()).into(holder.iv_image);
//        }
//        else
        {
            holder.iv_image.setVisibility(View.GONE);
        }


        if ( contentPojoList.get(position).getContentCode() != null && !contentPojoList.get(position).getContentCode().equals("")) {
            holder.codeView.setVisibility(View.VISIBLE);
            holder.codeView.setTheme(Theme.ANDROID_STUDIO);
            holder.codeView.setHighlightLanguage(Language.AUTO_DETECT);
            holder.codeView.setSource(contentPojoList.get(position).getContentCode());
        }else {
            holder.codeView.setVisibility(View.GONE);
        }

    }

    private void onItemClick(int position) {
        switch (type)
        {
            case SUBJECTS:
                mainViewModel.openSubject(subjectsPojoList.get(position));
                break;
            case TITLES:
                mainViewModel.openTitle(titlesPojoList.get(position));
                break;
            case SUBTITLE:
                mainViewModel.openSubtitle(subtitlesPojoList.get(position));
                break;
            case CONTENT:

                break;
        }
    }

    @Override
    public int getItemCount() {
        switch (type)
        {
            case SUBJECTS:
                return subjectsPojoList.size();
            case TITLES:
                return titlesPojoList.size();
            case SUBTITLE:
                return subtitlesPojoList.size();
            case CONTENT:
                return contentPojoList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView tvCard;
        ImageView iv_image;
        TextView tv_title,tv_text;
        HighlightJsView codeView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCard = itemView.findViewById( R.id.tv_single_title );
            cardView = itemView.findViewById( R.id.card );
            if (type == Type.CONTENT)
            {
                iv_image = itemView.findViewById(R.id.iv_content_image);
                tv_title = itemView.findViewById(R.id.content_title);
                tv_text = itemView.findViewById(R.id.content_description);
                codeView = itemView.findViewById(R.id.codeView);
            }
        }
    }
}
