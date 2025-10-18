// import react to use its features
import React from 'react';

// function that takes students prop(the data passed to the component)
const StudentList = ({ students }) => {
    return (
        <div>
            <h2>Student List</h2>
            
            {/* checks if students list is empty, if it is prints text on screen */}
            {students.length === 0 ? (
                <p>No Students Available</p>
            ) : (

                // if students in list sends student list to be printed on the screen
            <ul>
                {/* map is a js function that loops through a list and displays them in a list */}
                {students.map((student,index) => (
                    <li key={index}> {student}</li>
                ))}
            </ul>
            )}
        </div>
    );
};

export default StudentList;