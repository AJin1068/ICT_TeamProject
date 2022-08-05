
--�߸�������� ���̺� �����
drop table report cascade constraints


--1. �Ű� ���� ��Ͽ� ���̺�(�Ǽ����� insert)
create table report
(
	r_idx			int,	-- �Ϸù�ȣ
	u_idx_reported	int,	-- �Ű� ���� ȸ��
	u_idx_reporting int,    -- �Ű��� ȸ��
	r_reason varchar2(100),	-- �Ű� ����
	r_date			date   -- �Ű� ��¥   
)

--�Ű� ���� üũ ����
alter table report
add constraint ch_report_r_reason 
check( r_reason in ('re_add_cnt','re_fake_cnt','re_inhibit_cnt','re_scam_cnt'))

/*re_add_cnt		int,	-- ����
	re_fake_cnt 	int,	-- ��ǰ ������(��ǰ/�߸��� ��ǰ)
	re_inhibit_cnt	int,	-- �ŷ�������ǰ(���/�ַ�/������/�����..)
	re_scam_cnt		int,	-- ���(�Ǵ� ���ġ���� �ǵ�)*/

select count(*) from report where u_idx_reported = 2 and  u_idx_reporting = 9

select 
 		to_char(r_date,'yyyy-mm-dd hh24:mi:ss')r_date,
 		u_idx_reported, u_idx_reporting,
 		(select s)
from 
		(
			select * from report order by r_date
		)
where  rownum <= 8 
		
    select 
        r_idx,
 		to_char(r_date,'yyyy-mm-dd hh24:mi:ss')r_date,
 		u_idx_reported, u_idx_reporting
		from (select * from report order by r_date)
		where rownum <= 8 

  select *, count(u_idx_reported)
	  from report 
	  group by u_idx_reported 
	  where u_i
	  dx_reported = 2
	  
	  select 
	    r_idx,
 		to_char(r_date,'yyyy-mm-dd hh24:mi:ss') r_date,
 		u_idx_reported, 
 		u_idx_reporting
		from (select * from report order by r_date)
		where r_idx=1
		
	 select 
	    r_idx,
 		to_char(r_date,'yyyy-mm-dd hh24:mi:ss') r_date,
 		u_idx_reported, 
 		u_idx_reporting,
 		r_reason
		from (select * from report order by r_date)
		where r_idx = 3
 
select * from report
