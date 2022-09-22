;;; roman-numerals.el --- roman-numerals Exercise (exercism)

;;; Commentary:

;;; Code:

(require 'calc)
(require 'subr-x)
(require 'cl-lib)

(defvar roman-numerals-digits
  '((1000 . "M")
    (900 . "CM")
    (500 . "D")
    (400 . "CD")
    (100 . "C")
    (90 . "XC")
    (50 . "L")
    (40 . "XL")
    (10 . "X")
    (9 . "IX")
    (5 . "V")
    (4 . "IV")
    (1 . "I")))

(defun to-roman (num)
  (cl-reduce (lambda (acc n)
               (let ((quot (math-quotient num (car n))))
                 (setq num (math-mod num (car n)))
                 (concat acc (cl-loop repeat (if (wholenump quot) quot 0) concat (cdr n)) )))
             roman-numerals-digits
             :initial-value ""))

(provide 'roman-numerals)
;;; roman-numerals.el ends here
