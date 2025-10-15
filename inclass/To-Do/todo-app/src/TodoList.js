import React from 'react';
import Todo from './Todo';
import styled from 'styled-components';

const ListContainer = styled.div`
    margin: 20px 0;
`;

// list of todo components
function TodoList({todos, onDelete}) {
    return (
        <ListContainer>
            {todos.map((todo, index) => (
                <Todo key={index} task={todo} onDelete={() => onDelete(index)} />
            ))}
        </ListContainer>
    )
}

export default TodoList;