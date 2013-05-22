(defun count-of (thing list)
  (if (null list)
      0
      (+
       (if (listp (car list))
	   count-of (thing (car list))
	   (progn (if (eql thing (car list))
	       1
	       0)))
       (count-of (thing (cdr list))))))
