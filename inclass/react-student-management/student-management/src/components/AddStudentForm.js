import React, {useState} from "react";

const AddStudentForm = ({onAddStudent}) => {
    // use state allows you to store and update data (ex. student name)
    const [newStudent, setNewStudent] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        onAddStudent(newStudent);
        setNewStudent("");
    };

    return(
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                value={newStudent}
                onChange={(e) => setNewStudent(e.target.value)}
                placeholder="Enter Student Name"
            />
            <button type="submit">Add Student</button>
        </form>
    );
};

export default AddStudentForm;