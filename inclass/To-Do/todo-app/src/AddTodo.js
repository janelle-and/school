import React, { useState } from 'react';
import styled from 'styled-components';

const Form = styled.form`
    display: flex;
    justofy-content: center
    margin-bottom: 20px;
`;

const Input = styled.input`
    padding: 10px;
    margin-right: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
`;

const Button = styled.button`
    padding: 10px;
    background-color: green;
    color: white;
    border: none;
    border-radius: 5px;
`;

// form to add a new task
function AddTodo({onAdd}) {
    const [task, setTask] = useState('');
    const handleSubmit = (e) => {
        e.preventDefault();
        if (task.trim()) {
            onAdd(task);
            setTask('');
        }
    }


    return (
        <Form onSubmit={handleSubmit}>
            <Input 
                type="text"
                value={task}
                onChange={(e) => setTask(e.target.value)}
                placeholder="Add a new task"
            />
            <Button type="submit">Add</Button>
        </Form>
    )
};

export default AddTodo;