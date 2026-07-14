import React from 'react';

function CourseDetails(props) {
  return (
    <div>
      {props.courses.map((course) => (
        <div key={course.id}>
          <h2>{course.name}</h2>
          <p>{course.date}</p>
        </div>
      ))}
    </div>
  );
}

export default CourseDetails;