import { Provider } from "react-redux";
import { render } from "react-dom";
import { configureStore } from "@reduxjs/toolkit";

import rootReducer from "./slices";

import App from "./App";
import "./index.css";

const store = configureStore({ reducer: rootReducer });

render(
  <Provider store={store}>
    <App />
  </Provider>,
  document.getElementById("root")
);
