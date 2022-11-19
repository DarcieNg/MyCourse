package com.tutorial.mycourse.course;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.mycourse.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private final CourseRecyclerInterface recyclerInterface;
    private Context courseContext;
    private List<Course> courseList;

    public CourseAdapter(Context courseContext, List<Course> courseList, CourseRecyclerInterface recyclerInterface) {
        this.courseContext = courseContext;
        this.courseList = courseList;
        this.recyclerInterface = recyclerInterface;
    }

    public void setData (List<Course> list) {
        this.courseList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_card, parent, false);
        return new CourseViewHolder(view, recyclerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course = courseList.get(position);
        if (course == null) {
            return;
        }
        holder.courseId.setText(course.getCourseId());
        holder.courseName.setText(course.getCourseName());

    }

    @Override
    public int getItemCount() {
        if (courseList != null) {
            return courseList.size();
        }
        return 0;
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {

        private TextView courseId;
        private TextView courseName;

        public CourseViewHolder(@NonNull View itemView, CourseRecyclerInterface recyclerInterface) {
            super(itemView);

            courseId = itemView.findViewById(R.id.course_id);
            courseName = itemView.findViewById(R.id.course_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     if(recyclerInterface != null) {
                         int position = getBindingAdapterPosition();

                         if (position != RecyclerView.NO_POSITION) {
                             recyclerInterface.onClickCourse(position);
                         }
                     }
                }
            });
        }
    }
}
