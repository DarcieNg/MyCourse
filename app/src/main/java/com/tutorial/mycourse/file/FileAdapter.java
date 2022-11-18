package com.tutorial.mycourse.file;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.mycourse.R;

import java.util.List;

public class FileAdapter extends RecyclerView.Adapter<FileAdapter.FileViewHolder>{

    /**
     * TASK NEED TO DO: Change List<PDFfile> to FileList based on the id of the course ???
     */
    private Context fileContext;
    private List<PDFfile> fileList;

    public FileAdapter(Context fileContext) {
        this.fileContext = fileContext;
    }

    public void setData (List<PDFfile> list) {
        this.fileList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FileAdapter.FileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.file_card, parent, false);
        return new FileAdapter.FileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FileAdapter.FileViewHolder holder, int position) {
        PDFfile file = fileList.get(position);
        if (file == null) {
            return;
        }

        holder.fileName.setText(file.getFile_name());

        // add behavior to display file - using WebView
    }

    @Override
    public int getItemCount() {
        if (fileList != null) {
            return fileList.size();
        }
        return 0;
    }

    public class FileViewHolder extends RecyclerView.ViewHolder{

        private TextView fileName;

        public FileViewHolder(View view) {
            super(view);

            fileName = view.findViewById(R.id.file_name);
        }
    }
}
