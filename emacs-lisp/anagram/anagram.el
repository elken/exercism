;;; anagram.el --- Anagram (exercism)

;;; Commentary:

;;; Code:

(require 'cl-lib)

(defun string->chars (str)
  (cl-map 'list #'string (string-to-list str)))

(defun anagrams-for (word candidates)
  (let* ((word (downcase word))
         (sorted-word (sort (string->chars word) #'string<)))
    (cl-remove-if-not (lambda (word-candidate)
                    (and (equal sorted-word (sort (string->chars (downcase word-candidate)) #'string<))
                         (not (equal word (downcase word-candidate)))))
                  candidates)))

(provide 'anagram)
;;; anagram.el ends here
