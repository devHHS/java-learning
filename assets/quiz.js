// Shared retrieval-practice quiz checker for java-learning lessons.
// Usage: <div class="quiz" data-answer="int"> ... <input class="quiz-input"> <button onclick="checkQuiz(this)"> ... <span class="quiz-feedback">
function checkQuiz(button) {
  const quiz = button.closest('.quiz');
  const input = quiz.querySelector('.quiz-input');
  const feedback = quiz.querySelector('.quiz-feedback');
  const answer = quiz.dataset.answer.trim().toLowerCase();
  const given = input.value.trim().toLowerCase();

  if (given === answer) {
    feedback.textContent = '맞음.';
    feedback.className = 'quiz-feedback correct';
  } else {
    feedback.textContent = '다시. (Enter로도 제출 가능)';
    feedback.className = 'quiz-feedback wrong';
  }
}

document.addEventListener('DOMContentLoaded', () => {
  document.querySelectorAll('.quiz-input').forEach((input) => {
    input.addEventListener('keydown', (e) => {
      if (e.key === 'Enter') {
        const button = input.closest('.quiz').querySelector('button');
        checkQuiz(button);
      }
    });
  });
});
