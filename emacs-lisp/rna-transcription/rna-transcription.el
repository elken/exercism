;;; rna-transcription.el -- RNA Transcription (exercism)

;;; Commentary:



;;; Code:

(require 'cl-lib)

(defun string->chars (str)
  (cl-map 'list #'string (string-to-list str)))

(defun get-complement (nucleotide)
  (pcase nucleotide
    ("G" "C")
    ("C" "G")
    ("T" "A")
    ("A" "U")
    (_ (user-error "Invalid strand"))))

(defun to-rna (strand)
  (mapconcat #'get-complement (string->chars strand) ""))

(provide 'rna-transcription)
;;; rna-transcription.el ends here
