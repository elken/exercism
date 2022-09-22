;;; leap.el --- Leap exercise (exercism)

;;; Commentary:

;;; Code:

(defun leap-year-p (year)
  (if (zerop (mod year 100))
      (zerop (mod year 400))
    (zerop (mod year 4))))

(provide 'leap-year-p)
;;; leap.el ends here
