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

    private Context courseContext;
    private List<Course> courseList;
    private int checkedPosition = -1;

    public CourseAdapter(Context courseContext) {
        this.courseContext = courseContext;
    }

    public void setData (List<Course> list) {
        this.courseList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_card, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course = courseList.get(position);
        if (course == null) {
            return;
        }

        holder.courseId.setText(course.getCourseId());
        holder.courseName.setText(course.getCourseName());

        // add Listener to toggle card
    }

    @Override
    public int getItemCount() {
        if (courseList != null) {
            return courseList.size();
        }
        return 0;
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {

        private TextView courseId;
        private TextView courseName;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            courseId = itemView.findViewById(R.id.course_id);
            courseName = itemView.findViewById(R.id.course_name);
        }

        void bind(final Course course) {
            if (checkedPosition == -1) {
                // no position is targeted
                return;
            } else {
                if (checkedPosition == getBindingAdapterPosition()) {
                    // intent to the belonged list of files of the courses
                } else {
                    // no position is targeted
                    return;
                }
            }
        }
    }
}
