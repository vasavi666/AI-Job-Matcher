// src/components/CandidateCard.jsx
import React from 'react';

const CandidateCard = ({ name, score }) => {
  return (
    <div className="candidate-card">
      <h3>{name}</h3>
      <p>Matching Score: <strong>{(score * 100).toFixed(2)}%</strong></p>
      <div className="score-bar">
        <div className="score-fill" style={{ width: `${score * 100}%` }}></div>
      </div>
    </div>
  );
};

export default CandidateCard;
