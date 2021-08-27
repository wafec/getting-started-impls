import React from "react";
import { Link } from "react-router-dom";

const DashboardPage = () => {
  return (
    <section>
      <h1>Dashboard</h1>
      <p>This is the dashboard.</p>

      <Link to="/posts" className="button">
        ViewPosts
      </Link>
    </section>
  );
};

export default DashboardPage;
