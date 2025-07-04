from flask import Flask, request, jsonify
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity

app = Flask(__name__)

@app.route("/match", methods=["POST"])
def match():
    data = request.get_json()
    if not data or 'job' not in data or 'resumes' not in data:
        return jsonify({'error': 'Missing "job" or "resumes" in request'}), 400

    job = data['job']
    resumes = data['resumes']

    vectorizer = TfidfVectorizer().fit([job] + resumes)
    vectors = vectorizer.transform([job] + resumes)
    scores = cosine_similarity(vectors[0:1], vectors[1:]).flatten()

    results = [{"candidateName": f"Candidate {i+1}", "score": round(float(s), 4)} for i, s in enumerate(scores)]
    return jsonify(results)

if __name__ == "__main__":
    app.run(port=5000)
