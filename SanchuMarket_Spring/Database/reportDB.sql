
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


select * from report
