import logo from './logo.svg';
import './App.css';
import styled, { css } from 'styled-components';

const Container = styled.div`
  text-align: center
`;

const Button = styled.button`
  background: transparent;
  border-radius: 3px;
  border: 2px solid palevioletred;
  color: palevioletred;
  margin: 0 1em;
  padding: 0.25em 1em;

  ${props =>
    props.primary &&
    css`
      background: palevioletred;
      color: white;
    `}
`;

function App() {
  return (    
      <Container>
        <Button>Test</Button>
        <Button primary>Primary</Button>
      </Container>
  );
}

export default App;
