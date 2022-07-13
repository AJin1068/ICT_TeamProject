
create sequence seq_report_idx

create table report
(
	re_idx			int,	-- �Ϸù�ȣ
	u_idx 			int,	-- ȸ����ȣ
	re_add_cnt		int,	-- ����
	re_fake_cnt,	int,	-- ��ǰ ������(��ǰ/�߸��� ��ǰ)
	re_inhibit_cnt	int,	-- �ŷ�������ǰ(���/�ַ�/������/�����..)
	re_scam_cnt		int,	-- ���(�Ǵ� ���ġ���� �ǵ�)
	re_score		int
)

------ ��������
alter table report
	add constraint pk_report_idx primary key(re_idx);