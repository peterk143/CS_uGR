select ename
from worker
where mgr in (select empno
		from worker
		where initcap(ename) = 'Blake')
/
