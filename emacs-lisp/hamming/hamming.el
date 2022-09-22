;;; hamming.el --- Hamming (exercism)

;;; Commentary:

;;; Code:

(require 'cl-lib)

(defun string->chars (str)
  (cl-map 'list #'string (string-to-list str)))

(defun hamming-distance (strand1 strand2)
  (if (= (length strand1) (length strand2))
      (length (cl-remove-if-not #'null (cl-mapcar #'equal (string->chars strand1) (string->chars strand2))))
    (user-error "Unmatched lengths")))

(provide 'hamming)
;;; hamming.el ends here
