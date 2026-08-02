import os
import glob
from google import genai

# Initialize Gemini Client
client = genai.Client(api_key=os.environ["GEMINI_API_KEY"])

def process_solution(file_path):
    with open(file_path, "r") as f:
        code = f.read()

    dir_path = os.path.dirname(file_path)
    readme_path = os.path.join(dir_path, "README.md")

    # Skip if problem README already exists
    if os.path.exists(readme_path):
        return

    prompt = f"""
    You are an expert technical writer and software engineer.
    Analyze the following LeetCode solution code and generate a clean Markdown README.md file.

    Requirements:
    1. Problem Title and Difficulty.
    2. Brief Intuition & Approach (3-4 bullet points max).
    3. Time and Space Complexity formatted in LaTeX (e.g., $O(N \log N)$).

    Solution Code:
    ```python
    {code}
    ```

    Return ONLY raw Markdown content with no enclosing code block backticks.
    """

    response = client.models.generate_content(
        model="gemini-2.5-flash",
        contents=prompt
    )

    with open(readme_path, "w") as f:
        f.write(response.text.strip())
    print(f"Generated README for {file_path}")

if __name__ == "__main__":
    # Scans for solution files in problem directories
    for path in glob.glob("**/*solution.py", recursive=True):
        process_solution(path)