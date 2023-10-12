import React, { useEffect, useRef, useState } from "react";
import * as d3 from "d3";
import axios from "axios";
import { LOCAL_HOST } from "../API";

function PieChart() {
  const svgRef = useRef(null);
  const [data, setData] = useState([]);
  const margin = { top: 20, right: 30, bottom: 50, left: 60 };

  useEffect(() => {
    const dataload = async () => {
      const response = await axios.get(LOCAL_HOST + "/api/likelihood-count");
      console.log(response.data);
      setData(response.data);
    };
    dataload();
    console.log(dataload.data);
  }, []);

  useEffect(() => {
    const svg = d3.select(svgRef.current);
    const width = 500;
    const height = 500;

    // Create a group element for the chart content
    const chart = svg
      .append("g")
      .attr("transform", `translate(${width / 2}, ${height / 2})`);

    // Create a color scale with unique colors for each label
    const color = d3
      .scaleOrdinal()
      .domain(data.map((d) => d[0]))
      .range(d3.schemeTableau10);

    // Create a pie layout
    const pie = d3.pie().value((d) => d[1]);

    // Generate pie slices
    const arc = d3
      .arc()
      .innerRadius(0)
      .outerRadius(Math.min(width, height) / 2);

    const arcs = pie(data);

    // Create arcs for the pie slices
    chart
      .selectAll("path")
      .data(arcs)
      .enter()
      .append("path")
      .attr("d", arc)
      .attr("fill", (d) => color(d.data[0])) // Use unique colors for each label
      .attr("stroke", "white")
      .style("stroke-width", "2px");

    // Add labels inside the pie slices
    chart
      .selectAll(".label")
      .data(arcs)
      .enter()
      .append("text")
      .attr("transform", (d) => `translate(${arc.centroid(d)})`)
      .attr("dy", "0.35em")
      .style("text-anchor", "middle")
      .attr("class", "label")
      .text((d) => d.data[0]);

    // Add a label at the center of the pie chart
    svg
      .append("text")
      .attr("x", 0) // Adjust the x-coordinate as needed
      .attr("y", 0) // Adjust the y-coordinate as needed
      .attr("text-anchor", "middle")
      .attr("class", "center-label")
      .text("Pie Chart Label"); // Replace with your desired label
  }, [data]);

  return (
    <div className="pie-chart-container">
      <svg
        ref={svgRef}
        width={500}
        height={500}
        style={{ display: "block", margin: "0 auto" }}
      ></svg>
    </div>
  );
}

export default PieChart;
