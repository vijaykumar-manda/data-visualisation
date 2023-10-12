import React, { useEffect, useRef } from "react";
import * as d3 from "d3";
import { LOCAL_HOST } from "../API";
import { useState } from "react";
import axios from "axios";

function BarChart() {
  const svgRef = useRef(null);
  const [data, setData] = useState([]);
  useEffect(() => {
    const dataload = async () => {
      const response = await axios.get(LOCAL_HOST + "/api/intensity-count");
      console.log(response.data);
      setData(response.data);
    };
    dataload();
    console.log(dataload.data);
  }, []);

  useEffect(() => {
    const svg = d3.select(svgRef.current);
    const margin = { top: 20, right: 30, bottom: 50, left: 60 };
    const width = 600 - margin.left - margin.right;
    const height = 400 - margin.top - margin.bottom;

    // Create a group element for the chart content
    const chart = svg
      .append("g")
      .attr("transform", `translate(${margin.left}, ${margin.top})`);

    const xScale = d3
      .scaleBand()
      .domain(data.map((d) => d[0]))
      .range([0, width])
      .padding(0.1);

    const yScale = d3
      .scaleLinear()
      .domain([0, d3.max(data, (d) => d[1])])
      .nice()
      .range([height, 0]);

    // Create the bars
    chart
      .selectAll("rect")
      .data(data)
      .enter()
      .append("rect")
      .attr("x", (d) => xScale(d[0]))
      .attr("y", (d) => yScale(d[1]))
      .attr("width", xScale.bandwidth())
      .attr("height", (d) => height - yScale(d[1]))
      .attr("fill", "steelblue");

    // Create x-axis
    chart
      .append("g")
      .attr("transform", `translate(0, ${height})`)
      .call(d3.axisBottom(xScale))
      .append("text") // X-axis label
      .attr("x", width / 2)
      .attr("y", margin.bottom - 10)
      .attr("fill", "black")
      .style("text-anchor", "middle")
      .text("Intensity");

    // Create y-axis
    chart
      .append("g")
      .call(d3.axisLeft(yScale))
      .append("text") // Y-axis label
      .attr("transform", "rotate(-90)")
      .attr("x", -height / 2)
      .attr("y", -margin.left + 20)
      .attr("fill", "black")
      .style("text-anchor", "middle")
      .text("Frequency");

    // Create a layout box around the chart
    svg
      .append("rect")
      .attr("x", 0)
      .attr("y", 0)
      .attr("width", width + margin.left + margin.right)
      .attr("height", height + margin.top + margin.bottom)
      .attr("fill", "none")
      .attr("stroke", "black")
      .attr("stroke-width", 1);
  }, [data]);

  return (
    <div className="bar-chart-container">
      <svg
        ref={svgRef}
        width={600}
        height={400}
        style={{ display: "block", margin: "0 auto" }}
      ></svg>
    </div>
  );
}

export default BarChart;
