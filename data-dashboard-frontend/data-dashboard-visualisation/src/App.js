import logo from "./logo.svg";
import "./App.css";
import React, { useEffect, useRef, useState } from "react";
import * as d3 from "d3";
import BarChart from "./components/BarChart";
import axios from "axios";
import { LOCAL_HOST } from "./API";
import PieChart from "./components/PieChart";

function App() {
  return (
    <>
      <BarChart />
      <PieChart />
    </>
  );
}

export default App;
