 // src/App.jsx
import React, { useState } from 'react';
import CandidateCard from './components/CandidateCard';
import './styles.css';

const App = () => {
  const [candidates, setCandidates] = useState([]);
  const [loading, setLoading] = useState(false);
  const [jobDesc, setJobDesc] = useState("");

  const fetchMatches = async () => {
    setLoading(true);
    const response = await fetch("http://localhost:8080/api/jobs/match", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        jobDescription: jobDesc,
        resumes: [
          "Java developer with Spring Boot experience",
          "Frontend engineer with Angular skills",
          "Python developer with ML experience"
        ]
      })
    });

    const data = await response.json();
    setCandidates(data);
    setLoading(false);
  };

  return (
    <div className="container">
      <h1>AI Job Matcher</h1>
      <textarea
        placeholder="Enter job description..."
        value={jobDesc}
        onChange={(e) => setJobDesc(e.target.value)}
      ></textarea>
      <button onClick={fetchMatches}>Match Resumes</button>

      {loading ? (
        <p>Loading...</p>
      ) : (
        <div className="candidate-list">
          {candidates.map((c, idx) => (
            <CandidateCard key={idx} name={c.candidateName} score={c.score} />
          ))}
        </div>
      )}
    </div>
  );
};

export default App;
