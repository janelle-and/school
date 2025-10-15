// import React, {useState} from "react";
// // importing the StudentList component
// import StudentList from "./components/StudentList";
// import AddStudentForm from "./components/AddStudentForm";

// import {BrowserRouter as Router, Route, Link, Routes} from "react-router-dom";

// function App() {
//   const [students, setStudents] = useState(["Alice","Bob","Charlie"]);

//   const handleAddStudent = (newStudent) => {
//     // putting all the existing students array into a new array and then appending the newStudent
//     setStudents([...students, newStudent]);
//   };

//   return (
//     <Router>
//       <div className="App">
//         <nav>
//           <ul>
//             <li><link to="/">Home</link> </li>
//             <li><Link to="/add-student">Add Student</Link> </li>
//           </ul>
//         </nav>
//         <Routes>
//           <Route path="/" elemtent={<StudentList students={students}/>}/>
//           <Route path="/add-student" element={<AddStudentForm onAddStudent={handleAddStudent}/>}/>
//         </Routes>
//       </div>
//     </Router>
//   );
// }

// export default App;

import React, { useState } from 'react';
import StudentList from './components/StudentList';
import AddStudentForm from './components/AddStudentForm';
function App() {
 const [students, setStudents] = useState(['Alice', 'Bob',
'Charlie']);
 const handleAddStudent = (newStudent) => {
 setStudents([...students, newStudent]);
 };
 return (
 <div className="App">
 <StudentList students={students} />
 <AddStudentForm onAddStudent={handleAddStudent} />
 </div>
 );
}
export default App;
