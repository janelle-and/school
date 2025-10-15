import React from 'react';
import styled from 'styled-components';

const TodoItem = styled.div`
    display: flex;
    justify-content: space-between;
    padding: 10px;
    background-color: #f0f0f0;
    margin: 5px 0;
    border-radius: 5px;
`;

const DeleteButton = styled.button`
    background-color: red;
    color: white;
    border: none;
    border-radius: 5px;
    padding: 5px;
`;

// a single task item
function Todo({task, onDelete}) {
    return (
        <TodoItem>
            <span>{task}</span>
            <DeleteButton onClick={onDelete}>Delete</DeleteButton>
        </TodoItem>
    )
}

export default Todo;